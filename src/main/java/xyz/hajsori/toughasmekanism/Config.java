package xyz.hajsori.toughasmekanism;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = ToughAsMekanism.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.LongValue MODULE_THERMOREGULATOR_UNIT_USAGE = BUILDER
            .comment("How much energy the Thermoregulator unit uses per tick")
            .defineInRange("moduleThermoregulatorUnitUsage", 100L, 0L, 1000L);

    private static final ModConfigSpec.LongValue MODULE_HYDRATION_UNIT_USAGE = BUILDER
            .comment("How much energy the Hydration unit uses per tick")
            .defineInRange("moduleHydrationUnitUsage", 50L, 0L, 1000L);

    private static final ModConfigSpec.IntValue MODULE_HYDRATION_UNIT_GIVES_THIRST = BUILDER
            .comment("How much thirst the Hydration unit gives per tick")
            .defineInRange("moduleHydrationUnitGivesThirst", 1, 0, 20);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static Long moduleThermoregulatorUnitUsage;
    public static Long moduleHydrationUnitUsage;
    public static Integer moduleHydrationUnitGivesThirst;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        moduleThermoregulatorUnitUsage = MODULE_THERMOREGULATOR_UNIT_USAGE.get();
        moduleHydrationUnitUsage = MODULE_HYDRATION_UNIT_USAGE.get();
        moduleHydrationUnitGivesThirst = MODULE_HYDRATION_UNIT_GIVES_THIRST.get();
    }
}
