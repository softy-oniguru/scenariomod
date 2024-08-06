package net.gurudev.storytelling;

import net.fabricmc.api.ClientModInitializer;
import net.gurudev.storytelling.entity.EntityModelManager;
import net.gurudev.storytelling.input.KeybindingHandler;

import static net.gurudev.storytelling.Main.LOGGER;

public class MainClient implements ClientModInitializer {
	@Override public void onInitializeClient() {

		LOGGER.info("Registering keybindings..."); KeybindingHandler.registerKeybindings();
		EntityModelManager.registerEntities();
	}
}