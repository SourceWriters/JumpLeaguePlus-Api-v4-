package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data;

import static net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.BitHelper.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public final class Position {

    private final double x, y, z;

    private Position(long packed) {
        this.x = unmerge20BitUnsigned(packed >> 44);
        this.z = unmerge20BitUnsigned(packed >> 24);
        this.y = unmerge24BitSigned(packed);
    }

    private Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public int getNormalizedX() {
        return (int) Math.floor(x);
    }

    public double getY() {
        return y;
    }

    public int getNormalizedY() {
        return (int) Math.floor(y);
    }

    public double getZ() {
        return z;
    }

    public int getNormalizedZ() {
        return (int) Math.floor(z);
    }

    public long pack() {
        return merge20BitUnsigned((long) getNormalizedX()) << 44 | merge20BitUnsigned((long) getNormalizedZ()) << 24
            | merge24BitSigned((long) getNormalizedY());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        int nx = getNormalizedX();
        int ny = getNormalizedY();
        int nz = getNormalizedZ();
        hash = 19 * hash + (nx ^ nx);
        hash = 19 * hash + (ny ^ ny);
        hash = 19 * hash + (nz ^ nz);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return getNormalizedX() == position.getNormalizedX() && getNormalizedY() == position.getNormalizedY()
            && getNormalizedZ() == position.getNormalizedZ();
    }

    public void write(DataOutput output) throws IOException {
        output.writeLong(pack());
    }

    public double distance(Position position) {
        return Math.sqrt(distanceSquared(position));
    }

    public double distance(Location location) {
        return Math.sqrt(distanceSquared(location));
    }

    public double distance(double x, double y, double z) {
        return Math.sqrt(distanceSquared(x, y, z));
    }

    public double distanceSquared(Position position) {
        return distanceSquared(position.getX(), position.getY(), position.getZ());
    }

    public double distanceSquared(Location location) {
        return distanceSquared(location.getX(), location.getY(), location.getZ());
    }

    public double distanceSquared(double x, double y, double z) {
        return this.x * x + this.y * y + this.z * z;
    }

    public double distance2D(Position position) {
        return Math.sqrt(distance2DSquared(position));
    }

    public double distance2D(Location location) {
        return Math.sqrt(distance2DSquared(location));
    }

    public double distance2D(double x, double z) {
        return Math.sqrt(distance2DSquared(x, z));
    }

    public double distance2DSquared(Position position) {
        return distance2DSquared(position.getX(), position.getZ());
    }

    public double distance2DSquared(Location location) {
        return distance2DSquared(location.getX(), location.getZ());
    }

    public double distance2DSquared(double x, double z) {
        return this.x * x + this.z * z;
    }

    public Location asLocation(World world) {
        return new Location(world, x, y, z);
    }

    public ChunkPosition asChunk() {
        return ChunkPosition.fromBlock(getNormalizedX(), getNormalizedZ());
    }

    public Block getBlock(World world) {
        return world.getBlockAt(getNormalizedX(), getNormalizedY(), getNormalizedX());
    }

    public static Position unpack(long packed) {
        return new Position(packed);
    }

    public static Position of(double x, double y, double z) {
        return new Position(x, y, z);
    }

    public static Position read(DataInput input) throws IOException {
        return new Position(input.readLong());
    }

}
