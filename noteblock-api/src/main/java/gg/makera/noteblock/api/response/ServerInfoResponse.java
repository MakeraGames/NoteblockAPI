package gg.makera.noteblock.api.response;

import org.jetbrains.annotations.NotNull;

public final class ServerInfoResponse implements NoteblockResponse {

    private Server server;

    @NotNull
    public Server getServer() {
        return server;
    }
}
