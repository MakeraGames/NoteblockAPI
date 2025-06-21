package gg.makera.noteblock.api.request;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public final class LeaderboardUpdateRequest implements NoteblockRequest {

    private static final String RESOURCE = "leaderboard/update/%s/%s";

    private final int serverId;
    private final String leaderboardId;
    private final String playerName;
    private final UUID uuid;
    private final double value;

    public LeaderboardUpdateRequest(int serverId,
                                    @NotNull String leaderboardId,
                                    @NotNull UUID uuid,
                                    @NotNull String playerName,
                                    double value) {
        this.serverId = serverId;
        this.leaderboardId = leaderboardId;
        this.playerName = playerName;
        this.uuid = uuid;
        this.value = value;
    }

    @Override
    public @NotNull String getResource() {
        return String.format(RESOURCE, serverId, leaderboardId);
    }

    @Override
    public Map<String, Object> getBody() {
        return Map.of(
                "player_name", playerName,
                "value", value,
                "uuid", uuid
        );
    }
}
