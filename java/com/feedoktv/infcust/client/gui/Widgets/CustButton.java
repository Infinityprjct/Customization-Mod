package com.feedoktv.infcust.client.gui.Widgets;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

import java.util.Objects;


public class CustButton extends Button {

    public boolean active = true;
    public boolean isHovered;
    private boolean focused;
    private boolean wasHovered;
    public static final ResourceLocation CUSTWIDGETS = new ResourceLocation("infcust:textures/gui/widgets.png");

    public CustButton(int p_i232255_1_, int p_i232255_2_, int p_i232255_3_, int p_i232255_4_, ITextComponent p_i232255_5_, IPressable p_i232255_6_) {
        super(p_i232255_1_, p_i232255_2_, p_i232255_3_, p_i232255_4_, p_i232255_5_, p_i232255_6_);

    }

    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {



            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer fontrenderer = minecraft.font;
            minecraft.getTextureManager().bind(CUSTWIDGETS);
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 0.7F);
            int i = this.getYImage(this.isHovered());
            ;
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            this.blit(p_230430_1_, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
            this.blit(p_230430_1_, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.renderBg(p_230430_1_, minecraft, p_230430_2_, p_230430_3_);
            int j = 16777215;
            drawCenteredString(p_230430_1_, fontrenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
            if (this.visible) {
                this.isHovered = p_230430_2_ >= this.x && p_230430_3_ >= this.y && p_230430_2_ < this.x + this.width && p_230430_3_ < this.y + this.height;
                if (this.wasHovered != this.isHovered()) {
                    if (this.isHovered()) {
                        if (this.focused) {
                            this.queueNarration(200);
                        } else {
                            this.queueNarration(750);
                        }
                    } else {
                        this.nextNarration = Long.MAX_VALUE;
                    }
                }

                this.narrate();
                this.wasHovered = this.isHovered();
            }
        }


    public boolean mouseDragged(double p_231045_1_, double p_231045_3_, int p_231045_5_, double p_231045_6_, double p_231045_8_) {
        if (this.isValidClickButton(p_231045_5_)) {
            this.onDrag(p_231045_1_, p_231045_3_, p_231045_6_, p_231045_8_);
            return true;
        } else {
            return false;
        }
    }

    protected boolean clicked(double p_230992_1_, double p_230992_3_) {
        return this.active && this.visible && p_230992_1_ >= (double)this.x && p_230992_3_ >= (double)this.y && p_230992_1_ < (double)(this.x + this.width) && p_230992_3_ < (double)(this.y + this.height);
    }

    public boolean isHovered() {
        return this.isHovered || this.focused;
    }

    public boolean changeFocus(boolean p_231049_1_) {
        if (this.active && this.visible) {
            this.focused = !this.focused;
            this.onFocusedChanged(this.focused);
            return this.focused;
        } else {
            return false;
        }
    }

    protected void onFocusedChanged(boolean p_230995_1_) {
    }

    public boolean isMouseOver(double p_231047_1_, double p_231047_3_) {
        return this.active && this.visible && p_231047_1_ >= (double)this.x && p_231047_3_ >= (double)this.y && p_231047_1_ < (double)(this.x + this.width) && p_231047_3_ < (double)(this.y + this.height);
    }

    public void renderToolTip(MatrixStack p_230443_1_, int p_230443_2_, int p_230443_3_) {
    }

    public void playDownSound(SoundHandler p_230988_1_) {
        p_230988_1_.play(SimpleSound.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int p_230991_1_) {
        this.width = p_230991_1_;
    }

    public void setHeight(int value) {
        this.height = value;
    }

    public void setAlpha(float p_230986_1_) {
        this.alpha = p_230986_1_;
    }

    public boolean isFocused() {
        return this.focused;
    }

    protected void setFocused(boolean p_230996_1_) {
        this.focused = p_230996_1_;
    }


}
