package boo.remington;

import boo.remington.item.ModItems;
import boo.remington.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.parser.Entity;

public class Invisible implements ModInitializer {
	public static final String MOD_ID = "invisible";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModSounds.registerModSounds();

		AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
			entity.isAlive();
			return ActionResult.PASS;
		}));
	}
}