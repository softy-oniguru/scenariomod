package net.gurudev.storytelling.gui;

import net.gurudev.storytelling.entity.StorytellerEntity;
import net.gurudev.storytelling.gui.widget.ButtonRowElement;
import net.gurudev.storytelling.gui.widget.GuiElement;
import net.gurudev.storytelling.gui.widget.TextRowElement;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

import java.util.Optional;

public class StorytellerScreen extends HandledScreen<StorytellerScreenHandler> {
    private final PlayerEntity player;
    public StorytellerScreen(StorytellerScreenHandler handler, PlayerInventory inventory, Text text) {
        super(handler, inventory, Text.empty());
        this.player = inventory.player;
    }

    protected Optional<StorytellerEntity> getStorytellerEntity() {
        return Optional.of(this.handler).flatMap(StorytellerScreenHandler::getStorytellerEntity);
    }

    @Override
    protected void init() {
        super.init(); GuiElement gui = new GuiElement(width, height);

        TextRowElement textureRow = new TextRowElement(this, this.textRenderer, -gui.offset*2, Text.translatable("storytelling.settings.texture"), "");
        this.addDrawableChild(textureRow.getText()); this.addDrawableChild(textureRow.getElement());

        TextRowElement modelRow = new TextRowElement(this, this.textRenderer, -gui.offset, Text.translatable("storytelling.settings.model"), "");
        this.addDrawableChild(modelRow.getText()); this.addDrawableChild(modelRow.getElement());

        ButtonRowElement storylineRow = new ButtonRowElement(this, this.textRenderer, gui.offset, Text.translatable("storytelling.settings.storyline"), callback ->
                this.close());
        this.addDrawableChild(storylineRow.getText()); this.addDrawableChild(storylineRow.getElement());

        TextWidget titleText = new TextWidget(gui.centerX-gui.guiWidth/2, gui.centerY/2-gui.guiHeight/2, gui.guiWidth, gui.guiHeight,
                Text.translatable("storytelling.settings.title"), this.textRenderer);

        ButtonWidget successButton = ButtonWidget.builder(Text.translatable("gui.done"), callback -> {
//            NbtCompound nbtCompound = new NbtCompound();
//            nbtCompound.putString("texture", textureRow.getElement().getText());
//            nbtCompound.putString("model", modelRow.getElement().getText());
//            entity.readCustomDataFromNbt(nbtCompound);
            this.close();
        }).dimensions(gui.centerX-gui.guiWidth/2, gui.centerY+gui.centerY/2-gui.guiHeight/2, gui.guiWidth, gui.guiHeight).build();
        this.addDrawableChild(titleText); this.addDrawableChild(successButton);
    }

    //@Override public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {}

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }

    @Override protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {}

//    drawableElement.setX(drawableElement.getX()-drawableElement.getWidth()/2);
//    drawableElement.setY(drawableElement.getX()-drawableElement.getHeight()/2);

}