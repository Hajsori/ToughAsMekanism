package xyz.hajsori.toughasmekanism;

import com.mojang.logging.LogUtils;
import xyz.hajsori.toughasmekanism.registry.TAMInventoryTabs;
import xyz.hajsori.toughasmekanism.registry.TAMItems;
import xyz.hajsori.toughasmekanism.registry.TAMModules;
import mekanism.api.MekanismIMC;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(ToughAsMekanism.MODID)
public class ToughAsMekanism {
    public static final String MODID = "toughasmekanism";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ToughAsMekanism(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::imcQueue);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        TAMModules.MODULES.register(modEventBus);
        TAMItems.ITEMS.register(modEventBus);
        TAMInventoryTabs.TABS.register(modEventBus);
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(TAMModules.HYDRATION_UNIT);

        MekanismIMC.addMekaSuitBodyarmorModules(TAMModules.THERMOREGULATOR_UNIT);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
