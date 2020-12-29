package com.manav.crystal.items;

import java.util.ArrayList;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.manav.crystal.tooltypes.CrystalTool;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ExplosiveCrystal extends CrystalTool {
	
    public ExplosiveCrystal(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote() == false) {
			ArrayList<TNTEntity> tnts = new ArrayList<TNTEntity>();
			
			for (int i = 0; i < 10; i++) {
				TNTEntity toAdd = new TNTEntity(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, playerIn);
				toAdd.setFuse(200); // 10-second fuse
				tnts.add(toAdd);
			}
			for (TNTEntity tnt : tnts) worldIn.addEntity(tnt);
		}
		if (Math.random() > 0.985)
	        return new ActionResult<ItemStack>(ActionResultType.PASS, ItemStack.EMPTY);
		return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
