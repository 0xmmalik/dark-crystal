package com.manav.crystal.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.manav.crystal.tooltypes.CrystalTool;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class UltraCrystal extends CrystalTool {
	
    private static Effect[] poss_effects = new Effect[]{
            Effects.SPEED,
            Effects.HASTE,
            Effects.STRENGTH,
            Effects.INSTANT_HEALTH,
            Effects.INSTANT_DAMAGE,
            Effects.JUMP_BOOST,
            Effects.REGENERATION,
            Effects.RESISTANCE,
            Effects.FIRE_RESISTANCE,
            Effects.WATER_BREATHING,
            Effects.NIGHT_VISION,
            Effects.HEALTH_BOOST,
            Effects.SATURATION,
            Effects.LUCK,
            Effects.CONDUIT_POWER,
            Effects.DOLPHINS_GRACE
        };

	public UltraCrystal(IItemTier tier, int maxDamage, float attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	}

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote() == false) {
            Effect to_apply = poss_effects[(int) (Math.random() * poss_effects.length)];
            int duration = 100000000;
            int amplifier = (int) (Math.random() * 5);
            playerIn.addPotionEffect(new EffectInstance(to_apply, duration, amplifier, true, true));
            playerIn.sendBreakAnimation(playerIn.getActiveHand());
        }

        return new ActionResult<ItemStack>(ActionResultType.PASS, ItemStack.EMPTY);
    }
}
