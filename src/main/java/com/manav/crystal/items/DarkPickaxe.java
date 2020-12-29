package com.manav.crystal.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class DarkPickaxe extends PickaxeItem {

	public DarkPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.addEnchantment(Enchantment.getEnchantmentByID(18), 7); // Efficiency VII
		stack.addEnchantment(Enchantment.getEnchantmentByID(21), 10); // Fortune X
		super.onCreated(stack, worldIn, playerIn);
	}
}
