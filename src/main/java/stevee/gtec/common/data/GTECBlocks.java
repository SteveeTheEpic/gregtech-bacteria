package stevee.gtec.common.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import stevee.gtec.registry.GTECCreativeModeTabs;

import static stevee.gtec.registry.GTECRegistries.REGISTRATE;

public class GTECBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> GTECCreativeModeTabs.ITEM);
    }




}
