package net.voltecite.wonderfulwolves.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import net.voltecite.wonderfulwolves.entity.custom.WWolves;


public class WWRenderer extends MobRenderer<WWolves, WolfModel<WWolves>> {
    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation("textures/entity/wolf/wolf.png");
    private static final ResourceLocation WOLF_TAME_LOCATION = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation("textures/entity/wolf/wolf_angry.png");

    public WWRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new WolfModel<>(ctx.bakeLayer(ModelLayers.WOLF)), 0.5F);
        //this.addLayer(new WolfCollarLayer(this));
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float getBob(WWolves pLivingBase, float pPartialTicks) {
        return pLivingBase.getTailAngle();
    }

    public void render(WWolves pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isWet()) {
            float f = pEntity.getWetShade(pPartialTicks);
            this.model.setColor(f, f, f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        if (pEntity.isWet()) {
            this.model.setColor(1.0F, 1.0F, 1.0F);
        }

    }

    @Override
    public ResourceLocation getTextureLocation(WWolves pEntity) {
        if (pEntity.isTame()) {
            return WOLF_TAME_LOCATION;
        } else {
            return pEntity.isAngry() ? WOLF_ANGRY_LOCATION : WOLF_LOCATION;
        }
    }
}
