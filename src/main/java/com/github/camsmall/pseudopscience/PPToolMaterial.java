package com.github.camsmall.pseudopscience;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PPToolMaterial implements ToolMaterial {

    public static final PPToolMaterial INSTANCE = new PPToolMaterial();

    @Override
    public int getDurability() {
        return Integer.MAX_VALUE;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6F;
    }

    @Override
    public float getAttackDamage() {
        return 1F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
