package com.github.camsmall.pseudopscience;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class PseudoPscience implements ModInitializer {

    // New Blocks
    public static final ParticularAnalysisDevice PARTICULAR_ANALYSIS_DEVICE = new ParticularAnalysisDevice(FabricBlockSettings.of(Material.METAL).strength(2.5f).breakByHand(true));
    // Item Groups
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("pseudopscience", "general"), () -> new ItemStack(PseudoPscience.PARTICULAR_ANALYSIS_DEVICE));
    // Items
    public static final Particle MEDIUM_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 1);
    public static final Particle LARGE_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 2);
    public static final Particle SMALL_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 0);
    // Block Entity
    public static BlockEntityType<ParticularAnalysisDeviceBlockEntity> PARTICULAR_ANALYSIS_DEVICE_BLOCKENTITY;

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("pseudopscience", "particular_analysis_device"), PARTICULAR_ANALYSIS_DEVICE);
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "particular_analysis_device"), new BlockItem(PARTICULAR_ANALYSIS_DEVICE, new FabricItemSettings().group(PseudoPscience.ITEM_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "medium_particle"), MEDIUM_PARTICLE);
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "large_particle"), LARGE_PARTICLE);
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "small_particle"), SMALL_PARTICLE);

        PARTICULAR_ANALYSIS_DEVICE_BLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "pseudopscience:pad_blockentity", FabricBlockEntityTypeBuilder.create(ParticularAnalysisDeviceBlockEntity::new, PARTICULAR_ANALYSIS_DEVICE).build(null));
    }
}
