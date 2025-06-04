package gg.makera.noteblock.api.response;

import com.google.gson.annotations.SerializedName;

public class User {

    private int id;
    private String name;
    private String email;
    @SerializedName("discord_username")
    private String discordUsername;
    @SerializedName("minecraft_username")
    private String minecraftUsername;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public String getMinecraftUsername() {
        return minecraftUsername;
    }

}