package com.manav.crystal.items;

import com.manav.crystal.tooltypes.CrystalTool;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AquaCrystal extends CrystalTool {

	public AquaCrystal(IItemTier tier, int maxDamage, float attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote() == false) {
			playerIn.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 1000000, 2, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 1000000, 2, true, true));
			playerIn.sendBreakAnimation(playerIn.getActiveHand());
		}

		return new ActionResult<ItemStack>(ActionResultType.PASS, ItemStack.EMPTY);
	}
}
