package stevee.gtec;

import stevee.gtec.common.data.*;
import stevee.gtec.registry.GTECCreativeModeTabs;
import stevee.gtec.registry.GTECRegistries;
import stevee.gtec.data.GTECDatagen;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.CompassNode;
import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GTExtendedChem.MOD_ID)
public class GTExtendedChem {
    public static final String MOD_ID = "gtec";

    public static final CleanroomType CLEANER_ROOM = new CleanroomType("cleanerroom", "gtec.recipe.cleanerroom.displayname");
    public static MaterialRegistry MATERIAL_REGISTRY;

    public GTExtendedChem() {
        GTExtendedChem.init();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
    }

    public static void init() {
        ConfigHolder.init(); // Forcefully init GT config because fabric doesn't allow dependents to load after dependencies

        //.init();
        GTECCompassSections.init();
        GTECItems.init();
        GTECCreativeModeTabs.init();
        GTECMachines.init();
        GTECDatagen.init();
        GTECRegistries.REGISTRATE.registerRegistrate();
    }


    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(GTExtendedChem.MOD_ID);
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        GTECMaterials.init();
    }

    @SubscribeEvent
    public void registerElements(MaterialEvent event) {
        GTECElements.init();
    }

    @SubscribeEvent
    public void modifyMaterials(PostMaterialEvent event) {
        GTECMaterials.modifyMaterials();
    }

    @SubscribeEvent
    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GTECRecipeTypes.init();
    }

    @SubscribeEvent
    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GTECMachines.init();
    }

    @SubscribeEvent
    public void registerCompassSections(GTCEuAPI.RegisterEvent<ResourceLocation, CompassNode> event) {
        GTECCompassSections.init();
    }
}

