package stevee.gtb.common.data;

import stevee.gtb.registry.GTBCreativeModeTabs;

import static stevee.gtb.registry.GTBRegistries.REGISTRATE;

public class GTBBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> GTBCreativeModeTabs.ITEM);
    }




}
