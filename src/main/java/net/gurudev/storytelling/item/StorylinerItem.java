package net.gurudev.storytelling.item;

import net.gurudev.storytelling.entity.EntityManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import static net.gurudev.storytelling.gui.ScreenHandlerManager.STORYTELLER_SCREEN_HANDLER_TYPE;

public class StorylinerItem extends Item {
	public StorylinerItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
		if (entity.getType() == EntityManager.STORYTELLER) {
			if (!player.getWorld().isClient) {
				player.sendMessage(Text.of("Your story is being recorded..."), false);
				player.openHandledScreen((NamedScreenHandlerFactory) STORYTELLER_SCREEN_HANDLER_TYPE);
			} player.getItemCooldownManager().set(this, 20);
			return ActionResult.success(true);
		} else {
			return ActionResult.SUCCESS_NO_ITEM_USED;
		}
	}
}