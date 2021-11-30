package com.jay.testingmod.block;

import com.jay.testingmod.TestingMod;
import net.minecraft.block.WoodType;
import net.minecraft.util.ResourceLocation;

public class ModWoodTypes {
    public static final WoodType REDWOOD =
            WoodType.create(new ResourceLocation(TestingMod.MOD_ID, "redwood").toString());
}
