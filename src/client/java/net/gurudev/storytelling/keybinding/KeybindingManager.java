package net.gurudev.storytelling.keybinding;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.gurudev.storytelling.entity.StorytellerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Box;
import org.lwjgl.glfw.GLFW;

import static net.gurudev.storytelling.entity.EntityManager.STORYTELLER;

public class KeybindingManager {
	public static KeyBinding StoryKeybinding = new KeyBinding(
		"key.storytelling.performStory",
		InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
		"category.storytelling.keybindings"
	);

	public static void registerKeybindings() {
		KeyBinding storyKeyBinding = KeyBindingHelper.registerKeyBinding(StoryKeybinding);
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (storyKeyBinding.wasPressed()) {
				assert client.player != null; assert client.world != null;
				Box bounds = Box.of(client.player.getPos(), 32, 32, 32);
				client.world.getEntitiesByType(STORYTELLER, bounds, entity->true)
						.forEach(StorytellerEntity::performStory);
			}
		});
	}
}
