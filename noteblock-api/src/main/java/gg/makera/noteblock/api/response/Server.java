package gg.makera.noteblock.api.response;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Represents a Noteblock server
 */
public final class Server {

    private int id;
    private String name;
    private String slug;

    @SerializedName("ip")
    private String ipAddress;

    private int port;

    private Version version;

    @SerializedName("created_at")
    private Date createdOn;

    @SerializedName("updated_at")
    private Date updatedOn;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("online_players_count")
    private int onlinePlayers;

    @SerializedName("max_players")
    private int maximumPlayers;

    @SerializedName("is_online")
    private boolean onlineMode;

    @SerializedName("motd")
    private String messageOfDay;

    @SerializedName("vote_statistics")
    private VoteStatistics voteStatistics;

    private Category category;

    /**
     * Gets the id that references this server
     * in the Noteblock database.
     *
     * @return id of the server
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of this server.
     *
     * @return name of this server
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Gets the slug of this server.
     *
     * @return slug of this server
     */
    @NotNull
    public String getSlug() {
        return slug;
    }

    /**
     * Gets the IP address of this server.
     *
     * @return IP address of this server
     */
    @NotNull
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Gets the port bound to the server's IP address.
     *
     * @return port of this server
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets the country code of this server.
     * <p>
     * Example: {@code MA}, {@code US}, {@code CA}
     *
     * @return country code of this server
     */
    @NotNull
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Gets the online player count of this server.
     *
     * @return online player count of this server
     */
    public int getOnlinePlayers() {
        return onlinePlayers;
    }

    /**
     * Gets the maximum amount of players supported by this server.
     *
     * @return maximum amount of players supported by this server
     */
    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    /**
     * Gets whether this server is on online mode.
     * In other words, this indicates whether the server is on premium or cracked mode.
     *
     * @return whether this server is online mode
     */
    public boolean isOnlineMode() {
        return onlineMode;
    }

    /**
     * Gets the message of the day of this server. Mainly known as MOTD.
     *
     * @return message of the day of this server
     */
    @NotNull
    public String getMessageOfDay() {
        return messageOfDay;
    }

    /**
     * Gets the category of this server.
     *
     * @return category of this server
     */
    @NotNull
    public Category getCategory() {
        return category;
    }

    /**
     * Gets the version supported by this server.
     *
     * @return version supported by this server
     */
    @NotNull
    public Version getVersion() {
        return version;
    }

    /**
     * Gets the vote statistics of this server.
     *
     * @return vote statistics of this server
     */
    @NotNull
    public VoteStatistics getVoteStatistics() {
        return voteStatistics;
    }

    /**
     * Gets the date this server was created, in milliseconds.
     *
     * @return date this server was created, in milliseconds
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Gets the date this server was updated, in milliseconds.
     *
     * @return date this server was updated, in milliseconds
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    public static class Category {

        private String name;

        @SerializedName("sort_priority")
        private int sortPriority;

        /**
         * Gets the name of this category.
         *
         * @return name of this category
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the sort priority of this category on the Noteblock platform.
         *
         * @return sort priority of this category
         */
        public int getSortPriority() {
            return sortPriority;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class VoteStatistics {

        private int daily;
        private int weekly;
        private int monthly;

        /**
         * Gets the daily votes of this server.
         *
         * @return daily votes of this server
         */
        public int getDailyVotes() {
            return daily;
        }

        /**
         * Gets the weekly votes of this server.
         *
         * @return weekly votes of this server
         */
        public int getWeeklyVotes() {
            return weekly;
        }

        /**
         * Gets the monthly votes of this server.
         *
         * @return monthly votes of this server
         */
        public int getMonthlyVotes() {
            return monthly;
        }

        @Override
        public String toString() {
            return "VoteStatistics{" +
                    "daily=" + daily +
                    ", weekly=" + weekly +
                    ", monthly=" + monthly +
                    '}';
        }
    }

    public static class Version {

        @SerializedName("protocol_id")
        private int protocol;
        private String name;

        /**
         * Gets the protocol id of this version.
         * <p>
         * Example: Protocol version of {@code 1.8.9} is {@code 47}
         *
         * @return protocol id of this version
         */
        public int getProtocol() {
            return protocol;
        }

        /**
         * Gets the version name of this server.
         *
         * @return version name of this version
         */
        @NotNull
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "(" + protocol + ")";
        }
    }
}
