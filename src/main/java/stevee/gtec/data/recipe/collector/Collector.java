package stevee.gtec.data.recipe.collector;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.client.model.SpriteOverrider;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtec.GTExtendedChem;
import stevee.gtec.common.data.GTECMachines;
import stevee.gtec.common.data.GTECMaterials;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static stevee.gtec.common.data.GTECRecipeTypes.*;


public class Collector {
    public static void init(Consumer<FinishedRecipe> provider) {
        COLLECTOR.recipeBuilder(GTExtendedChem.id("collect_lu"))
                .outputItems(TagPrefix.dustTiny, GTECMaterials.Lu, 1)
                .circuitMeta(1)
                .duration(2000).EUt(VA[ZPM]).save(provider);
    }
}
