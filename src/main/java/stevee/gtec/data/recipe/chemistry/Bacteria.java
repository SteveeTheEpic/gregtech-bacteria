package stevee.gtec.data.recipe.chemistry;

import com.gregtechceu.gtceu.common.data.GTFluids;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtec.GTExtendedChem;
import stevee.gtec.common.data.GTECItems;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static stevee.gtec.common.data.GTECRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class Bacteria {
    public static void init(Consumer<FinishedRecipe> provider) {

        BACTERIA_RECIPES.recipeBuilder(GTExtendedChem.id("make_bacteria_petri_dishes_from_biomass"))
                .inputItems(GTItems.PETRI_DISH, 1)
                .inputFluids(Biomass.getFluid(1000))
                .outputItems(GTECItems.BACTERIA_PETRI_DISH, 1)
                .duration(400).EUt(VA[LuV]).save(provider);


        BACTERIA_RECIPES.recipeBuilder(GTExtendedChem.id("make_bacteria_from_bacteria_petri_dishes"))
                .inputItems(GTECItems.BACTERIA_PETRI_DISH, 1)
                .outputItems(GTECItems.USED_PETRI_DISH, 1)
                .outputFluids(GTMaterials.Bacteria.getFluid(50))
                .duration(400).EUt(VA[LuV]).save(provider);


        AUTOCLAVE_RECIPES.recipeBuilder(GTExtendedChem.id("clean_used_petri_dishes"))
                .inputItems(GTECItems.USED_PETRI_DISH, 1)
                .outputItems(GTItems.PETRI_DISH, 1)
                .duration(200).EUt(VA[LuV]).save(provider);
    }
}
