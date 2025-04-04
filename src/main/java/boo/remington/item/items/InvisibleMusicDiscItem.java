package boo.remington.item.items;

import boo.remington.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class InvisibleMusicDiscItem extends Item {
    public static final Settings SETTINGS = new Settings().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.INVISIBLE_KEY).maxCount(1);

    public InvisibleMusicDiscItem() {
        super(SETTINGS);
    }
}
