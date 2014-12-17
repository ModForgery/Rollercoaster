package robomuss.rc.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrakes extends ModelBase {
	//fields
	ModelRenderer Brake1;
	ModelRenderer Brake2;
	ModelRenderer Extra1;
	ModelRenderer Extra2;
	ModelRenderer Extra3;
	ModelRenderer Extra4;

	public ModelBrakes() {
		textureWidth = 64;
		textureHeight = 32;

		Brake1 = new ModelRenderer(this, 0, 0);
		Brake1.addBox(0F, 0F, 0F, 12, 2, 1);
		Brake1.setRotationPoint(-6F, 17F, 1.5F);
		Brake1.setTextureSize(64, 32);
		Brake1.mirror = true;
		setRotation(Brake1, 0F, 0F, 0F);
		Brake2 = new ModelRenderer(this, 26, 0);
		Brake2.addBox(0F, 0F, 0F, 12, 2, 1);
		Brake2.setRotationPoint(-6F, 17F, -2.5F);
		Brake2.setTextureSize(64, 32);
		Brake2.mirror = true;
		setRotation(Brake2, 0F, 0F, 0F);
		Extra1 = new ModelRenderer(this, 0, 3);
		Extra1.addBox(0F, 0F, 0F, 1, 4, 1);
		Extra1.setRotationPoint(-4F, 18F, 2F);
		Extra1.setTextureSize(64, 32);
		Extra1.mirror = true;
		setRotation(Extra1, 0F, 0F, 0F);
		Extra2 = new ModelRenderer(this, 0, 3);
		Extra2.addBox(0F, 0F, 0F, 1, 4, 1);
		Extra2.setRotationPoint(3F, 18F, 2F);
		Extra2.setTextureSize(64, 32);
		Extra2.mirror = true;
		setRotation(Extra2, 0F, 0F, 0F);
		Extra3 = new ModelRenderer(this, 0, 3);
		Extra3.addBox(0F, 0F, 0F, 1, 4, 1);
		Extra3.setRotationPoint(3F, 18F, -3F);
		Extra3.setTextureSize(64, 32);
		Extra3.mirror = true;
		setRotation(Extra3, 0F, 0F, 0F);
		Extra4 = new ModelRenderer(this, 0, 3);
		Extra4.addBox(0F, 0F, 0F, 1, 4, 1);
		Extra4.setRotationPoint(-4F, 18F, -3F);
		Extra4.setTextureSize(64, 32);
		Extra4.mirror = true;
		setRotation(Extra4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Brake1.render(f5);
		Brake2.render(f5);
		Extra1.render(f5);
		Extra2.render(f5);
		Extra3.render(f5);
		Extra4.render(f5);
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
