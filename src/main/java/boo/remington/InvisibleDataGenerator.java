package boo.remington;

import boo.remington.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.component.Component;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class InvisibleDataGenerator implements DataGeneratorEntrypoint {
	static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
			super(output, registryLookup);
		}

		@Override
		public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
			AdvancementEntry rootAdvancement = Advancement.Builder.create()
					.display(
							ModItems.INVISIBLE_MUSIC_DISC,
							Text.translatable("advancement.invisible.obtain_invisible"),
							Text.translatable("advancement.invisible.obtain_invisible.desc"),
							Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
							AdvancementFrame.CHALLENGE,
							true,
							true,
							true
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("obtain_invisible", InventoryChangedCriterion.Conditions.items(ModItems.INVISIBLE_MUSIC_DISC))
					.build(consumer, Invisible.MOD_ID + "/root");
		}
	}
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(AdvancementsProvider::new);
	}
}
