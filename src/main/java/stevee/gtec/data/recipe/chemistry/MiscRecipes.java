package stevee.gtec.data.recipe.chemistry;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtec.GTExtendedChem;
import stevee.gtec.common.data.GTECMachines;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.ASSEMBLER;
import static com.gregtechceu.gtceu.common.data.GTMachines.ASSEMBLY_LINE;

public class MiscRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {


        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder(GTExtendedChem.id("chemical_bath_craft"))
                .inputItems(GTItems.ELECTRIC_PUMP_LuV, 16)
                .inputItems(GTItems.PETRI_DISH, 32)
                .inputItems(GTBlocks.CASING_TEMPERED_GLASS.asItem(), 16)
                .inputItems(GTMachines.HULL[6], 2)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(6000))
                .outputItems(GTECMachines.BACTERIA_BATH, 1)
                .duration(400).EUt(VA[LuV]).save(provider);


        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder(GTExtendedChem.id("collector_craft"))
                .inputItems(GTItems.ELECTRIC_PUMP_ZPM, 64)
                .inputItems(GTItems.ELECTRIC_MOTOR_ZPM, 64)
                .inputItems(GTMachines.HULL[7], 16)
                .inputItems(GTBlocks.CASING_STEEL_SOLID.asItem(), 64)
                .inputItems(GTItems.QUANTUM_MAINFRAME_ZPM, 4)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(12000))
                .outputItems(GTECMachines.COLLECTOR, 1)
                .EUt(VA[UV]).duration(800).save(provider);

    }

}
