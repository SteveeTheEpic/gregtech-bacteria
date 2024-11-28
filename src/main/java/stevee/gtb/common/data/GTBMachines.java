package stevee.gtb.common.data;



import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTCompassSections;
import com.gregtechceu.gtceu.common.data.GTMaterials;


import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static stevee.gtb.registry.GTBRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded", "unused"})
public class GTBMachines {



    public static final MultiblockMachineDefinition BACTERIA_BATH = REGISTRATE.multiblock("bacteria_bath", WorkableElectricMultiblockMachine::new)
            .langValue("Bacteria Bath")
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(() -> CASING_STAINLESS_CLEAN.get())
            .recipeType(GTBRecipeTypes.BACTERIA_RECIPES)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GGGGG", "F   F", "F   F", "F   F", "GGGGG")
                    .aisle("GGGGG", " SSS ", " SSS ", " SSS ", "GGGGG")
                    .aisle("GGGGG", " S S ", " S S ", " S S ", "GGGGG")
                    .aisle("GGGGG", " SSS ", " SSS ", " SSS ", "GGGGG")
                    .aisle("GGCGG", "F   F", "F   F", "F   F", "GGGGG")
                    .where('G', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(40)
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.EXPORT_FLUIDS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(autoAbilities(true, false, false)))
                    .where('C', controller(blocks(definition.getBlock())))
                    .where('S', blocks(CASING_TEMPERED_GLASS.get()))
                    .where('F', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.NaquadahAlloy)))
                    .where(' ', any())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .compassSections(GTCompassSections.TIER[LuV])
            .compassNodeSelf()
            .register();

    public static void init() {
    }
}