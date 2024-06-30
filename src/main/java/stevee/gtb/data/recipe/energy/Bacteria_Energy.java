package stevee.gtb.data.recipe.energy;

import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtb.GTBacteria;
import stevee.gtb.common.data.GTBMachines;

import java.util.function.Consumer;

import static stevee.gtb.common.data.GTBRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;

public class Bacteria_Energy {

    public static void init(Consumer<FinishedRecipe> provider) {

        BACTERIA_GENERATOR.recipeBuilder(GTBacteria.id("energy_from_bacteria"))
                .inputFluids(GTMaterials.Bacteria.getFluid(1))
                .outputEU(VA[EV])
                .circuitMeta(1)
                .duration(1).save(provider);

    }
}
