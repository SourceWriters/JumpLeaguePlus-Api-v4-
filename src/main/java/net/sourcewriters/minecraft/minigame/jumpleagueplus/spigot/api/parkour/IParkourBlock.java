package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.bukkit.World;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world.IChunk;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world.IWorld;

public interface IParkourBlock {

    @NonNull
    BlockType getType();

    void place(IWorld world, int x, int y, int z);
    
    void place(IChunk data, int x, int y, int z);

    void place(World world, int x, int y, int z);

    public static enum BlockType {

        START,
        CHEST,
        NONE;

        public void write(DataOutput output) throws IOException {
            output.writeByte(ordinal());
        }

        public static BlockType read(DataInput input) throws IOException {
            return BlockType.values()[input.readByte()];
        }

    }

}
