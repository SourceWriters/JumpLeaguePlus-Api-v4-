package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data;

public final class ChunkPosition {

    private final int x, z;

    private ChunkPosition(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getBlockX() {
        return x << 4;
    }

    public int getX() {
        return x;
    }

    public int getBlockZ() {
        return z << 4;
    }

    public int getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (x ^ x);
        hash = 19 * hash + (z ^ z);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ChunkPosition)) {
            return false;
        }
        ChunkPosition pos = (ChunkPosition) obj;
        return pos.x == x && pos.z == z;
    }

    public ChunkPosition subtract(ChunkPosition value) {
        return new ChunkPosition(x - value.x, z - value.z);
    }

    public Position add(Position value) {
        return Position.of(getBlockX() + value.getX(), value.getY(), getBlockZ() + value.getZ());
    }

    public Position asPosition() {
        return asPosition(0);
    }

    public Position asPosition(double y) {
        return Position.of(getBlockX(), y, getBlockZ());
    }

    public static int toBlock(int coordinate) {
        return coordinate << 4;
    }

    public static int toChunk(int coordinate) {
        return coordinate >> 4;
    }

    public static ChunkPosition fromBlock(int x, int z) {
        return new ChunkPosition(x >> 4, z >> 4);
    }

    public static ChunkPosition fromChunk(int x, int z) {
        return new ChunkPosition(x, z);
    }

}
