package stevee.gtec.common.data;


import stevee.gtec.data.recipe.collector.Collector;
import stevee.gtec.data.recipe.chemistry.Bacteria;
import stevee.gtec.data.recipe.chemistry.MiscRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;


public class GTBRecipes {


    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipes.init(provider);
        Bacteria.init(provider);
        Collector.init(provider);
    }
}
