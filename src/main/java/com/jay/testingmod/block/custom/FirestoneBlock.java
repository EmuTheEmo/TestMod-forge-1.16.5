package com.jay.testingmod.block.custom;

import com.jay.testingmod.item.custom.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class FirestoneBlock extends Block {
    public FirestoneBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if(handIn == Hand.MAIN_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Main Hand!");
            }
            if(handIn == Hand.OFF_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Off Hand!");
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        float chance = 0.35f;
        if(chance < random.nextFloat()) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + random.nextDouble(),
                    0d,0.05d,0d);

            world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, state), pos.getX() + random.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + random.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }

        super.animateTick(state, world, pos, random);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote()) {
            System.out.println("I left-clicked a FirestoneBlock");
        }
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 5);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
