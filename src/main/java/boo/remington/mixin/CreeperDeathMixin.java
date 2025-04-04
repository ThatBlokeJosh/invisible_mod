package boo.remington.mixin;

import boo.remington.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class CreeperDeathMixin {
	@Inject(method = "onDeath", at = @At("HEAD"))
	private void onDeath(DamageSource damageSource, CallbackInfo ci) {
		LivingEntity target = (LivingEntity)(Object)this;
		Entity attacker = damageSource.getAttacker();
		if (target instanceof CreeperEntity creeper && attacker instanceof SkeletonEntity) {
			if (creeper.hasStatusEffect(StatusEffects.INVISIBILITY)) {
				creeper.dropItem(ModItems.INVISIBLE_MUSIC_DISC);
			}
		}
	}
}