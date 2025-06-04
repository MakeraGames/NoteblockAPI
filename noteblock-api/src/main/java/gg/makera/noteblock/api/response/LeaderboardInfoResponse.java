package gg.makera.noteblock.api.response;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public final class LeaderboardInfoResponse implements NoteblockResponse {

    private Leaderboard leaderboard;

    @NotNull
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public static class Leaderboard {

        private String name;
        private String legend;

        @SerializedName("players_limit")
        private int playersLimit;
        private List<Entry> entries;

        /**
         * Gets the name of this leaderboard. For instance: {@code top_kills} {@code top_deaths}.
         *
         * @return the display name of this leaderboard
         */
        @NotNull
        public String getName() {
            return name;
        }

        /**
         * Gets the legend of this leaderboard as displayed on the Noteblock platform.
         * For instance: {@code Top Kills} {@code Top Deaths}.
         *
         * @return the legend of this leaderboard
         */
        @NotNull
        public String getLegend() {
            return legend;
        }

        /**
         * Gets the maximum number of displayable entries on this leaderboard.
         *
         * @return maximum number of displayable entries
         */
        public int getPlayersLimit() {
            return playersLimit;
        }

        /**
         * Gets the current entries of this leaderboard
         *
         * @return current entries
         */
        @NotNull
        public List<Entry> getEntries() {
            return entries;
        }

        public static class Entry {

            private String playerName;
            private double value;

            @SerializedName("entry_position")
            private int position;

            @SerializedName("created_at")
            private Date createdOn;

            @SerializedName("updated_at")
            private Date updatedOn;

            /**
             * Gets the player name of this leaderboard entry.
             *
             * @return player name
             */
            @NotNull
            public String getPlayerName() {
                return playerName;
            }

            /**
             * Gets the value (such as kills, deaths) of this leaderboard entry
             *
             * @return entry value (aka statistic)
             */
            public double getValue() {
                return value;
            }

            /**
             * Gets the position of this entry in the leaderboard.
             *
             * @return position of this entry
             */
            public int getPosition() {
                return position;
            }

            /**
             * Gets the date this leaderboard was created on.
             *
             * @return date of creation
             */
            @NotNull
            public Date getCreatedOn() {
                return createdOn;
            }

            /**
             * Gets the date this leaderboard was last updated on.
             *
             * @return last updated date
             */
            @NotNull
            public Date getUpdatedOn() {
                return updatedOn;
            }
        }
    }
}
