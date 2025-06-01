package gg.makera.noteblock.api.transport;

import org.jetbrains.annotations.NotNull;

public final class ResponseData {

    private final int code;
    private final String body;

    ResponseData(int code, @NotNull String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    @NotNull
    public String getBody() {
        return body;
    }
}
