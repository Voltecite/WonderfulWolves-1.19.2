package net.voltecite.wonderfulwolves.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voltecite.wonderfulwolves.WonderfulWolves;
import net.voltecite.wonderfulwolves.entity.WWEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WonderfulWolves.MOD_ID);

    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WONDERFUL_WOLVES)));

    public static final RegistryObject<Item> WONDERFUL_SPAWN_EGG = ITEMS.register("wonderful_spawn_egg",
            () -> new ForgeSpawnEggItem(WWEntityTypes.DOGGO,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.WONDERFUL_WOLVES)));

    public static final RegistryObject<Item> GERMAN_SHEPHERD_SPAWN_EGG = ITEMS.register("german_shepherd_spawn_egg",
            () -> new ForgeSpawnEggItem(WWEntityTypes.GERMAN_SHEPHERD,0xD7B161, 0x0E1119,
                    new Item.Properties().tab(ModCreativeModeTab.WONDERFUL_WOLVES)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
