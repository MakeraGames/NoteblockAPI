package gg.makera.noteblock.api.request;

import org.jetbrains.annotations.NotNull;

public class UserInfoRequest implements NoteblockRequest {

    @Override
    public @NotNull String getResource() {
        return "user";
    }

}
