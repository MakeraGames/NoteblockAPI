package gg.makera.noteblock.api.request;

import org.jetbrains.annotations.NotNull;

public final class LeaderboardInfoRequest implements NoteblockRequest {

    private static final String RESOURCE = "leaderboard/%s/%s";

    private final int serverId;
    private final String leaderboardId;

    public LeaderboardInfoRequest(int serverId, @NotNull String leaderboardId) {
        this.serverId = serverId;
        this.leaderboardId = leaderboardId;
    }

    @Override
    public @NotNull String getResource() {
        return String.format(RESOURCE, serverId, leaderboardId);
    }
}
