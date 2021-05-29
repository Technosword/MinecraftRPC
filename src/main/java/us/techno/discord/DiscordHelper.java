package us.techno.discord;


import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscordHelper {

	/**
	 * ClientId of my Discord application.
	 */
	private static final long APP_ID = 847977338637647883L;
	
	private static final String DISCORD_CONNECTION_ERROR_MESSAGE = "<html>An <b>error</b> occurred while trying to connect to <b>Discord</b>!<br>Make sure that:<br>"
			+ "<li>You have the Discord app installed and currently running.</li>"
			+ "<li>You're logged in with your account.</li></html>";
	private static final String DISCORD_ALREADY_DISCONNECTED_MESSAGE = "<html>The connection with <b>Discord</b> ended!</html>";
	
	private final Logger logger = Logger.getLogger(getClass().getName() + "Logger");
	
	private final IPCClient client;
	
	public DiscordHelper() {
		this.client = new IPCClient(APP_ID);
	}
	
	public void onUpdate(Minigame message) {
		logger.log(Level.INFO, "Received new minigame.");
		
		// Update Discord RP
		if(message == null) {
			return;
		}
		if(message.isNull()) {
			client.sendRichPresence(null);
			return;
		}
		
		RichPresence rp = new RichPresenceBuilder(message).build();
		client.sendRichPresence(rp);
		
		logger.log(Level.INFO, "Updated Rich Presence.");
	}

		
		public boolean connect() {
			try {
				client.connect();
			} catch(NoDiscordClientException | RuntimeException e) {
				logger.log(Level.SEVERE, "Something went wrong while trying to connect: {0}", e.getMessage());
				return false;
			}
			logger.log(Level.INFO, "Client successfully connected.");
			return true;
		}
		
		public boolean disconnect() {
			try {
				client.close();
			} catch(IllegalStateException e) {
				logger.log(Level.INFO, "Client is already disconnected.");
				return true;
			}
			logger.log(Level.INFO, "Client successfully disconnected.");
			return true;
	}
		
}
