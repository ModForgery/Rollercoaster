package robomuss.rc.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRideFenceGate extends ModelBase {
	//fields
	public ModelRenderer pole1;
	public ModelRenderer pole2;
	public ModelRenderer bar1;
	public ModelRenderer bar2;
	public ModelRenderer bar3;
	public ModelRenderer bar4;
	public ModelRenderer bar5;
	public ModelRenderer bar6;
	public ModelRenderer bar7;
	public ModelRenderer bar8;
	public ModelRenderer bar9;
	public ModelRenderer bar10;

	public ModelRideFenceGate() {
		textureWidth = 64;
		textureHeight = 32;

		pole1 = new ModelRenderer(this, 0, 0);
		pole1.addBox(0F, 0F, 0F, 3, 12, 4);
		pole1.setRotationPoint(-8F, 12F, -2F);
		pole1.setTextureSize(64, 32);
		pole1.mirror = true;
		setRotation(pole1, 0F, 0F, 0F);
		pole2 = new ModelRenderer(this, 0, 0);
		pole2.addBox(0F, 0F, 0F, 3, 12, 4);
		pole2.setRotationPoint(5F, 12F, -2F);
		pole2.setTextureSize(64, 32);
		pole2.mirror = true;
		setRotation(pole2, 0F, 0F, 0F);
		bar1 = new ModelRenderer(this, 0, 0);
		bar1.addBox(0F, 0F, 0F, 4, 1, 1);
		bar1.setRotationPoint(-5.5F, 13F, -0.5F);
		bar1.setTextureSize(64, 32);
		bar1.mirror = true;
		setRotation(bar1, 0F, 0F, 0F);
		bar2 = new ModelRenderer(this, 0, 0);
		bar2.addBox(0F, 0F, 0F, 1, 10, 1);
		bar2.setRotationPoint(-1.5F, 13F, -0.5F);
		bar2.setTextureSize(64, 32);
		bar2.mirror = true;
		setRotation(bar2, 0F, 0F, 0F);
		bar3 = new ModelRenderer(this, 0, 0);
		bar3.addBox(0F, 0F, 0F, 4, 1, 1);
		bar3.setRotationPoint(-5.5F, 22F, -0.5F);
		bar3.setTextureSize(64, 32);
		bar3.mirror = true;
		setRotation(bar3, 0F, 0F, 0F);
		bar4 = new ModelRenderer(this, 0, 0);
		bar4.addBox(0F, 0F, 0F, 4, 1, 1);
		bar4.setRotationPoint(1.5F, 13F, -0.5F);
		bar4.setTextureSize(64, 32);
		bar4.mirror = true;
		setRotation(bar4, 0F, 0F, 0F);
		bar5 = new ModelRenderer(this, 0, 0);
		bar5.addBox(0F, 0F, 0F, 1, 10, 1);
		bar5.setRotationPoint(0.5F, 13F, -0.5F);
		bar5.setTextureSize(64, 32);
		bar5.mirror = true;
		setRotation(bar5, 0F, 0F, 0F);
		bar6 = new ModelRenderer(this, 0, 0);
		bar6.addBox(0F, 0F, 0F, 4, 1, 1);
		bar6.setRotationPoint(1.5F, 22F, -0.5F);
		bar6.setTextureSize(64, 32);
		bar6.mirror = true;
		setRotation(bar6, 0F, 0F, 0F);
		bar7 = new ModelRenderer(this, 0, 0);
		bar7.addBox(0F, 0F, 0F, 4, 1, 1);
		bar7.setRotationPoint(1.5F, 19F, -0.5F);
		bar7.setTextureSize(64, 32);
		bar7.mirror = true;
		setRotation(bar7, 0F, 0F, 0F);
		bar8 = new ModelRenderer(this, 0, 0);
		bar8.addBox(0F, 0F, 0F, 4, 1, 1);
		bar8.setRotationPoint(1.5F, 16F, -0.5F);
		bar8.setTextureSize(64, 32);
		bar8.mirror = true;
		setRotation(bar8, 0F, 0F, 0F);
		bar9 = new ModelRenderer(this, 0, 0);
		bar9.addBox(0F, 0F, 0F, 4, 1, 1);
		bar9.setRotationPoint(-5.5F, 19F, -0.5F);
		bar9.setTextureSize(64, 32);
		bar9.mirror = true;
		setRotation(bar9, 0F, 0F, 0F);
		bar10 = new ModelRenderer(this, 0, 0);
		bar10.addBox(0F, 0F, 0F, 4, 1, 1);
		bar10.setRotationPoint(-5.5F, 16F, -0.5F);
		bar10.setTextureSize(64, 32);
		bar10.mirror = true;
		setRotation(bar10, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		pole1.render(f5);
		pole2.render(f5);
		bar1.render(f5);
		bar2.render(f5);
		bar3.render(f5);
		bar4.render(f5);
		bar5.render(f5);
		bar6.render(f5);
		bar7.render(f5);
		bar8.render(f5);
		bar9.render(f5);
		bar10.render(f5);
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
