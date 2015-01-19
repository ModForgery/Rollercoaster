package robomuss.rc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import robomuss.rc.util.ColourUtil;

import java.util.List;

public class ItemBalloon extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon icon;

	public ItemBalloon() {
		setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass) {
		int j = MathHelper.clamp_int(stack.getItemDamage(), 0, ColourUtil.numColours - 1);
		return ColourUtil.COLORS[j].ordinal();
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 15);
		return String.format("item.balloon.%s.name", ColourUtil.COLORS[i].unlocalized_name);
	}

	public String getItemStackDisplayName(ItemStack stack) {
		String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName())).trim();
		return s;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < ColourUtil.numColours; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		super.registerIcons(register);
		this.icon = register.registerIcon(this.getIconString() + "_overlay");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int dmg, int pass) {
        return pass > 0 ? this.icon : super.getIconFromDamageForRenderPass(dmg, pass);
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean update) {
		if (!world.isRemote) {
			if (entity instanceof EntityPlayer) {
//				if (((EntityPlayer) entity).getHeldItem().getItem().equals(this)) {
//					//TODO: spawn/render balloon here
//				}
			}
		}
	}
}
