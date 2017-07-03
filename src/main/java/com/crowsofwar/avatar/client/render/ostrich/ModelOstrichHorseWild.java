package com.crowsofwar.avatar.client.render.ostrich;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * OstrichHorse Wild - talhanation Created using Tabula 5.1.0
 */
public class ModelOstrichHorseWild extends ModelBase {
	public ModelRenderer BodyMain;
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer Body5;
	public ModelRenderer Body6;
	public ModelRenderer Body7;
	public ModelRenderer Body8;
	public ModelRenderer Body9;
	public ModelRenderer Body10;
	public ModelRenderer RWing1;
	public ModelRenderer RWing2;
	public ModelRenderer LWing1;
	public ModelRenderer LWing2;
	public ModelRenderer MainTail;
	public ModelRenderer neck1;
	public ModelRenderer Lleg;
	public ModelRenderer Rleg;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tail4;
	public ModelRenderer tail5;
	public ModelRenderer tail7;
	public ModelRenderer tail10;
	public ModelRenderer tail6;
	public ModelRenderer tail8;
	public ModelRenderer tail9;
	public ModelRenderer head;
	public ModelRenderer neck2;
	public ModelRenderer neck3;
	public ModelRenderer MainHair;
	public ModelRenderer beak1;
	public ModelRenderer LEar;
	public ModelRenderer REar;
	public ModelRenderer beak2;
	public ModelRenderer hair2;
	public ModelRenderer hair1;
	public ModelRenderer hair4;
	public ModelRenderer hair3;
	public ModelRenderer hair5;
	public ModelRenderer Lleg3;
	public ModelRenderer Lleg2;
	public ModelRenderer Lfoot;
	public ModelRenderer Lcrawl;
	public ModelRenderer Lrcrawl1;
	public ModelRenderer Lrcrawl2;
	public ModelRenderer Llcrawl1;
	public ModelRenderer Llcrawl2;
	public ModelRenderer Rleg2;
	public ModelRenderer Rleg3;
	public ModelRenderer Rfoot;
	public ModelRenderer Rcrawl;
	public ModelRenderer Rrcrawl1;
	public ModelRenderer Rrcrawl2;
	public ModelRenderer Rlcrawl1;
	public ModelRenderer Rlcrawl2;
	
	public ModelOstrichHorseWild() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.RWing2 = new ModelRenderer(this, 170, 100);
		this.RWing2.setRotationPoint(-6.099999904632568F, -2.0F, -8.0F);
		this.RWing2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 14, 0.0F);
		this.setRotateAngle(RWing2, -0.010895759412096489F, -0.051214677319632605F, 0.20971859122976902F);
		this.Rfoot = new ModelRenderer(this, 117, 2);
		this.Rfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rfoot.addBox(-3.5F, 17.0F, -3.5F, 3, 1, 3, 0.0F);
		this.setRotateAngle(Rfoot, -0.2617993877991494F, -0.0F, 0.0F);
		this.hair3 = new ModelRenderer(this, 21, 99);
		this.hair3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hair3.addBox(2.0F, -6.0F, 4.1F, 0, 3, 1, 0.0F);
		this.setRotateAngle(hair3, 0.2617993877991494F, 0.0F, 0.0F);
		this.tail5 = new ModelRenderer(this, 10, 100);
		this.tail5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0, 0.0F);
		this.Rrcrawl2 = new ModelRenderer(this, 117, 2);
		this.Rrcrawl2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rrcrawl2.addBox(-3.5F, 17.0F, -6.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Rrcrawl2, -0.2617993877991494F, -0.0F, 0.0F);
		this.hair2 = new ModelRenderer(this, 21, 99);
		this.hair2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hair2.addBox(-1.0F, -6.0F, 5.2F, 0, 3, 1, 0.0F);
		this.setRotateAngle(hair2, 0.2617993877991494F, 0.0F, 0.0F);
		this.MainHair = new ModelRenderer(this, 20, 100);
		this.MainHair.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.MainHair.addBox(-1.0F, -13.9F, 4.2F, 3, 8, 2, 0.0F);
		this.setRotateAngle(MainHair, 0.2617993877991494F, -0.0F, 0.0F);
		this.LEar = new ModelRenderer(this, 0, 0);
		this.LEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LEar.addBox(1.5F, -15.5F, 2.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LEar, 0.2617993877991494F, -0.0F, 0.0F);
		this.neck2 = new ModelRenderer(this, 217, 14);
		this.neck2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck2.addBox(-1.5F, -11.1F, -0.8F, 4, 5, 5, 0.0F);
		this.setRotateAngle(neck2, 0.2617993877991494F, -0.0F, 0.0F);
		this.Llcrawl1 = new ModelRenderer(this, 107, 0);
		this.Llcrawl1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Llcrawl1.addBox(2.5F, 14.7F, -11.7F, 1, 1, 1, 0.0F);
		this.Llcrawl2 = new ModelRenderer(this, 117, 2);
		this.Llcrawl2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Llcrawl2.addBox(2.5F, 17.0F, -6.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Llcrawl2, -0.2617993877991494F, -0.0F, 0.0F);
		this.Body4 = new ModelRenderer(this, 205, 100);
		this.Body4.setRotationPoint(-5.0F, -0.3100000023841858F, -9.890000343322754F);
		this.Body4.addBox(0.0F, 0.0F, 0.0F, 10, 4, 4, 0.0F);
		this.setRotateAngle(Body4, -1.5707963705062866F, -0.0F, 0.0F);
		this.Body7 = new ModelRenderer(this, 60, 85);
		this.Body7.setRotationPoint(-5.0F, -1.8200000524520874F, -8.649999618530273F);
		this.Body7.addBox(0.0F, -1.0F, -3.0F, 10, 4, 5, 0.0F);
		this.setRotateAngle(Body7, -2.268928050994873F, -0.0F, 0.0F);
		this.Lleg = new ModelRenderer(this, 140, 16);
		this.Lleg.setRotationPoint(3.0F, 6.0F, -1.0F);
		this.Lleg.addBox(0.0F, -2.0F, -4.0F, 4, 6, 8, 0.0F);
		this.setRotateAngle(Lleg, 0.2617993877991494F, 0.0F, 0.0F);
		this.Rlcrawl1 = new ModelRenderer(this, 107, 0);
		this.Rlcrawl1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rlcrawl1.addBox(-1.5F, 14.7F, -11.7F, 1, 1, 1, 0.0F);
		this.beak2 = new ModelRenderer(this, 0, 0);
		this.beak2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.beak2.addBox(-0.9F, -12.0F, -6.5F, 3, 2, 4, 0.0F);
		this.setRotateAngle(beak2, 0.22689280275926282F, -0.0F, 0.0F);
		this.tail1 = new ModelRenderer(this, 10, 100);
		this.tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail1.addBox(3.0F, 8.0F, 0.0F, 0, 3, 1, 0.0F);
		this.tail7 = new ModelRenderer(this, 10, 100);
		this.tail7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail7.addBox(0.0F, 8.0F, 0.0F, 3, 2, 0, 0.0F);
		this.Body2 = new ModelRenderer(this, 205, 111);
		this.Body2.setRotationPoint(-5.0F, 2.0999999046325684F, -9.0F);
		this.Body2.addBox(0.0F, 0.5600000023841858F, -2.299999952316284F, 10, 4, 4, 0.0F);
		this.setRotateAngle(Body2, -0.7853981852531433F, -0.0F, 0.0F);
		this.neck1 = new ModelRenderer(this, 194, 4);
		this.neck1.setRotationPoint(-0.5F, -4.0F, -9.0F);
		this.neck1.addBox(-2.0F, -7.0F, -2.5F, 5, 8, 5, 0.0F);
		this.LWing1 = new ModelRenderer(this, 170, 100);
		this.LWing1.setRotationPoint(5.0F, -3.0F, -11.0F);
		this.LWing1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 13, 0.0F);
		this.setRotateAngle(LWing1, -0.2726951544964776F, 0.051214677319632605F, -0.20971859122976902F);
		this.Body8 = new ModelRenderer(this, 205, 85);
		this.Body8.setRotationPoint(-5.0F, 4.190000057220459F, -8.6899995803833F);
		this.Body8.addBox(0.0F, 0.03999999910593033F, -1.2400000095367432F, 10, 3, 4, 0.0F);
		this.setRotateAngle(Body8, -0.39269909262657166F, -0.0F, 0.0F);
		this.MainTail = new ModelRenderer(this, 20, 100);
		this.MainTail.setRotationPoint(-1.5F, -0.800000011920929F, 11.0F);
		this.MainTail.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
		this.head = new ModelRenderer(this, 167, 5);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -14.0F, -2.7F, 5, 4, 7, 0.0F);
		this.setRotateAngle(head, 0.2617993877991494F, -0.0F, 0.0F);
		this.neck3 = new ModelRenderer(this, 137, 0);
		this.neck3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck3.addBox(-1.0F, -7.2F, -8.9F, 3, 2, 3, 0.0F);
		this.setRotateAngle(neck3, -0.5235987755982988F, -0.0F, 0.0F);
		this.hair4 = new ModelRenderer(this, 21, 99);
		this.hair4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hair4.addBox(0.0F, -6.0F, 6.1F, 1, 3, 0, 0.0F);
		this.setRotateAngle(hair4, 0.2617993877991494F, 0.0F, 0.0F);
		this.Lleg3 = new ModelRenderer(this, 100, 16);
		this.Lleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lleg3.addBox(1.0F, 6.0F, 1.0F, 2, 11, 3, 0.0F);
		this.setRotateAngle(Lleg3, -0.5235987755982988F, -0.0F, 0.0F);
		this.Rcrawl = new ModelRenderer(this, 117, 2);
		this.Rcrawl.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rcrawl.addBox(-2.5F, 17.0F, 1.3F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Rcrawl, -0.3665191429188092F, -0.0F, 0.0F);
		this.Body10 = new ModelRenderer(this, 211, 30);
		this.Body10.setRotationPoint(-5.0F, 3.0F, 7.309999942779541F);
		this.Body10.addBox(0.0F, 0.03999999910593033F, -1.7999999523162842F, 10, 3, 5, 0.0F);
		this.setRotateAngle(Body10, 0.2094395160675048F, -0.0F, 0.0F);
		this.tail9 = new ModelRenderer(this, 10, 100);
		this.tail9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail9.addBox(0.0F, 8.0F, 3.0F, 1, 2, 0, 0.0F);
		this.Lrcrawl2 = new ModelRenderer(this, 117, 2);
		this.Lrcrawl2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lrcrawl2.addBox(0.5F, 17.0F, -6.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Lrcrawl2, -0.2617993877991494F, -0.0F, 0.0F);
		this.tail8 = new ModelRenderer(this, 10, 100);
		this.tail8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8.addBox(3.0F, 8.0F, 2.0F, 0, 2, 1, 0.0F);
		this.tail6 = new ModelRenderer(this, 10, 100);
		this.tail6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail6.addBox(0.0F, 10.0F, 0.0F, 0, 2, 1, 0.0F);
		this.beak1 = new ModelRenderer(this, 0, 0);
		this.beak1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.beak1.addBox(-0.5F, -13.7F, -0.8F, 2, 2, 5, 0.0F);
		this.setRotateAngle(beak1, 0.7504915783575618F, -0.0F, 0.0F);
		this.Lrcrawl1 = new ModelRenderer(this, 107, 0);
		this.Lrcrawl1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lrcrawl1.addBox(0.5F, 14.7F, -11.7F, 1, 1, 1, 0.0F);
		this.tail4 = new ModelRenderer(this, 10, 100);
		this.tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail4.addBox(0.0F, 10.0F, 0.0F, 1, 2, 0, 0.0F);
		this.Rlcrawl2 = new ModelRenderer(this, 117, 2);
		this.Rlcrawl2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rlcrawl2.addBox(-1.5F, 17.0F, -6.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Rlcrawl2, -0.2617993877991494F, -0.0F, 0.0F);
		this.BodyMain = new ModelRenderer(this, 100, 100);
		this.BodyMain.setRotationPoint(-5.5F, -0.699999988079071F, -9.899999618530273F);
		this.BodyMain.addBox(0.0F, 0.0F, 0.0F, 11, 6, 21, 0.0F);
		this.Body6 = new ModelRenderer(this, 100, 60);
		this.Body6.setRotationPoint(-4.5F, -2.5F, -8.0F);
		this.Body6.addBox(0.0F, -1.0F, -2.0F, 9, 5, 17, 0.0F);
		this.REar = new ModelRenderer(this, 0, 0);
		this.REar.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.REar.addBox(-1.5F, -15.5F, 2.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(REar, 0.2617993877991494F, -0.0F, 0.0F);
		this.Rleg2 = new ModelRenderer(this, 120, 16);
		this.Rleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rleg2.addBox(-3.5F, 2.0F, -3.0F, 3, 7, 5, 0.0F);
		this.hair5 = new ModelRenderer(this, 21, 99);
		this.hair5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hair5.addBox(0.9F, -6.0F, 6.1F, 1, 1, 0, 0.0F);
		this.setRotateAngle(hair5, 0.2617993877991494F, 0.0F, 0.0F);
		this.hair1 = new ModelRenderer(this, 21, 99);
		this.hair1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hair1.addBox(-1.0F, -6.0F, 6.1F, 1, 2, 0, 0.0F);
		this.setRotateAngle(hair1, 0.2617993877991494F, 0.0F, 0.0F);
		this.Lcrawl = new ModelRenderer(this, 117, 2);
		this.Lcrawl.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lcrawl.addBox(1.5F, 17.0F, 1.3F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Lcrawl, -0.3665191429188092F, -0.0F, 0.0F);
		this.tail10 = new ModelRenderer(this, 10, 100);
		this.tail10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail10.addBox(2.0F, 8.0F, 3.0F, 1, 3, 0, 0.0F);
		this.Body9 = new ModelRenderer(this, 211, 44);
		this.Body9.setRotationPoint(-5.0F, 4.849999904632568F, 3.309999942779541F);
		this.Body9.addBox(0.0F, 0.03999999910593033F, -1.2400000095367432F, 10, 3, 4, 0.0F);
		this.setRotateAngle(Body9, 0.5235987901687622F, -0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 10, 100);
		this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail2.addBox(0.0F, 8.0F, 2.0F, 0, 3, 1, 0.0F);
		this.tail3 = new ModelRenderer(this, 10, 100);
		this.tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail3.addBox(0.0F, 8.0F, 0.0F, 0, 2, 1, 0.0F);
		this.Body1 = new ModelRenderer(this, 60, 100);
		this.Body1.setRotationPoint(-5.0F, -3.0F, 8.5F);
		this.Body1.addBox(0.0F, 0.42500001192092896F, -1.600000023841858F, 10, 3, 5, 0.0F);
		this.setRotateAngle(Body1, -0.5759586691856385F, -0.0F, 0.0F);
		this.RWing1 = new ModelRenderer(this, 170, 100);
		this.RWing1.setRotationPoint(-6.199999809265137F, -3.0F, -11.0F);
		this.RWing1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 13, 0.0F);
		this.setRotateAngle(RWing1, -0.2726951544964776F, -0.051214677319632605F, 0.20971859122976902F);
		this.Rrcrawl1 = new ModelRenderer(this, 107, 0);
		this.Rrcrawl1.setRotationPoint(-0.0F, 0.0F, 0.0F);
		this.Rrcrawl1.addBox(-3.5F, 14.7F, -11.7F, 1, 1, 1, 0.0F);
		this.Rleg3 = new ModelRenderer(this, 100, 16);
		this.Rleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Rleg3.addBox(-3.0F, 6.0F, 1.0F, 2, 11, 3, 0.0F);
		this.setRotateAngle(Rleg3, -0.5235987755982988F, -0.0F, 0.0F);
		this.Body3 = new ModelRenderer(this, 168, 63);
		this.Body3.setRotationPoint(-5.0F, 5.099999904632568F, -7.300000190734863F);
		this.Body3.addBox(0.0F, 0.0F, 0.0F, 10, 3, 11, 0.0F);
		this.Lleg2 = new ModelRenderer(this, 120, 16);
		this.Lleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lleg2.addBox(0.5F, 2.0F, -3.0F, 3, 7, 5, 0.0F);
		this.Lfoot = new ModelRenderer(this, 117, 2);
		this.Lfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Lfoot.addBox(0.5F, 17.0F, -3.5F, 3, 1, 3, 0.0F);
		this.setRotateAngle(Lfoot, -0.2617993877991494F, -0.0F, 0.0F);
		this.Body5 = new ModelRenderer(this, 174, 43);
		this.Body5.setRotationPoint(-5.5F, 0.18000000715255737F, -10.300000190734863F);
		this.Body5.addBox(0.0F, -1.0F, -2.0F, 11, 4, 4, 0.0F);
		this.setRotateAngle(Body5, -2.268928050994873F, -0.0F, 0.0F);
		this.Rleg = new ModelRenderer(this, 140, 16);
		this.Rleg.setRotationPoint(-3.0F, 6.0F, -1.0F);
		this.Rleg.addBox(-4.0F, -2.0F, -4.0F, 4, 6, 8, 0.0F);
		this.setRotateAngle(Rleg, 0.2617993877991494F, -0.0F, 0.0F);
		this.LWing2 = new ModelRenderer(this, 170, 100);
		this.LWing2.setRotationPoint(4.900000095367432F, -2.0F, -8.0F);
		this.LWing2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 14, 0.0F);
		this.setRotateAngle(LWing2, -0.010895759412096489F, 0.051214677319632605F, -0.20971859122976902F);
		this.Rleg.addChild(this.Rfoot);
		this.neck1.addChild(this.hair3);
		this.MainTail.addChild(this.tail5);
		this.Rleg.addChild(this.Rrcrawl2);
		this.neck1.addChild(this.hair2);
		this.neck1.addChild(this.MainHair);
		this.neck1.addChild(this.LEar);
		this.neck1.addChild(this.neck2);
		this.Lleg.addChild(this.Llcrawl1);
		this.Lleg.addChild(this.Llcrawl2);
		this.Rleg.addChild(this.Rlcrawl1);
		this.neck1.addChild(this.beak2);
		this.MainTail.addChild(this.tail1);
		this.MainTail.addChild(this.tail7);
		this.neck1.addChild(this.head);
		this.neck1.addChild(this.neck3);
		this.neck1.addChild(this.hair4);
		this.Lleg.addChild(this.Lleg3);
		this.Rleg.addChild(this.Rcrawl);
		this.MainTail.addChild(this.tail9);
		this.Lleg.addChild(this.Lrcrawl2);
		this.MainTail.addChild(this.tail8);
		this.MainTail.addChild(this.tail6);
		this.neck1.addChild(this.beak1);
		this.Lleg.addChild(this.Lrcrawl1);
		this.MainTail.addChild(this.tail4);
		this.Rleg.addChild(this.Rlcrawl2);
		this.neck1.addChild(this.REar);
		this.Rleg.addChild(this.Rleg2);
		this.neck1.addChild(this.hair5);
		this.neck1.addChild(this.hair1);
		this.Lleg.addChild(this.Lcrawl);
		this.MainTail.addChild(this.tail10);
		this.MainTail.addChild(this.tail2);
		this.MainTail.addChild(this.tail3);
		this.Rleg.addChild(this.Rrcrawl1);
		this.Rleg.addChild(this.Rleg3);
		this.Lleg.addChild(this.Lleg2);
		this.Lleg.addChild(this.Lfoot);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.RWing2.render(f5);
		this.Body4.render(f5);
		this.Body7.render(f5);
		this.Lleg.render(f5);
		this.Body2.render(f5);
		this.neck1.render(f5);
		this.LWing1.render(f5);
		this.Body8.render(f5);
		this.MainTail.render(f5);
		this.Body10.render(f5);
		this.BodyMain.render(f5);
		this.Body6.render(f5);
		this.Body9.render(f5);
		this.Body1.render(f5);
		this.RWing1.render(f5);
		this.Body3.render(f5);
		this.Body5.render(f5);
		this.Rleg.render(f5);
		this.LWing2.render(f5);
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	/**
	 * @author CrowsOfWar
	 */
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity ostrich) {
		
		// BodyMain.rotateAngleY = 0;
		neck1.rotateAngleY = (float) Math.toDegrees(netHeadYaw);
		neck1.rotateAngleX = (float) Math.toDegrees(headPitch);
		
	}
	
}
