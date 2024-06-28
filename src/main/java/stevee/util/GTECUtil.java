package stevee.util;


import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GTECUtil {
    public static TagKey<Block> MINEABLE_WITH_WRENCH = TagKey.create(Registries.BLOCK, new ResourceLocation("forge", "mineable/wrench"));

    }
