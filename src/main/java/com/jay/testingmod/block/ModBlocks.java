package com.jay.testingmod.block;

import com.jay.testingmod.TestingMod;
import com.jay.testingmod.block.custom.FirestoneBlock;
import com.jay.testingmod.item.ModItemGroup;
import com.jay.testingmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TestingMod.MOD_ID);

    //Amethyst ore
    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    //Amethyst block
    public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(8f)));

    //Firestone block
    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    //Stairs
    public static final RegistryObject<Block> AMETHYST_STAIRS = registerBlock("amethyst_stairs",
            () -> new StairsBlock(() -> AMETHYST_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));

    //Fence
    public static final RegistryObject<Block> AMETHYST_FENCE = registerBlock("amethyst_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    //Fence Gate
    public static final RegistryObject<Block> AMETHYST_FENCE_GATE = registerBlock("amethyst_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TESTING_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}