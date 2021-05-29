package us.techno.discord;

import com.jagrosh.discordipc.entities.RichPresence;

import java.time.OffsetDateTime;

public class RichPresenceBuilder {


	private final Minigame minigame;

	private String field1 = " ";
	private String field2 = " ";
	private String field3 = " ";
	private String field4 = " ";

	private int sizeLength = 0;

	public RichPresenceBuilder(Minigame minigame) {
		this.minigame = minigame;
	}

	public RichPresence build() {
		RichPresence.Builder builder = new RichPresence.Builder();
		
		// If the album isn't set to be displayed, don't show the index and size too.
		int size = 0;
		
		initFields();
		buildFields();

		String rpDetails = field1 + field2;
		String rpState = field3 + field4;
		String state = minigame.getServer();

			OffsetDateTime start = OffsetDateTime.now();
			builder.setStartTimestamp(start);
			builder.setInstance(true);

		builder.setDetails(rpDetails);
		builder.setState(rpState);
		builder.setSmallImage(state.toLowerCase(), state);
		String largeImageKey = "null";
		if (minigame.getServer().equalsIgnoreCase("cubecraft")){
			largeImageKey = "cubecraft";
		} else{
			largeImageKey = "hypixel";
		}
		builder.setLargeImage(largeImageKey);

		return builder.build();
	}

	private void initFields() { // NOSONAR
		String name = minigame.getName();
		String server = minigame.getServer();
		String username = minigame.getUsername();

		field1 = "Minigame: " + name;

		field2 = "Server: " + server;

		field3 = "Username: " + username;

		field4 = "Created by Technosword";
	}

	// Fix the fields' length to make everything stay in one line
	private void buildFields() {
		if (!" ".equals(field2)) {
			if (field1.length() + field2.length() > 74) {
				if (field1.length() > 37) {
					field1 = field1.substring(0, 37 - 3) + "...";
				} else {
					field2 = field2.substring(0, 74 - 3 - field1.length()) + "...";
				}
			}
		} else if (!" ".equals(field4)) {
			int maxLength = 74 - sizeLength;
			if (field3.length() + field4.length() > maxLength) {
				if (field3.length() > maxLength / 2) {
					field3 = field3.substring(0, maxLength / 2 - 3) + "...";
					field4 = field4.substring(0, field4.length() - 3) + "...";
				} else {
					field4 = field4.substring(0, maxLength - field3.length() - 3) + "...";
				}
			}
		}
	}

}
