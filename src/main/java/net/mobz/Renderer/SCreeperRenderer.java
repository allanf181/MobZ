package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.CreeperChargeFeatureRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SCreeperRenderer extends MobEntityRenderer<CreeperEntity, CreeperEntityModel<CreeperEntity>> {
  private static final Identifier SKIN = new Identifier("mobz:textures/entity/soulcreeper.png");

  public SCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
    super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    this.addFeature(new CreeperChargeFeatureRenderer(this));
  }

  @Override
  protected void scale(CreeperEntity creeperEntity, MatrixStack matrixStack, float f) {
    float g = creeperEntity.getClientFuseTime(f);
    float h = 1.0F + MathHelper.sin(g * 100.0F) * g * 0.01F;
    g = MathHelper.clamp(g, 0.0F, 1.0F);
    g *= g;
    g *= g;
    float i = (1.0F + g * 0.4F) * h;
    float j = (1.0F + g * 0.1F) / h;
    matrixStack.scale(i, j, i);
  }

  @Override
  protected float getAnimationCounter(CreeperEntity creeperEntity, float f) {
    float g = creeperEntity.getClientFuseTime(f);
    return (int) (g * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(g, 0.5F, 1.0F);
  }

  @Override
  public Identifier getTexture(CreeperEntity creeperEntity) {
    return SKIN;
  }
}
