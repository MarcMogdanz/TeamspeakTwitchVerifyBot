package de.marcmogdanz.ttvb;

public class VerifyManager {
	private static Config config;
	
	public static void main(String[] args) {
		config = new Config();
		config.loadConfig();
		startTwitchBot();
		startTeamspeakBot();
	}
	
	public VerifyManager() { }
	
	public boolean checkUser(String user) {
		TeamspeakBot tsb = new TeamspeakBot();
		if(tsb.isUserOnline(user)) {
			if(tsb.isVerified(user)) return false;
			tsb.verifyUser(user);
			return true;
		} else return false;
	}
	
	public static void startTwitchBot() {
		TwitchBot.main(config);
	}
	
	public static void startTeamspeakBot() {
		TeamspeakBot.main(config);
	}
}