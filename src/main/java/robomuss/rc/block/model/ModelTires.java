package robomuss.rc.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTires extends ModelBase {
	//fields
	ModelRenderer Tire1;
	ModelRenderer Tire2;
	ModelRenderer Tire3;
	ModelRenderer Tire4;
	ModelRenderer Bar1;
	ModelRenderer Bar2;
	ModelRenderer Bar3;
	ModelRenderer Bar4;
	ModelRenderer Bar5;
	ModelRenderer Bar6;

	public ModelTires() {
		textureWidth = 64;
		textureHeight = 32;

		Tire1 = new ModelRenderer(this, 0, 0);
		Tire1.addBox(0F, 0F, 0F, 3, 2, 3);
		Tire1.setRotationPoint(2F, 17F, 0.5F);
		Tire1.setTextureSize(64, 32);
		Tire1.mirror = true;
		setRotation(Tire1, 0F, 0F, 0F);
		Tire2 = new ModelRenderer(this, 0, 0);
		Tire2.addBox(0F, 0F, 0F, 3, 2, 3);
		Tire2.setRotationPoint(2F, 17F, -3.5F);
		Tire2.setTextureSize(64, 32);
		Tire2.mirror = true;
		setRotation(Tire2, 0F, 0F, 0F);
		Tire3 = new ModelRenderer(this, 0, 0);
		Tire3.addBox(0F, 0F, 0F, 3, 2, 3);
		Tire3.setRotationPoint(-5F, 17F, 0.5F);
		Tire3.setTextureSize(64, 32);
		Tire3.mirror = true;
		setRotation(Tire3, 0F, 0F, 0F);
		Tire4 = new ModelRenderer(this, 0, 0);
		Tire4.addBox(0F, 0F, 0F, 3, 2, 3);
		Tire4.setRotationPoint(-5F, 17F, -3.5F);
		Tire4.setTextureSize(64, 32);
		Tire4.mirror = true;
		setRotation(Tire4, 0F, 0F, 0F);
		Bar1 = new ModelRenderer(this, 0, 5);
		Bar1.addBox(0F, 0F, 0F, 1, 1, 5);
		Bar1.setRotationPoint(3F, 20F, -2.5F);
		Bar1.setTextureSize(64, 32);
		Bar1.mirror = true;
		setRotation(Bar1, 0F, 0F, 0F);
		Bar2 = new ModelRenderer(this, 0, 5);
		Bar2.addBox(0F, 0F, 0F, 1, 1, 5);
		Bar2.setRotationPoint(-4F, 20F, -2.5F);
		Bar2.setTextureSize(64, 32);
		Bar2.mirror = true;
		setRotation(Bar2, 0F, 0F, 0F);
		Bar3 = new ModelRenderer(this, 0, 11);
		Bar3.addBox(0F, 0F, 0F, 1, 1, 1);
		Bar3.setRotationPoint(3F, 19F, -2.5F);
		Bar3.setTextureSize(64, 32);
		Bar3.mirror = true;
		setRotation(Bar3, 0F, 0F, 0F);
		Bar4 = new ModelRenderer(this, 0, 11);
		Bar4.addBox(0F, 0F, 0F, 1, 1, 1);
		Bar4.setRotationPoint(3F, 19F, 1.5F);
		Bar4.setTextureSize(64, 32);
		Bar4.mirror = true;
		setRotation(Bar4, 0F, 0F, 0F);
		Bar5 = new ModelRenderer(this, 0, 11);
		Bar5.addBox(0F, 0F, 0F, 1, 1, 1);
		Bar5.setRotationPoint(-4F, 19F, 1.5F);
		Bar5.setTextureSize(64, 32);
		Bar5.mirror = true;
		setRotation(Bar5, 0F, 0F, 0F);
		Bar6 = new ModelRenderer(this, 0, 11);
		Bar6.addBox(0F, 0F, 0F, 1, 1, 1);
		Bar6.setRotationPoint(-4F, 19F, -2.5F);
		Bar6.setTextureSize(64, 32);
		Bar6.mirror = true;
		setRotation(Bar6, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Tire1.render(f5);
		Tire2.render(f5);
		Tire3.render(f5);
		Tire4.render(f5);
		Bar1.render(f5);
		Bar2.render(f5);
		Bar3.render(f5);
		Bar4.render(f5);
		Bar5.render(f5);
		Bar6.render(f5);
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
