package stevee.gtec.common.data;



import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.integration.kjs.GTRegistryInfo;
import net.minecraftforge.fml.ModLoader;


import static stevee.gtec.registry.GTECRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded", "unused"})
public class GTECMachines {

    static {
        GTRegistries.MACHINES.unfreeze();
    }

    public static final MultiblockMachineDefinition BACTERIA_BATH = REGISTRATE.multiblock("bacteria_bath", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .recipeType(GTECRecipeTypes.BACTERIA_RECIPES)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GGGGG", "F   F", "F   F", "F   F", "GGGGG")
                    .aisle("GGGGG", " SSS ", " SSS ", " SSS ", "GGGGG")
                    .aisle("GGGGG", " S S ", " S S ", " S S ", "GGMGG")
                    .aisle("GGGGG", " SSS ", " SSS ", " SSS ", "GGGGG")
                    .aisle("GGCGG", "F   F", "F   F", "F   F", "GGGGG")
                    .where('G', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(40)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, true, false)))
                    .where("C", controller(blocks(definition.getBlock())))
                    .where('S', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('F', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Naquadah)))
                    .where(' ', any())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();



    public static void init() {
        if (GTCEu.isKubeJSLoaded()) {
            GTRegistryInfo.registerFor(GTRegistries.MACHINES.getRegistryName());
        }
        ModLoader.get().postEvent(new GTCEuAPI.RegisterEvent<>(GTRegistries.MACHINES, MachineDefinition.class));
        GTRegistries.MACHINES.freeze();
    }
}
