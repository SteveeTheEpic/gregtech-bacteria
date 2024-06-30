package stevee.gtb.common.data;


import stevee.gtb.data.recipe.collector.Collector;
import stevee.gtb.data.recipe.chemistry.Bacteria;
import stevee.gtb.data.recipe.chemistry.MiscRecipes;
import net.minecraft.data.recipes.FinishedRecipe;
import stevee.gtb.data.recipe.energy.Bacteria_Energy;

import java.util.function.Consumer;


public class GTBRecipes {


    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipes.init(provider);
        Bacteria.init(provider);
        Collector.init(provider);
        Bacteria_Energy.init(provider);
    }
}
