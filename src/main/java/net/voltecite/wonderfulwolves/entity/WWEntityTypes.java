package net.voltecite.wonderfulwolves.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voltecite.wonderfulwolves.WonderfulWolves;
import net.voltecite.wonderfulwolves.entity.custom.GermanShepherd;
import net.voltecite.wonderfulwolves.entity.custom.WWolves;

public class WWEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WonderfulWolves.MOD_ID);
/*
    public static final RegistryObject<EntityType<Husky>> HUSKY =
            ENTITY_TYPES.register("husky",
                    () -> EntityType.Builder.of(Husky::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(WonderfulWolves.MOD_ID, "husky").toString()));
*/
    public static final RegistryObject<EntityType<WWolves>> DOGGO =
            ENTITY_TYPES.register("doggo",
                    () -> EntityType.Builder.of(WWolves::new, MobCategory.CREATURE)
                            .sized(1f,1f)
                            .build(new ResourceLocation(WonderfulWolves.MOD_ID, "doggo").toString()));

    public static final RegistryObject<EntityType<GermanShepherd>> GERMAN_SHEPHERD =
            ENTITY_TYPES.register("german_shepherd",
                    () -> EntityType.Builder.of(GermanShepherd::new, MobCategory.CREATURE)
                            .sized(1f,1f)
                            .build(new ResourceLocation(WonderfulWolves.MOD_ID, "german_shepherd").toString()));
    // or we could do .build(WonderfulWolves.MOD_ID + ":doggo")

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
    /*

    public static final RegistryObject<EntityType<WOLF_TYPES>> WOLVES = WOLF_TYPES
            .register("Wolves", () -> EntityType.Builder.of(WOLF_TYPES::new, MobCategory.CREATURE)
                    .build(new ResourceLocation(WonderfulWolves.MOD_ID, "husky").toString()));
     */
}
