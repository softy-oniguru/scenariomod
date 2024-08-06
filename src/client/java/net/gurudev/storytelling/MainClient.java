package net.gurudev.storytelling;

import net.fabricmc.api.ClientModInitializer;
import net.gurudev.storytelling.entity.EntityModelManager;
import net.gurudev.storytelling.gui.ScreenHandlerManager;
import net.gurudev.storytelling.gui.StorytellerScreen;
import net.gurudev.storytelling.input.KeybindingHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

import static net.gurudev.storytelling.Main.LOGGER;

public class MainClient implements ClientModInitializer {
	@Override public void onInitializeClient() {
		HandledScreens.register(ScreenHandlerManager.STORYTELLER_SCREEN_HANDLER_TYPE, StorytellerScreen::new);
		LOGGER.info("Registering keybindings..."); KeybindingHandler.registerKeybindings();
		EntityModelManager.registerEntities();
	}
}