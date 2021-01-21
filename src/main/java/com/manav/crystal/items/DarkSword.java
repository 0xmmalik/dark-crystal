package com.manav.crystal.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DarkSword extends SwordItem {
	
    private static Effect[] poss_effects = new Effect[]{
            Effects.SPEED,
            Effects.SLOWNESS,
            Effects.HASTE,
            Effects.MINING_FATIGUE,
            Effects.STRENGTH,
            Effects.INSTANT_HEALTH,
            Effects.INSTANT_DAMAGE,
            Effects.JUMP_BOOST,
            Effects.NAUSEA,
            Effects.REGENERATION,
            Effects.RESISTANCE,
            Effects.FIRE_RESISTANCE,
            Effects.WATER_BREATHING,
            Effects.INVISIBILITY,
            Effects.BLINDNESS,
            Effects.NIGHT_VISION,
            Effects.HUNGER,
            Effects.WEAKNESS,
            Effects.POISON,
            Effects.WITHER,
            Effects.HEALTH_BOOST,
            Effects.ABSORPTION,
            Effects.SATURATION,
            Effects.GLOWING,
            Effects.LEVITATION,
            Effects.LUCK,
            Effects.UNLUCK,
            Effects.SLOW_FALLING,
            Effects.CONDUIT_POWER,
            Effects.DOLPHINS_GRACE,
            Effects.BAD_OMEN,
            Effects.HERO_OF_THE_VILLAGE
        };
        
        private long prev_milli = System.currentTimeMillis();

	public DarkSword(IItemTier p_i48460_1_, int f, float p_i48460_3_, Properties p_i48460_4_) {
		super(p_i48460_1_, f, p_i48460_3_, p_i48460_4_);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.WITHER, 60, 2));
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		
		stack.addEnchantment(Enchantment.getEnchantmentByID(16), 10); // Looting X
		playerIn.setHealth(playerIn.getMaxHealth());
		worldIn.setRainStrength(10.0f);
		worldIn.setThunderStrength(10.0f);

		super.onCreated(stack, worldIn, playerIn);
	}
	
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (System.currentTimeMillis() - this.prev_milli >= 250 && worldIn.isRemote() == false) {
            Effect to_apply = poss_effects[(int) (Math.random() * poss_effects.length)];
            int duration = (int) (Math.random() * 60 * 20);
            int amplifier = (int) (Math.random() * 5);
            playerIn.addPotionEffect(new EffectInstance(to_apply, duration, amplifier));
            this.prev_milli = System.currentTimeMillis();
        }
        
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
