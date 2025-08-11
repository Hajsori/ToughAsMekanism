package xyz.hajsori.toughasmekanism.item.module;

import xyz.hajsori.toughasmekanism.Config;
import xyz.hajsori.toughasmekanism.ToughAsMekanism;
import mekanism.api.gear.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;

import java.util.function.Consumer;

public class ModuleHydrationUnit implements ICustomModule<ModuleHydrationUnit> {
    private static final ResourceLocation icon = ResourceLocation.fromNamespaceAndPath(ToughAsMekanism.MODID, "textures/gui/hud/hydration_unit");

    @Override
    public void tickServer(IModule<ModuleHydrationUnit> module, IModuleContainer moduleContainer, ItemStack stack, Player player) {
        IThirst thirst = ThirstHelper.getThirst(player);

        if (module.canUseEnergy(player, stack, Config.moduleHydrationUnitUsage) && thirst.isThirsty()) {
            thirst.setThirst(thirst.getThirst() + Config.moduleHydrationUnitGivesThirst);
            module.useEnergy(player, stack, Config.moduleHydrationUnitUsage);
        }
    }

    @Override
    public void addHUDElements(IModule<ModuleHydrationUnit> module, IModuleContainer moduleContainer, ItemStack stack, Player player, Consumer<IHUDElement> hudElementAdder) {
        if (module.isEnabled()) {
            hudElementAdder.accept(IModuleHelper.INSTANCE.hudElementPercent(icon, 1));
        }
    }
}
