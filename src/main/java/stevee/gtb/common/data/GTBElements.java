package stevee.gtb.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.integration.kjs.GTRegistryInfo;
import net.minecraftforge.fml.ModLoader;

public class GTBElements {

    static {
        GTRegistries.ELEMENTS.unfreeze();
    }

    public static final Element Lu = createAndRegister(-5, 0, -1, null, "Lu", "Lud", false);
    public static final Element Retardium = createAndRegister(69420, 140000, 1, "Trinium", "Retardium", "Rt", false);
    public static final Element Susium = createAndRegister(-1, 0, -1, null, "Susium", "ඞ", false);


    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo,
                                            String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {
        ModLoader.get().postEvent(new GTCEuAPI.RegisterEvent<>(GTRegistries.ELEMENTS, Element.class));
        if (GTCEu.isKubeJSLoaded()) {
            GTRegistryInfo.registerFor(GTRegistries.ELEMENTS.getRegistryName());
        }
        GTRegistries.ELEMENTS.freeze();
    }
}
