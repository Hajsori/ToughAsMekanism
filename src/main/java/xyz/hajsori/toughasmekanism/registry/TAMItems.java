package xyz.hajsori.toughasmekanism.registry;

import xyz.hajsori.toughasmekanism.ToughAsMekanism;
import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Rarity;

public class TAMItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(ToughAsMekanism.MODID);

    public static final ItemRegistryObject<ItemModule> THERMOREGULATOR_UNIT = ITEMS.registerModule(TAMModules.THERMOREGULATOR_UNIT, Rarity.UNCOMMON);
    public static final ItemRegistryObject<ItemModule> HYDRATION_UNIT = ITEMS.registerModule(TAMModules.HYDRATION_UNIT, Rarity.UNCOMMON);
}
