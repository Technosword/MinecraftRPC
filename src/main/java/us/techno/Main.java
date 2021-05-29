package us.techno;

import us.techno.discord.DiscordHelper;
import us.techno.discord.Minigame;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName() + "Logger");

    private Main() {
        super();
    }
    String appdata = System.getenv("APPDATA");
    String launcher_data_fullpath = appdata + "\\.minecraft\\launcher_profiles.json";
    String logs_fullpath = appdata + "\\.minecraft\\logs\\latest.log";
    Date start_time = new Date(System.currentTimeMillis());
    public static void main(String[] args){
        DiscordHelper discordHelper = new DiscordHelper();
        discordHelper.connect();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        discordHelper.onUpdate(new Minigame("test", "cubecraft", "me"));
    }
}

