package stevee.gtb.registry;


import stevee.gtb.GTBacteria;
import stevee.gtb.common.data.GTBItems;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import static stevee.gtb.registry.GTBRegistries.REGISTRATE;

public class GTBCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> ITEM = REGISTRATE.defaultCreativeTab(GTBacteria.MOD_ID,
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GTBacteria.MOD_ID, REGISTRATE))
                            .icon(GTBItems.BACTERIA_PETRI_DISH::asStack)
                            .title(Component.literal("GregTech Bacteria"))
                            .build())
            .register();

    public static void init() {

    }
}
