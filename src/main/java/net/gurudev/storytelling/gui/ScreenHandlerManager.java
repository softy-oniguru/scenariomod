package net.gurudev.storytelling.gui;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static net.gurudev.storytelling.Main.MOD_ID;

public class ScreenHandlerManager {
	public static ScreenHandlerType<StorytellerScreenHandler> STORYTELLER_SCREEN_HANDLER_TYPE;

	public static void registerScreenHandlers() {
		STORYTELLER_SCREEN_HANDLER_TYPE = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID,"screen_handler"),
				new ExtendedScreenHandlerType<>(StorytellerScreenHandler::new,PacketCodecs.UNLIMITED_NBT_COMPOUND));
	}
}