package stevee.gtb.data;

import stevee.gtb.registry.GTBRegistries;
import stevee.gtb.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class GTECDatagen {
    public static void init() {
        GTBRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}