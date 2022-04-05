package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

final class EmptyMessage implements IMessage {
    
    private static final Placeholder[] EMPTY = new Placeholder[0];

    private final String id;
    private final String language;
    
    private final String string;

    public EmptyMessage(String language, String id) {
        this.id = id;
        this.language = language;
        this.string = id + "#" + language;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String language() {
        return language;
    }

    @Override
    public String fallback() {
        return string;
    }

    @Override
    public String translation() {
        return string;
    }
    
    @Override
    public EmptyMessage translation(String translation) {
        return this;
    }

    @Override
    public String asMessageString(Keyed... placeholders) {
        return string;
    }
    
    @Override
    public String asColoredMessageString(Keyed... placeholders) {
        return string;
    }
    
    @Override
    public Placeholder[] getPlaceholders() {
        return EMPTY;
    }
    
    @Override
    public String asString() {
        return string;
    }

}
