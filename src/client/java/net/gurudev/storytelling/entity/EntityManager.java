package net.gurudev.storytelling.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gurudev.storytelling.StorytellingClient;
import net.gurudev.storytelling.model.StorytellerModel;
import net.gurudev.storytelling.renderer.StorytellerRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityManager {
    public static EntityType<StorytellerEntity> STORYTELLER;

    public static void registerEntities() {
        STORYTELLER = Registry.register(
                Registries.ENTITY_TYPE, Identifier.of(StorytellingClient.MOD_ID, "storyteller"),
                EntityType.Builder.create(StorytellerEntity::new, SpawnGroup.MISC)
                        .dimensions(0.6f, 1.8f).eyeHeight(1.62f)
                        .vehicleAttachment(.5f).build("storyteller")
        ); FabricDefaultAttributeRegistry.register(STORYTELLER, StorytellerEntity.createMobAttributes());
        EntityModelLayerRegistry.registerModelLayer(StorytellerModel.TEXTURE, StorytellerModel::getTexturedModelData);
        EntityRendererRegistry.register(EntityManager.STORYTELLER, StorytellerRenderer::new);
    }
}
