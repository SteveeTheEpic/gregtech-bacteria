package stevee.gtb.data.recipe.chemistry;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtb.GTBacteria;
import stevee.gtb.common.data.GTBItems;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static stevee.gtb.common.data.GTBRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class Bacteria {
    public static void init(Consumer<FinishedRecipe> provider) {

        BACTERIA_RECIPES.recipeBuilder(GTBacteria.id("make_bacteria_petri_dishes_from_biomass"))
                .inputItems(GTBItems.STERILE_PETRI_DISH, 1)
                .inputFluids(Biomass.getFluid(1000))
                .outputItems(GTBItems.BACTERIA_PETRI_DISH, 1)
                .duration(400).EUt(VA[LuV]).save(provider);

        BACTERIA_RECIPES.recipeBuilder(GTBacteria.id("make_bacteria"))
                .notConsumable(GTBItems.BACTERIA_PETRI_DISH)
                .circuitMeta(0)
                .outputFluids(GTMaterials.Bacteria.getFluid(1))
                .duration(800).EUt(VA[LuV]).save(provider);

        BACTERIA_RECIPES.recipeBuilder(GTBacteria.id("make_more_bacteria"))
                .circuitMeta(1)
                .notConsumable(GTBItems.BACTERIA_PETRI_DISH)
                .inputItems(GTItems.BIO_CHAFF, 4)
                .outputFluids(Bacteria.getFluid(4))
                .duration(200).EUt(VA[LuV]).save(provider);


        AUTOCLAVE_RECIPES.recipeBuilder(GTBacteria.id("sterilize_petri_dishes"))
                .inputItems(GTItems.PETRI_DISH, 1)
                .inputFluids(Chlorine.getFluid(16))
                .outputItems(GTBItems.STERILE_PETRI_DISH, 1)
                .duration(400).EUt(VA[LuV]).save(provider);
    }
}
