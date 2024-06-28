package stevee.gtec.common.data;


import stevee.gtec.data.recipe.chemistry.MiscRecipes;
import stevee.gtec.data.recipe.disabled.BastnasiteChainRecipes;
import stevee.gtec.data.recipe.disabled.MonaziteChainRecipes;
import stevee.gtec.data.recipe.disabled.PlatinumLineRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;


public class GTECRecipes {


    public static void init(Consumer<FinishedRecipe> provider) {
        PlatinumLineRecipes.init(provider);
        MonaziteChainRecipes.init(provider);
        BastnasiteChainRecipes.init(provider);
        MiscRecipes.init(provider);

    }
}
