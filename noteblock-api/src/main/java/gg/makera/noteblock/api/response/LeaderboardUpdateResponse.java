package gg.makera.noteblock.api.response;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public final class LeaderboardUpdateResponse implements NoteblockResponse {

    private String message;

    @SerializedName("entry_id")
    private int entryId;

    @NotNull
    public String getMessage() {
        return message;
    }

    public int getEntryId() {
        return entryId;
    }
}
