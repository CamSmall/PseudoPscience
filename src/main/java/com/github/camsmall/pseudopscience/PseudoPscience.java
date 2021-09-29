package com.github.camsmall.pseudopscience;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class PseudoPscience implements ModInitializer {

    public static final String MOD_ID = "pseudopscience";
    // a public identifier for multiple parts of our bigger chest
    public static final Identifier PAD = new Identifier(MOD_ID, "particular_analysis_device");

    public static final ScreenHandlerType<PADScreenHandler> PAD_SCREEN_HANDLER;

    // Item Groups
    public static final ItemGroup ITEM_GROUP;
    public static final ItemGroup TOOLS;
    // Items
    public static final Particle MEDIUM_PARTICLE;
    public static final Particle LARGE_PARTICLE;
    public static final Particle SMALL_PARTICLE;
    // New Blocks
    public static final ParticularAnalysisDevice PARTICULAR_ANALYSIS_DEVICE;
    // Block Entity
    public static final BlockEntityType<ParticularAnalysisDeviceBlockEntity> PARTICULAR_ANALYSIS_DEVICE_BLOCKENTITY;

    // Tools
    public static final PPTool PARTICULAR_ACQUISITION_TOOL;

    static {
        ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("pseudopscience", "general"), () -> new ItemStack(PseudoPscience.PARTICULAR_ANALYSIS_DEVICE));
        TOOLS = FabricItemGroupBuilder.build(new Identifier("pseudopscience", "tools"), () -> new ItemStack(PseudoPscience.PARTICULAR_ACQUISITION_TOOL));

        MEDIUM_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 1);
        LARGE_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 2);
        SMALL_PARTICLE = new Particle(new FabricItemSettings().group(PseudoPscience.ITEM_GROUP), 0);

        PARTICULAR_ANALYSIS_DEVICE = Registry.register(Registry.BLOCK, PAD, new ParticularAnalysisDevice(FabricBlockSettings.of(Material.METAL).strength(2.5f).breakByHand(true)));

        PARTICULAR_ANALYSIS_DEVICE_BLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "pseudopscience:pad_blockentity", FabricBlockEntityTypeBuilder.create(ParticularAnalysisDeviceBlockEntity::new, PARTICULAR_ANALYSIS_DEVICE).build(null));

        PARTICULAR_ACQUISITION_TOOL = new ParticularAcquisitionTool(PPToolMaterial.INSTANCE, new Item.Settings().group(PseudoPscience.TOOLS));

        PAD_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(PAD, PADScreenHandler::new);
    }

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "medium_particle"), MEDIUM_PARTICLE);
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "large_particle"), LARGE_PARTICLE);
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "small_particle"), SMALL_PARTICLE);

        // Tools
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "particular_acquisition_tool"), PARTICULAR_ACQUISITION_TOOL);

        // Block Item
        Registry.register(Registry.ITEM, new Identifier("pseudopscience", "particular_analysis_device"), new BlockItem(PARTICULAR_ANALYSIS_DEVICE, new FabricItemSettings().group(PseudoPscience.ITEM_GROUP)));
    }
}
