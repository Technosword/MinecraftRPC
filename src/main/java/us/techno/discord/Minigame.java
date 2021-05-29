package us.techno.discord;

import java.util.Objects;

public class Minigame {

    public static final Minigame NULL_MINIGAME = new Minigame();

    private String name;
    private String server;
    private String username;


    private Minigame() {
        this.name = null;
        this.server = null;
        this.username = null;
    }

    public Minigame(String name, String server, String username) {
        this.name = Objects.requireNonNull(name);
        this.server = Objects.requireNonNull(server);
        this.username = Objects.requireNonNull(username);
    }

    public String getName() {
        return name;
    }

    public String getServer() {
        return server;
    }

    public String getUsername() {
        return username;
    }



    public boolean isNull() {
        return this == NULL_MINIGAME;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name: ").append(name).append("\nServer: ").append(server).append("\nUsername: ").append(username).toString();
    }

}

