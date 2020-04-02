package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SavannaPlateauBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SavannaPlateauBiome.class)
public class savannaplatoglo extends Biome {

	protected savannaplatoglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ARMORED, Configinit.CONFIGZ.ArmoredZombieSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SPO, Configinit.CONFIGZ.PurpleSpiderSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ARCHERENTITY, Configinit.CONFIGZ.BowmanSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.MAGE2ENTITY, Configinit.CONFIGZ.ZombieMageSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ILLUSIONER, Configinit.CONFIGZ.IllusionerSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.PILLAGERBOSS, Configinit.CONFIGZ.PillagerBossSpawnRate, 1, 1));
	}

}