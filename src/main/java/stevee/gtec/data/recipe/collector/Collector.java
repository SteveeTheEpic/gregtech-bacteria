package stevee.gtec.data.recipe.collector;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtec.GTBacteria;
import stevee.gtec.common.data.GTBMaterials;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static stevee.gtec.common.data.GTBRecipeTypes.*;


public class Collector {
    public static void init(Consumer<FinishedRecipe> provider) {
        COLLECTOR.recipeBuilder(GTBacteria.id("collect_lu"))
                .outputItems(TagPrefix.dustTiny, GTBMaterials.Lu, 1)
                .circuitMeta(1)
                .duration(2000).EUt(VA[ZPM]).save(provider);
    }
}
