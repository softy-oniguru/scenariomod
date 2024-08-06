package net.gurudev.storytelling;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurudev.storytelling.entity.EntityManager;
import net.gurudev.storytelling.keybinding.KeybindingManager;
import net.gurudev.storytelling.model.StorytellerModel;
import net.gurudev.storytelling.renderer.StorytellerRenderer;

import static net.gurudev.storytelling.Main.LOGGER;

public class MainClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(StorytellerModel.TEXTURE, StorytellerModel::getTexturedModelData);
		EntityRendererRegistry.register(EntityManager.STORYTELLER, StorytellerRenderer::new);
		LOGGER.info("Registering items..."); KeybindingManager.registerKeybindings();
	}
}