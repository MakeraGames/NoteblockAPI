package gg.makera.noteblock.api.transport;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public interface NoteblockTransport {

    CompletableFuture<ResponseData> sendRequest(@NotNull Request request);

    void close();
}
