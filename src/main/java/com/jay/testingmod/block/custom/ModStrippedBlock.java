package com.jay.testingmod.block.custom;

import com.jay.testingmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModStrippedBlock extends RotatedPillarBlock {

    private final BlockState stripped;
    public ModStrippedBlock(BlockState state, Properties properties) {
        super(properties);
        this.stripped = state;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.AXE ? stripped.with(AXIS, state.get(AXIS)) : null;
    }
}
