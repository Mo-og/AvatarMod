package com.crowsofwar.gorecore.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Scanner;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;

import jline.internal.Nullable;

/**
 * 
 * 
 * @author CrowsOfWar
 */
public class ConfigLoader {
	
	private final String path;
	private Map<String, Object> values;
	
	private ConfigLoader(String path) {
		this.path = path;
	}
	
	/**
	 * Load a Map containing the YAML configurations at that path.
	 * 
	 * @param path
	 *            Path starting at ".minecraft/config/"
	 * 
	 * @throws ConfigurationException
	 *             when an error occurs while trying to read the file
	 */
	private static Map<String, Object> loadMap(String path) {
		
		try {
			
			String contents = "";
			
			File file = new File("config/" + path);
			file.createNewFile();
			
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
				contents += scanner.nextLine() + "\n";
			scanner.close();
			
			Yaml yaml = new Yaml();
			Map<String, Object> map = (Map) yaml.load(contents);
			
			return map;
			
		} catch (IOException e) {
			throw new ConfigurationException.LoadingException(
					"Exception trying to load config file at config/" + path, e);
		} catch (ClassCastException e) {
			throw new ConfigurationException.UserMistake(
					"Invalid configuration file at config/" + path + ": not a map");
		}
		
	}
	
	/**
	 * Populate the object's fields marked with with {@link Load} with data from the configuration
	 * file.
	 * <p>
	 * If fields are already set (i.e. not null), their current values will only be preserved if
	 * there is not entry in configuration.
	 * <p>
	 * If an object is being loaded, ConfigLoader will attempt to load that object the same way that
	 * <code>obj</code> is being loaded. If a {@link HasCustomLoader custom loader} is specified,
	 * ConfigLoader will call that loader to perform any additional modifications after loading
	 * the @Load fields.
	 * 
	 * @param obj
	 *            Object to load
	 * @param path
	 *            Path to the configuration file, from ".minecraft/config/"
	 */
	public static void load(Object obj, String path) {
		ConfigLoader loader = new ConfigLoader(path);
		loader.values = loadMap(path);
		loader.load(obj.getClass(), obj, loader.values);
		loader.save();
	}
	
	/**
	 * Same as {@link #load(Object, String)}, but works for static fields.
	 */
	public static void load(Class<?> cls, String path) {
		ConfigLoader loader = new ConfigLoader(path);
		loader.values = loadMap(path);
		loader.load(cls, null, loader.values);
		loader.save();
	}
	
	/**
	 * Populate that object's fields marked with {@link Load} with data from the configuration map.
	 * 
	 * @param cls
	 *            Class to get fields from. Normally it would be <code>obj.getClass()</code>.
	 * @param obj
	 *            Object to load
	 * @param data
	 *            Map containing configuration data
	 * 
	 * @throws ConfigurationException
	 */
	private void load(Class<?> cls, @Nullable Object obj, Map<String, ?> data) {
		
		try {
			
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				
				if (field.getAnnotation(Load.class) != null) {
					System.out.println("Should load " + field.getName());
					// Should load this field
					
					HasCustomLoader loaderAnnotation = field.getType().getAnnotation(HasCustomLoader.class);
					
					System.out.println("------------" + data);
					Object fromData = data.get(field.getName());
					Object instance;
					
					if (fromData == null) {
						
						if (field.get(obj) != null) {
							instance = field.get(obj);
							values.put(field.getName(), instance);
						} else {
							throw new ConfigurationException.UserMistake(
									"No configured definition for " + field.getName() + ", no default value");
						}
						
					} else {
						if (fromData instanceof Map<?, ?> && !field.getType().isAssignableFrom(Map.class)) {
							instance = field.getType().newInstance();
							if (loaderAnnotation.loadMarkedFields())
								load(instance.getClass(), instance, (Map) fromData);
						} else {
							instance = fromData;
						}
					}
					
					if (loaderAnnotation != null)
						loaderAnnotation.loaderClass().newInstance().load(null, instance);
					
					field.set(obj, instance);
					
				}
				
			}
			
		} catch (ReflectiveOperationException e) {
			throw new ConfigurationException.ReflectionException(
					"Exception while setting values of configuration object", e);
		}
		
	}
	
	private void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("config/" + path)));
			
			DumperOptions options = new DumperOptions();
			options.setPrettyFlow(true);
			options.setDefaultFlowStyle(FlowStyle.BLOCK);
			
			String asText = "";
			Yaml yaml = new Yaml(options);
			asText = yaml.dump(values);
			
			writer.write(asText);
			writer.close();
			
		} catch (IOException e) {
			
			throw new ConfigurationException.LoadingException("Exception while trying to save config file",
					e);
			
		}
		
	}
	
	// TODO Implement
	/**
	 * Return a yaml representation of that object.
	 */
	public static String yaml(Object obj) {
		return null;
	}
	
}