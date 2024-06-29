package stevee.gtb.data.recipe.chemistry;

import com.gregtechceu.gtceu.common.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtb.GTBacteria;
import stevee.gtb.common.data.GTBMachines;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class MiscRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {


        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder(GTBacteria.id("chemical_bath_craft"))
                .inputItems(GTItems.ELECTRIC_PUMP_LuV, 16)
                .inputItems(GTItems.PETRI_DISH, 32)
                .inputItems(GTBlocks.CASING_TEMPERED_GLASS.asItem(), 16)
                .inputItems(GTMachines.HULL[6], 2)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(6000))
                .outputItems(GTBMachines.BACTERIA_BATH, 1)
                .duration(400).EUt(VA[LuV]).save(provider);


        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder(GTBacteria.id("collector_craft"))
                .inputItems(GTItems.ELECTRIC_PUMP_ZPM, 64)
                .inputItems(GTItems.ELECTRIC_MOTOR_ZPM, 64)
                .inputItems(GTMachines.HULL[7], 16)
                .inputItems(GTBlocks.CASING_STEEL_SOLID.asItem(), 64)
                .inputItems(GTItems.QUANTUM_MAINFRAME_ZPM, 4)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(12000))
                .outputItems(GTBMachines.COLLECTOR, 1)
                .EUt(VA[UV]).duration(800).save(provider);

    }

}
