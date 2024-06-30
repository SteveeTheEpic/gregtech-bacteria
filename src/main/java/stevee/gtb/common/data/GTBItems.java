package stevee.gtb.common.data;

import stevee.gtb.registry.GTBCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import static stevee.gtb.registry.GTBRegistries.REGISTRATE;
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

    public static final ItemEntry<Item> STERILE_PETRI_DISH = REGISTRATE.item("sterile_petri_dish", Item::new)
            .lang("Starile Petri Dish")
            .defaultModel()
            .register();

    public static void init() {
    }
}
