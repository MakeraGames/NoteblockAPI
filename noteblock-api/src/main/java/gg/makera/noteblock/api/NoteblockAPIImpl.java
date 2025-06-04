package gg.makera.noteblock.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gg.makera.noteblock.api.exception.BadResponseCodeException;
import gg.makera.noteblock.api.exception.InconsistentResponseFormatException;
import gg.makera.noteblock.api.request.*;
import gg.makera.noteblock.api.response.*;
import gg.makera.noteblock.api.transport.NoteblockTransport;
import gg.makera.noteblock.api.transport.Request;
import gg.makera.noteblock.api.transport.ResponseData;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class NoteblockAPIImpl implements NoteblockAPI {

    private static final Gson GSON = new GsonBuilder().create();

    private static final String API_KEY_HEADER_NAME = "X-API-Key";
    private static final String USER_AGENT_HEADER_NAME = "User-Agent";

    private final NoteblockTransport transport;
    private final String apiKey;

    NoteblockAPIImpl(@NotNull NoteblockTransport transport, @NotNull String apiKey) {
        this.transport = transport;
        this.apiKey = apiKey;
    }

    @Override
    public CompletableFuture<ServerInfoResponse> getServerInfo(int serverId) {
        return request(ServerInfoResponse.class, new ServerInfoRequest(serverId));
    }

    @Override
    public CompletableFuture<LeaderboardInfoResponse> getLeaderboardInfo(int serverId, @NotNull String leaderboardId) {
        return request(LeaderboardInfoResponse.class, new LeaderboardInfoRequest(serverId, leaderboardId));
    }

    @Override
    public CompletableFuture<LeaderboardUpdateResponse> updateLeaderboard(int serverId,
                                                                          @NotNull String leaderboardId,
                                                                          @NotNull String playerName,
                                                                          int value) {
        return request(LeaderboardUpdateResponse.class, new LeaderboardUpdateRequest(serverId, leaderboardId, playerName, value));
    }

    @Override
    public CompletableFuture<UserInfoResponse> getUser() {
        return request(UserInfoResponse.class, new UserInfoRequest());
    }

    private <T extends NoteblockResponse> CompletableFuture<T> request(Class<T> expectedResponseClass,
                                                                       NoteblockRequest request) {
        Request.Builder requestDataBuilder = Request.builder()
                .header(API_KEY_HEADER_NAME, apiKey)
                .header(USER_AGENT_HEADER_NAME, USER_AGENT)
                .url(API_URL.concat(request.getResource()));

        Map<String, Object> requestBody = request.getBody();
        if (requestBody != null && !requestBody.isEmpty()) {
            requestDataBuilder.body(GSON.toJson(requestBody));
        }

        return transport.sendRequest(requestDataBuilder.build())
                .thenApply(responseData -> processResponse(responseData, expectedResponseClass));
    }

    private <T extends NoteblockResponse> T processResponse(ResponseData responseData, Class<T> responseClass) {
        int code = responseData.getCode();
        String body = responseData.getBody();

        if (code != 200) {
            // Bad response code
            JsonObject object = GSON.fromJson(body, JsonObject.class);

            String cause = "No error message is provided";
            if (object.has("message"))
                cause = object.get("message").getAsString();

            throw new BadResponseCodeException(code, cause);
        }

        try {
            return GSON.fromJson(body, responseClass);
        } catch (Exception e) {
            throw new InconsistentResponseFormatException(e.getMessage());
        }
    }

    @Override
    public void close() {
        transport.close();
    }
}
