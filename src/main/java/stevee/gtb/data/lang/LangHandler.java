package stevee.gtb.data.lang;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

import java.util.Set;



public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {
    public static void init(RegistrateLangProvider provider) {
        provider.add("gtb.bacteria_bath", "Bacteria Bath");
    }
}