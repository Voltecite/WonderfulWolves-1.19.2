package net.voltecite.wonderfulwolves.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.voltecite.wonderfulwolves.WonderfulWolves;
import net.voltecite.wonderfulwolves.entity.client.collarlayer.GermanWolfCollarLayer;
import net.voltecite.wonderfulwolves.entity.client.model.GermanShepherdModel;
import net.voltecite.wonderfulwolves.entity.custom.GermanShepherd;


public class GermanShepherdRenderer extends MobRenderer<GermanShepherd, GermanShepherdModel<GermanShepherd>> {
    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation(WonderfulWolves.MOD_ID,"textures/entity/wonderfulwolves/german/german.png");
    private static final ResourceLocation WOLF_TAME_LOCATION = new ResourceLocation(WonderfulWolves.MOD_ID,"textures/entity/wonderfulwolves/german/german.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation(WonderfulWolves.MOD_ID,"textures/entity/wonderfulwolves/german/german_angry.png");

    public GermanShepherdRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new GermanShepherdModel<>(ctx.bakeLayer(ModelLayers.WOLF)), 0.5F);
        this.addLayer(new GermanWolfCollarLayer(this));
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float getBob(GermanShepherd pLivingBase, float pPartialTicks) {
        return pLivingBase.getTailAngle();
    }

    public void render(GermanShepherd pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
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
    public ResourceLocation getTextureLocation(GermanShepherd pEntity) {
        if (pEntity.isTame()) {
            return WOLF_TAME_LOCATION;
        } else {
            return pEntity.isAngry() ? WOLF_ANGRY_LOCATION : WOLF_LOCATION;
        }
    }
}
