package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import java.util.Objects;

public abstract class ChunkTask {

    public static final long NOT_QUEUED = -1L;

    protected final IChunkPopulator task;

    protected long id = NOT_QUEUED;
    protected boolean executed = false;

    public ChunkTask(IChunkPopulator task) {
        this.task = Objects.requireNonNull(task);
    }

    public abstract IChunk getChunk();

    public IChunkPopulator getTask() {
        return task;
    }

    public long getId() {
        return id;
    }

    public boolean isExecuted() {
        return executed;
    }

    public boolean isQueued() {
        return id != NOT_QUEUED;
    }

    public abstract boolean enqueue();

    public abstract boolean dequeue();

}
