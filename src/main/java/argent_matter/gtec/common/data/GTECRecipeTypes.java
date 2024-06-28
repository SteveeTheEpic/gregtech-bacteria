package argent_matter.gtec.common.data;

import argent_matter.gtec.GTExtendedChem;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.integration.kjs.GTRegistryInfo;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.ModLoader;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CHEMICAL_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;

public class GTECRecipeTypes {
    /*
    static {
        GTRegistries.RECIPE_TYPES.unfreeze();
    }
    */

    public static final GTRecipeType BACTERIA_RECIPES = register("bacteria_bath", MULTIBLOCK)
            .setMaxIOSize(1, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(CHEMICAL_RECIPES.getSound());
    public static void init() {
        ModLoader.get().postEvent(new GTCEuAPI.RegisterEvent<>(GTRegistries.RECIPE_TYPES, GTRecipeType.class));
        if (GTCEu.isKubeJSLoaded()) {
            GTRegistryInfo.registerFor(GTRegistries.RECIPE_TYPES.getRegistryName());
        }
        GTRegistries.RECIPE_TYPES.freeze();

    }

    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(GTExtendedChem.id(name), group, proxyRecipes);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }
}
