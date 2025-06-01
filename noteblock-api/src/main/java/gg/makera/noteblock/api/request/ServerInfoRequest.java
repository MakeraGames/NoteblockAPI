package gg.makera.noteblock.api.request;

import org.jetbrains.annotations.NotNull;

public final class ServerInfoRequest implements NoteblockRequest {

    private static final String RESOURCE = "server/%s";

    private final int serverId;

    public ServerInfoRequest(int serverId) {
        this.serverId = serverId;
    }

    @Override
    public @NotNull String getResource() {
        return String.format(RESOURCE, serverId);
    }
}
