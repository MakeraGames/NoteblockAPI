package gg.makera.noteblock.api.transport;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Request {

    private final String url;
    private final Map<String, String> headers;
    private final String body;

    Request(@NotNull String url, @NotNull Map<String, String> headers, @Nullable String body) {
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    @NotNull
    public String getUrl() {
        return url;
    }

    @Nullable
    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @Nullable
    public String getHeader(@NotNull String key) {
        return headers.get(key);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static class Builder {

        private String url;

        private final Map<String, String> headers = new HashMap<>();
        private String body;

        private Builder() {}

        @Contract("_, _ -> this")
        public Builder url(@NotNull String url, @NotNull Object... params) {
            this.url = params.length > 0 ? String.format(url, params) : url;
            return this;
        }

        @Contract("_, _ -> this")
        public Builder header(@NotNull String name, @NotNull String value) {
            headers.put(name, value);
            return this;
        }

        @Contract("_ -> this")
        public Builder body(@NotNull String body) {
            this.body = body;
            return this;
        }

        @Contract("-> new")
        public Request build() {
            Objects.requireNonNull(url, "No url is specified");
            return new Request(url, headers, body);
        }
    }
}
