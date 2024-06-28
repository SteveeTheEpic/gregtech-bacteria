package stevee.gtec.registry;


import stevee.gtec.GTExtendedChem;
import stevee.gtec.common.data.GTECItems;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import static stevee.gtec.registry.GTECRegistries.REGISTRATE;

public class GTECCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> ITEM = REGISTRATE.defaultCreativeTab(GTExtendedChem.MOD_ID,
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GTExtendedChem.MOD_ID, REGISTRATE))
                            .icon(GTECItems.ECHO_PRINTED_CIRCUIT_BOARD::asStack)
                            .title(Component.literal("Gregtech Extended Chemistry"))
                            .build())
            .register();

    public static void init() {

    }
}
