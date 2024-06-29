package stevee.gtec.data;

import stevee.gtec.registry.GTBRegistries;
import stevee.gtec.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class GTECDatagen {
    public static void init() {
        GTBRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}