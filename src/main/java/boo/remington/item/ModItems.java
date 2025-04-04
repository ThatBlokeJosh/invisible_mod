package boo.remington.item;

import boo.remington.Invisible;
import boo.remington.item.items.InvisibleMusicDiscItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item INVISIBLE_MUSIC_DISC = registerItem("invisible_music_disc", new InvisibleMusicDiscItem());

    static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Invisible.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Invisible.LOGGER.info("Registering Mod Items for " + Invisible.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(INVISIBLE_MUSIC_DISC);
        });
    }
}
