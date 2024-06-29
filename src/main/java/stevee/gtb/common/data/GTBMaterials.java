package stevee.gtb.common.data;

import stevee.gtb.GTBacteria;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;




public class GTBMaterials {
    public static void init() {
    }

    public static final Material Lu = new Material.Builder(GTBacteria.id("lud"))
            .dust().iconSet(METALLIC)
            .color(0xFFFFFF)
            .buildAndRegister()
            .setFormula("Lud", true);

    public static final Material Susium_Ingot = new Material.Builder(GTBacteria.id("susium"))
            .dust().color(0xff0037)
            .iconSet(SHINY)
            .buildAndRegister()
            .setFormula("ඞ");
}
