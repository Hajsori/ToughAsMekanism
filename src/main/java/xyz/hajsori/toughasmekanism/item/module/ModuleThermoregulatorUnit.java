package xyz.hajsori.toughasmekanism.item.module;

import xyz.hajsori.toughasmekanism.Config;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import mekanism.api.gear.IModuleContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.potion.TANEffects;

public class ModuleThermoregulatorUnit implements ICustomModule<ModuleThermoregulatorUnit> {
    @Override
    public void tickServer(IModule<ModuleThermoregulatorUnit> module, IModuleContainer moduleContainer, ItemStack stack, Player player) {
        if (module.canUseEnergy(player, stack, Config.moduleHydrationUnitUsage)) {
            module.useEnergy(player, stack, Config.moduleThermoregulatorUnitUsage);
            player.addEffect(new MobEffectInstance(TANEffects.CLIMATE_CLEMENCY, 1, 0, false, false, false));
        }
    }
}
