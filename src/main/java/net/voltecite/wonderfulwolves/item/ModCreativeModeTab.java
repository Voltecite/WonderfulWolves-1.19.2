package net.voltecite.wonderfulwolves.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WONDERFUL_WOLVES = new CreativeModeTab("wonderfulwolves") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NUGGET.get());
        }
    };
}
