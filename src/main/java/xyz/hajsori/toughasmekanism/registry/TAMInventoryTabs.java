package xyz.hajsori.toughasmekanism.registry;

import xyz.hajsori.toughasmekanism.ToughAsMekanism;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TAMInventoryTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ToughAsMekanism.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOUGH_AS_MEKANISM_TAB = TABS.register("tough_as_mekanism", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(TAMItems.THERMOREGULATOR_UNIT.get()))
            .title(Component.translatable("creativetab.toughasmekanism"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(new ItemStack(TAMItems.THERMOREGULATOR_UNIT.get()));
                pOutput.accept(new ItemStack(TAMItems.HYDRATION_UNIT.get()));
            })
            .build()
    );
}
