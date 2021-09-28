package com.github.camsmall.pseudopscience;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Particle extends Item {

    // 0, 1, or 2 (small, med, large)
    public int size = -1;

    // Default constructor
    public Particle(Settings settings) {
        super(settings);
    }

    // Constructor to set size
    public Particle(Settings settings, int size) {
        super(settings);
        this.size = size;
    }

    public String getSize() {
        return switch (size) {
            case -1 -> "n/a";
            case 0 -> "Small";
            case 1 -> "Medium";
            case 2 -> "Large";
            default -> "Switch in Particle.java defaulted somehow?";
        };
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
        if (!world.isClient) {
            playerEntity.sendMessage(new LiteralText(this.getSize()), false);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
