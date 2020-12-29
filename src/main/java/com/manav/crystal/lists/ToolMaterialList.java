package com.manav.crystal.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
	DARK_CRYSTAL(14.0f, 11.0f, 50, 10, 10000, ItemList.crystal),
	WEAK(0.0f, 1.0f, 0, 0, 0, ItemList.crystal);
	
	private float attackDamage, efficiency; 
	private int enchantability, harvestLevel, maxUses;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int enchantability, int harvestLevel, int maxUses, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.repairMaterial = repairMaterial;
	}
	
	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}

}
