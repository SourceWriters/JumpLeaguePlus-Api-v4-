package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data;

public final class AreaBox {

    private final Position bottomLeft;
    private final Position topRight;

    public AreaBox(final Position bottomLeft, final Position topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public AreaBox(final ChunkPosition chunk, final int minY, final int maxY) {
        this(Position.of(chunk.getBlockX(), minY, chunk.getBlockZ()), Position.of(chunk.getBlockX() + 15, maxY, chunk.getBlockZ() + 15));
    }

    public AreaBox(final Position origin, final double width, final double length, final double height) {
        double halfWidth = width / 2;
        this.bottomLeft = origin.subtract(width, 0, 0);
        this.topRight = origin.add(halfWidth, length, height);
    }

    public AreaBox(final ChunkPosition origin, final int width, final int length, final int minY, final int maxY) {
        int halfWidth = width >> 2;
        this.bottomLeft = origin.subtract(halfWidth, 0).asPosition(minY);
        this.topRight = origin.add(halfWidth + (width & 0b1), 0).asPosition(maxY).add(15, 0, 15);
    }

    public Position getBottomLeft() {
        return bottomLeft;
    }

    public Position getTopRight() {
        return topRight;
    }

    public AreaBox intersection(AreaBox area) {
        Position low = area.getBottomLeft();
        Position high = area.getTopRight();
        return new AreaBox(
            Position.of(Math.min(bottomLeft.getX(), low.getX()), Math.min(bottomLeft.getY(), low.getY()),
                Math.min(bottomLeft.getZ(), low.getZ())),
            Position.of(Math.max(topRight.getX(), high.getX()), Math.max(topRight.getY(), high.getY()),
                Math.max(topRight.getZ(), high.getZ())));
    }

    public AreaBox intersection(ChunkPosition chunk) {
        return intersection(new AreaBox(chunk, bottomLeft.getNormalizedY(), topRight.getNormalizedY()));
    }

    public boolean intersects(AreaBox area) {
        Position low = area.getBottomLeft();
        Position high = area.getTopRight();
        return topRight.getX() >= low.getX() && high.getX() >= bottomLeft.getX() && topRight.getY() >= low.getY()
            && high.getY() >= bottomLeft.getY() && topRight.getZ() >= low.getZ() && high.getZ() >= bottomLeft.getZ();
    }

    public boolean intersects(ChunkPosition chunk) {
        return intersects(new AreaBox(chunk, bottomLeft.getNormalizedY(), topRight.getNormalizedY()));
    }

    public boolean inside(Position position) {
        return bottomLeft.getX() <= position.getX() && bottomLeft.getY() <= position.getY() && bottomLeft.getZ() <= position.getZ()
            && position.getX() <= topRight.getX() && position.getY() <= topRight.getY() && position.getZ() <= topRight.getZ();
    }

    public boolean inside(double x, double z) {
        return bottomLeft.getX() <= x && bottomLeft.getZ() <= z && x <= topRight.getX() && z <= topRight.getZ();
    }

    public boolean inside(double x, double y, double z) {
        return bottomLeft.getX() <= x && bottomLeft.getY() <= y && bottomLeft.getZ() <= z && x <= topRight.getX() && y <= topRight.getY()
            && z <= topRight.getZ();
    }

}
