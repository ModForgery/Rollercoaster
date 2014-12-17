package robomuss.rc.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrackFabricator extends ModelBase {
	//fields
	public ModelRenderer bottom;
	public ModelRenderer panel;
	public ModelRenderer pillar1;
	public ModelRenderer pillar2;
	public ModelRenderer pillar3;
	public ModelRenderer pillar4;
	public ModelRenderer top;
	public ModelRenderer part1;
	public ModelRenderer glass1;
	public ModelRenderer glass2;
	public ModelRenderer glass3;
	public ModelRenderer glass4;

	public ModelTrackFabricator() {
		textureWidth = 128;
		textureHeight = 64;

		bottom = new ModelRenderer(this, 0, 0);
		bottom.addBox(0F, 0F, 0F, 16, 1, 16);
		bottom.setRotationPoint(-8F, 23F, -8F);
		bottom.setTextureSize(128, 64);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		panel = new ModelRenderer(this, 74, 0);
		panel.addBox(0F, 0F, 0F, 14, 8, 3);
		panel.setRotationPoint(-7F, 15F, -7F);
		panel.setTextureSize(128, 64);
		panel.mirror = true;
		setRotation(panel, 0F, 0F, 0F);
		pillar1 = new ModelRenderer(this, 108, 0);
		pillar1.addBox(0F, 0F, 0F, 1, 14, 1);
		pillar1.setRotationPoint(7F, 9F, 7F);
		pillar1.setTextureSize(128, 64);
		pillar1.mirror = true;
		setRotation(pillar1, 0F, 0F, 0F);
		pillar2 = new ModelRenderer(this, 108, 0);
		pillar2.addBox(0F, 0F, 0F, 1, 14, 1);
		pillar2.setRotationPoint(-8F, 9F, 7F);
		pillar2.setTextureSize(128, 64);
		pillar2.mirror = true;
		setRotation(pillar2, 0F, 0F, 0F);
		pillar3 = new ModelRenderer(this, 64, 0);
		pillar3.addBox(0F, 0F, 0F, 1, 14, 4);
		pillar3.setRotationPoint(7F, 9F, -8F);
		pillar3.setTextureSize(128, 64);
		pillar3.mirror = true;
		setRotation(pillar3, 0F, 0F, 0F);
		pillar4 = new ModelRenderer(this, 64, 0);
		pillar4.addBox(0F, 0F, 0F, 1, 14, 4);
		pillar4.setRotationPoint(-8F, 9F, -8F);
		pillar4.setTextureSize(128, 64);
		pillar4.mirror = true;
		setRotation(pillar4, 0F, 0F, 0F);
		top = new ModelRenderer(this, 0, 0);
		top.addBox(0F, 0F, 0F, 16, 1, 16);
		top.setRotationPoint(-8F, 8F, -8F);
		top.setTextureSize(128, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		part1 = new ModelRenderer(this, 74, 11);
		part1.addBox(0F, 0F, 0F, 14, 1, 1);
		part1.setRotationPoint(-7F, 15F, -8F);
		part1.setTextureSize(128, 64);
		part1.mirror = true;
		setRotation(part1, 0F, 0F, 0F);
		glass1 = new ModelRenderer(this, 30, 32);
		glass1.addBox(0F, 0F, 0F, 1, 14, 11);
		glass1.setRotationPoint(-8F, 9F, -4F);
		glass1.setTextureSize(128, 64);
		glass1.mirror = true;
		setRotation(glass1, 0F, 0F, 0F);
		glass2 = new ModelRenderer(this, 0, 17);
		glass2.addBox(0F, 0F, 0F, 1, 14, 11);
		glass2.setRotationPoint(7F, 9F, -4F);
		glass2.setTextureSize(128, 64);
		glass2.mirror = true;
		setRotation(glass2, 0F, 0F, 0F);
		glass3 = new ModelRenderer(this, 24, 17);
		glass3.addBox(0F, 0F, 0F, 14, 14, 1);
		glass3.setRotationPoint(-7F, 9F, 7F);
		glass3.setTextureSize(128, 64);
		glass3.mirror = true;
		setRotation(glass3, 0F, 0F, 0F);
		glass4 = new ModelRenderer(this, 0, 42);
		glass4.addBox(0F, 0F, 0F, 14, 6, 1);
		glass4.setRotationPoint(-7F, 9F, -6F);
		glass4.setTextureSize(128, 64);
		glass4.mirror = true;
		setRotation(glass4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bottom.render(f5);
		panel.render(f5);
		pillar1.render(f5);
		pillar2.render(f5);
		pillar3.render(f5);
		pillar4.render(f5);
		top.render(f5);
		part1.render(f5);
		glass1.render(f5);
		glass2.render(f5);
		glass3.render(f5);
		glass4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

}
