package gg.makera.noteblock.api;

import gg.makera.noteblock.api.transport.DefaultNoteblockTransport;
import gg.makera.noteblock.api.transport.NoteblockTransport;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class NoteblockAPIFactory {

    private static final Supplier<NoteblockTransport> DEFAULT_TRANSPORT_SUPPLIER = DefaultNoteblockTransport::new;

    private NoteblockAPIFactory() {}

    @NotNull
    public static NoteblockAPI create(@NotNull NoteblockTransport transport, @NotNull String apiKey) {
        return new NoteblockAPIImpl(transport, apiKey);
    }

    @NotNull
    public static NoteblockAPI create(@NotNull String apiKey) {
        return create(DEFAULT_TRANSPORT_SUPPLIER.get(), apiKey);
    }
}
