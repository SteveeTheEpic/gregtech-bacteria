package stevee.gtec;

import stevee.gtec.common.data.*;
import stevee.gtec.registry.GTBCreativeModeTabs;
import stevee.gtec.registry.GTBRegistries;
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

@Mod(GTBacteria.MOD_ID)
public class GTBacteria {
    public static final String MOD_ID = "gtb";

    public static final CleanroomType CLEANER_ROOM = new CleanroomType("cleanerroom", "gtb.recipe.cleanerroom.displayname");
    public static MaterialRegistry MATERIAL_REGISTRY;

    public GTBacteria() {
        GTBacteria.init();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);

        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);
    }

    public static void init() {
        ConfigHolder.init(); // Forcefully init GT config because fabric doesn't allow dependents to load after dependencies

        //.init();
        GTBCompassSections.init();
        GTBItems.init();
        GTBCreativeModeTabs.init();
        GTECDatagen.init();
        GTBRegistries.REGISTRATE.registerRegistrate();
    }

    @SubscribeEvent
    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GTBRecipeTypes.init();
    }

    @SubscribeEvent
    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GTBMachines.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(GTBacteria.MOD_ID);
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        GTBMaterials.init();
    }

    @SubscribeEvent
    public void registerElements(MaterialEvent event) {
        GTBElements.init();
    }

    @SubscribeEvent
    public void modifyMaterials(PostMaterialEvent event) {

    }

    @SubscribeEvent
    public void registerCompassSections(GTCEuAPI.RegisterEvent<ResourceLocation, CompassNode> event) {
        GTBCompassSections.init();
    }
}

