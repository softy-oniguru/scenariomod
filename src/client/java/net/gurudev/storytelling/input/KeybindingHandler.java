package net.gurudev.storytelling.input;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.gurudev.storytelling.entity.StorytellerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Box;
import org.lwjgl.glfw.GLFW;

import static net.gurudev.storytelling.entity.EntityManager.STORYTELLER;

public class KeybindingHandler {
	public static KeyBinding STORY_KEYBINDING = new KeyBinding(
		"key.storytelling.performStory",
		InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
		"category.storytelling.keybindings"
	);

	public static void registerKeybindings() {
		ClientTickEvents.END_CLIENT_TICK.register(KeybindingHandler::handleKeyboardEvents);
	}

	public static void handleKeyboardEvents(MinecraftClient client) {
		while (STORY_KEYBINDING.wasPressed()) {
			assert client.player != null; assert client.world != null;
			Box bounds = Box.of(client.player.getPos(), 32, 32, 32);
			client.world.getEntitiesByType(STORYTELLER, bounds, entity->true)
					.forEach(StorytellerEntity::performStory);
		}
	}
}
