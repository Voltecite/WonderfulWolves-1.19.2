package net.voltecite.wonderfulwolves.entity.client.collarlayer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.voltecite.wonderfulwolves.entity.client.model.WWolfModel;
import net.voltecite.wonderfulwolves.entity.custom.WWolves;

@OnlyIn(Dist.CLIENT)
public class WWolfCollarLayer extends RenderLayer<WWolves, WWolfModel<WWolves>> {
    private static final ResourceLocation WWOLF_COLLAR_LOCATION = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

    public WWolfCollarLayer(RenderLayerParent<WWolves, WWolfModel<WWolves>> pRenderer) {
        super(pRenderer);
    }

    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, WWolves pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (pLivingEntity.isTame() && !pLivingEntity.isInvisible()) {
            float[] afloat = pLivingEntity.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(this.getParentModel(), WWOLF_COLLAR_LOCATION, pMatrixStack, pBuffer, pPackedLight, pLivingEntity, afloat[0], afloat[1], afloat[2]);
        }
    }
}