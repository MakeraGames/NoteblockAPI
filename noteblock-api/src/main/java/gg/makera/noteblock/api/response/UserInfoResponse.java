package gg.makera.noteblock.api.response;

import org.jetbrains.annotations.NotNull;

public class UserInfoResponse implements NoteblockResponse {

    private User user;

    @NotNull
    public User getUser() {
        return user;
    }

}
