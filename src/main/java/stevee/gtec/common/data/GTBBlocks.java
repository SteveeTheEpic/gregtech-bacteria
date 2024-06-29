package stevee.gtec.common.data;

import stevee.gtec.registry.GTBCreativeModeTabs;

import static stevee.gtec.registry.GTBRegistries.REGISTRATE;

public class GTBBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> GTBCreativeModeTabs.ITEM);
    }




}
