package com.github.camsmall.pseudopscience;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

public class PPTool extends ToolItem {
    public PPTool(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }


}
