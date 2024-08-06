package net.gurudev.storytelling.item;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.gurudev.storytelling.entity.EntityManager;
import net.gurudev.storytelling.entity.StorytellerEntity;
import net.gurudev.storytelling.gui.StorytellerScreenHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class StorylinerItem extends Item {
	public StorylinerItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
		if (entity.getType() == EntityManager.STORYTELLER) {
			if (!player.getWorld().isClient) {
				player.sendMessage(Text.of("Your story is being recorded..."), false);
				player.openHandledScreen(new ExtendedScreenHandlerFactory() {
					@Override
					public Object getScreenOpeningData(ServerPlayerEntity player) {
						return new NbtCompound();
					}

					@Override
					public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
						return new StorytellerScreenHandler(syncId, playerInventory, (StorytellerEntity) entity);
					}

					@Override
					public Text getDisplayName() {
						return Text.empty();
					}
				});
			} player.getItemCooldownManager().set(this, 20);
			return ActionResult.success(true);
		} else {
			return ActionResult.SUCCESS_NO_ITEM_USED;
		}
	}
}