package com.manav.crystal.items;

import com.manav.crystal.tooltypes.CrystalTool;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MagicBone extends CrystalTool {

	public MagicBone(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote() == false) {
			WolfEntity wolf = new WolfEntity(EntityType.WOLF, worldIn);
			wolf.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
			wolf.setTamedBy(playerIn);
			worldIn.addEntity(wolf);
		}
		
		return new ActionResult<ItemStack>(ActionResultType.PASS, ItemStack.EMPTY);
	}
}
