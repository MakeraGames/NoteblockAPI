package gg.makera.noteblock.api;

import gg.makera.noteblock.api.response.LeaderboardInfoResponse;
import gg.makera.noteblock.api.response.LeaderboardUpdateResponse;
import gg.makera.noteblock.api.response.ServerInfoResponse;
import gg.makera.noteblock.api.response.User;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public interface NoteblockAPI extends AutoCloseable {

    String API_URL = "https://noteblock.gg/api/v1/";
    String USER_AGENT = "NoteblockAPI/0.1.0";

    CompletableFuture<ServerInfoResponse> getServerInfo(int serverId);

    CompletableFuture<LeaderboardInfoResponse> getLeaderboardInfo(int serverId, @NotNull String leaderboardId);

    CompletableFuture<LeaderboardUpdateResponse> updateLeaderboard(int serverId,
                                                                   @NotNull String leaderboardId,
                                                                   @NotNull String playerName,
                                                                   int value);

    /**
     * Retrieves the user associated with the API key.
     *
     * @return Associated user
     */
    User getUser();

    void close();
}
