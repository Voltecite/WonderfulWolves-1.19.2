package net.voltecite.wonderfulwolves;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.voltecite.wonderfulwolves.entity.WWEntityTypes;
import net.voltecite.wonderfulwolves.entity.client.renderer.GermanShepherdRenderer;
import net.voltecite.wonderfulwolves.entity.client.renderer.WWRenderer;
import net.voltecite.wonderfulwolves.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WonderfulWolves.MOD_ID)
public class WonderfulWolves {
    public static final String MOD_ID = "wonderfulwolves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WonderfulWolves()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);

        WWEntityTypes.register(eventBus);

        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(WWEntityTypes.DOGGO.get(), WWRenderer::new);
        EntityRenderers.register(WWEntityTypes.GERMAN_SHEPHERD.get(), GermanShepherdRenderer::new);
    }

/*
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(WWEntityTypes.HUSKY.get(), WWRenderer::new);
        }
    }
    */
}
