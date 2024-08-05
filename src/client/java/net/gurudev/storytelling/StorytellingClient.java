package net.gurudev.storytelling;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.gurudev.storytelling.entity.StorytellerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Box;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.gurudev.storytelling.entity.EntityManager.STORYTELLER;
import static net.gurudev.storytelling.entity.EntityManager.registerEntities;
import static net.gurudev.storytelling.item.ItemManager.registerItems;

public class StorytellingClient implements ClientModInitializer {
	public static final String MOD_ID = "storytelling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing {} mod", MOD_ID);
		LOGGER.info("Registering items..."); registerItems();
		LOGGER.info("Registering entities..."); registerEntities();
		LOGGER.info("The world was written using Storytelling");

        KeyBinding storyKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.storytelling.performStory",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
                "category.storytelling.keybindings"
        )); ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (storyKeyBinding.wasPressed()) {
                assert client.player != null; assert client.world != null;
				Box bounds = Box.of(client.player.getPos(), 32, 32, 32);

				client.world.getEntitiesByType(STORYTELLER, bounds, entity->true).forEach(entity -> {
					var storyteller = (StorytellerEntity) client.world.getEntityById(entity.getId());
					assert storyteller != null; storyteller.performStory();
				});
            }
		});
	}
}