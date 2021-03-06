package net.mobz.Entity;

import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class Illusioner extends IllusionerEntity {

   public Illusioner(EntityType<? extends IllusionerEntity> entityType, World world) {
      super(entityType, world);
      this.experiencePoints = 20;
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return Soundinit.ILLUIDLEEVENT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return Soundinit.ILLUDEATHEVENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return Soundinit.ILLUHURTEVENT;
   }

   @Override
   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
            .setBaseValue(Configinit.CONFIGZ.IllusionerLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
            .setBaseValue(Configinit.CONFIGZ.IllusionerAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
   }

   @Override
   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this)
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.isDay() && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
            && this.world.getBlockState(blockunderentity).getBlock()
                  .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.ILLUSIONER)
            && AutoConfig.getConfigHolder(configz.class).getConfig().IllusionerSpawn;

   }
}
