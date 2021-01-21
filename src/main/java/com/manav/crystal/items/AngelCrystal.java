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

public class AngelCrystal extends CrystalTool {

	public AngelCrystal(IItemTier tier, int maxDamage, float attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote() == false) {
			playerIn.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 1000000, 3, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 1000000, 2, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1000000, 2, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1000000, 3, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 1000000, 2, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 1000000, 1, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1000000, 0, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 1000000, 255, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 1000000, 255, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 1000000, 255, true, true));
			playerIn.addPotionEffect(new EffectInstance(Effects.LUCK, 1000000, 255, true, true));
			playerIn.sendBreakAnimation(playerIn.getActiveHand());
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
