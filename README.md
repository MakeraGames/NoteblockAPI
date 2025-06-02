![banner](assets/noteblock-logo.svg)

# NoteblockAPI (In development)

The official API implementation in Java for the Noteblock platform. This API allows server owners and developers to retrieve and update information about Minecraft servers on Noteblock.

## What is Noteblock?

Noteblock is a platform, launched in April 2025, for discovering Minecraft servers. It features curated server
listings across categories such as PvP, Creative, Adventure, Minigames, etc. Including real-time server leaderboards, community feedback,
and trending picks. Noteblock makes it easy for players to find their next favorite server.

## Documentation

Click [here](https://noteblock.gg/api/documentation) to check out the API documentation. (Heavily subject to change)

## Usage

You may use the [Ultimis repository](https://repo.ultimismc.com/) to download one or more of the following as a dependency artifact:
- [noteblock-api](noteblock-api/)
- [noteblock-api-transport-core](noteblock-api-transport-core/)

### Maven
```xml
<repositories>
    <repository>
        <id>ultimis</id>
        <url>https://repo.ultimismc.com/repository/makera/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>gg.makera</groupId>
        <artifactId>noteblock-api</artifactId>
        <version>0.1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

### Gradle (Kotlin DSL)
```gradle
repositories {
    maven("https://repo.ultimismc.com/repository/makera/")
}

dependencies {
    implementation("gg.makera:noteblock-api:0.1.0-SNAPSHOT")
}
```

## Example:

```java
public final class Example {

    public static void main(String[] args) {
        // Note: Given that CompletableFuture#join is a blocking operation, we'll be using it to prevent the
        // NoteblockAPI instance from closing before we've received a response. Use #thenAccept instead.

        // Create a new NoteblockAPI instance with an API key

        try (NoteblockAPI noteblockAPI = NoteblockAPIFactory.create("your-api-key-here")) {
            // Fetch server information by server id, then wait for a response.
            ServerInfoResponse serverInfoResponse = noteblockAPI.getServerInfo(22).join();

            // Get the server object from the response.
            Server server = serverInfoResponse.getServer();

            System.out.println("Server Name: " + server.getName());
            System.out.println("Server IP address: " + server.getIpAddress() + ":" + server.getPort());
            System.out.println("Server Version: " + server.getVersion()); // e.g "1.8.9 (47)"
            System.out.println("Server Players: " + server.getOnlinePlayers() + "/" + server.getMaximumPlayers());

            // Leaderboards
            // Fetch server leaderboard by server id and leaderboard id, then wait for a response.
            LeaderboardInfoResponse leaderboardInfoResponse = noteblockAPI.getLeaderboardInfo(22, "kills").join();

            // Get the leaderboard object from the response
            LeaderboardInfoResponse.Leaderboard leaderboard = leaderboardInfoResponse.getLeaderboard();

            // Print leaderboard entries
            System.out.println("Kills Leaderboard:");
            for (LeaderboardInfoResponse.Leaderboard.Entry entry : leaderboard.getEntries()) {
                int position = entry.getPosition();

                String playerName = entry.getPlayerName();
                int value = entry.getValue();

                System.out.println("- #" + position + " - " + playerName + " - " + value); // e.g: #1 - DirectPlan - 100
            }

        } catch (Exception e) {
            // An internal error occurred. Always ensure that you properly handle exceptions.
            throw new RuntimeException(e);
        }
    }
}
```
