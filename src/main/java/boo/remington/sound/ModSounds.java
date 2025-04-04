package boo.remington.sound;

import boo.remington.Invisible;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent INVISIBLE = registerSoundEvent("invisible");
    public static final RegistryKey<JukeboxSong> INVISIBLE_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Invisible.MOD_ID, "invisible"));

    static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Invisible.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        Invisible.LOGGER.info("Registering Mod Sounds for " + Invisible.MOD_ID);
    }
}
