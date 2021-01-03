package com.manav.crystal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.manav.crystal.items.AngelCrystal;
import com.manav.crystal.items.AquaCrystal;
import com.manav.crystal.items.DarkPickaxe;
import com.manav.crystal.items.DarkSword;
import com.manav.crystal.items.ExplosiveCrystal;
import com.manav.crystal.items.MagicBone;
import com.manav.crystal.items.UltraCrystal;
import com.manav.crystal.lists.ItemList;
import com.manav.crystal.lists.ToolMaterialList;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("crystal")
public class Crystal {

	public static Crystal instance;
	public static final String modid = "crystal";
	private static final Logger logger = LogManager.getLogger(modid);

	public Crystal() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent events) {
		logger.info("[100%] Setup method registered!");
	}

	private void clientRegistries(final FMLClientSetupEvent events) {
		logger.info("[100%] Client registries method registered!");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			logger.info("[  0%] Beginning to register items!");

			event.getRegistry().registerAll(
					ItemList.crystal = new Item(new Item.Properties().group(ItemGroup.MISC))
							.setRegistryName(location("crystal")),
					ItemList.ultra_crystal = new UltraCrystal(ToolMaterialList.WEAK, 0, 0,
							new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("ultra_crystal")),
					ItemList.explosive_crystal = new ExplosiveCrystal(ToolMaterialList.WEAK, 0, 0,
							new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("explosive_crystal")),
					new AquaCrystal(ToolMaterialList.WEAK, 0, 0,
							new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("aqua_crystal")),
					new AngelCrystal(ToolMaterialList.WEAK, 0, 0,
							new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("angel_crystal")),
					new MagicBone(ToolMaterialList.WEAK, 0, 0,
							new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("magic_bone")),
					ItemList.dark_rod = new Item(new Item.Properties().group(ItemGroup.MISC))
							.setRegistryName(location("dark_rod")),
					ItemList.dark_pickaxe = new DarkPickaxe(ToolMaterialList.DARK_CRYSTAL, -5, 1f,
							new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("dark_pickaxe")),
					ItemList.dark_axe = new AxeItem(ToolMaterialList.DARK_CRYSTAL, 3.5f, -2f,
							new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("dark_axe")),
					new ShovelItem(ToolMaterialList.DARK_CRYSTAL, -7, 1f,
							new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("dark_shovel")),
					ItemList.dark_sword = new DarkSword(ToolMaterialList.DARK_CRYSTAL, 2, 996f,
							new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("dark_sword")));

			logger.info("[100%] All items registered!");
		}

		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}

	public static Logger getLogger() {
		return logger;
	}
}
