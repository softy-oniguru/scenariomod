package net.gurudev.storytelling;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.gurudev.storytelling.item.ItemManager.registerItems;
import static net.gurudev.storytelling.entity.EntityManager.registerEntities;
import static net.gurudev.storytelling.gui.ScreenHandlerManager.registerScreenHandlers;

public class Main implements ModInitializer {
	public static final String MOD_ID = "storytelling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override public void onInitialize() {
		LOGGER.info("Initializing {} mod", MOD_ID);
		LOGGER.info("Registering items..."); registerItems();
		LOGGER.info("Registering entities..."); registerEntities();
		LOGGER.info("Registering screen handlers..."); registerScreenHandlers();
		LOGGER.info("The world was written using Storytelling");
	}
}