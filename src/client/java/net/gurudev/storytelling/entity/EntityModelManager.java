package net.gurudev.storytelling.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurudev.storytelling.model.StorytellerModel;
import net.gurudev.storytelling.renderer.StorytellerRenderer;

public class EntityModelManager {
	public static void registerEntities() {
		EntityModelLayerRegistry.registerModelLayer(StorytellerModel.TEXTURE, StorytellerModel::getTexturedModelData);
		EntityRendererRegistry.register(EntityManager.STORYTELLER, StorytellerRenderer::new);
	}
}