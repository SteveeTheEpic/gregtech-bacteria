package stevee.gtec.common.data;

import stevee.gtec.registry.GTBCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import static stevee.gtec.registry.GTBRegistries.REGISTRATE;
import net.minecraft.world.item.Item;


@SuppressWarnings("Convert2MethodRef")
public class GTBItems {
    static {
        REGISTRATE.creativeModeTab(() -> GTBCreativeModeTabs.ITEM);
    }
    public static final ItemEntry<Item> BACTERIA_PETRI_DISH = REGISTRATE.item("bacteria_petri_dish", Item::new)
            .lang("Bacteria Petri Dish")
            .defaultModel()
            .register();

    public static final ItemEntry<Item> USED_PETRI_DISH = REGISTRATE.item("used_petri_dish", Item::new)
            .lang("Used Petri Dish")
            .defaultModel()
            .register();

    public static final ItemEntry<Item> STERILE_PETRI_DISH = REGISTRATE.item("sterile_petri_dish", Item::new)
            .lang("Starile Petri Dish")
            .defaultModel()
            .register();

    public static void init() {
    }
}
