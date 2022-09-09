package net.voltecite.wonderfulwolves.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.voltecite.wonderfulwolves.WonderfulWolves;
import net.voltecite.wonderfulwolves.entity.WWEntityTypes;
import net.voltecite.wonderfulwolves.entity.custom.WWolves;

@Mod.EventBusSubscriber(modid = WonderfulWolves.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WWEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(WWEntityTypes.DOGGO.get(), WWolves.setAttributes());
    }
}