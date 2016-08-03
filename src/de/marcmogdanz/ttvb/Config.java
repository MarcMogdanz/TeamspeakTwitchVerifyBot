package de.marcmogdanz.ttvb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	private File configFile;
	
	private String teamspeakIP;
	private String teamspeakPort;
	private String teamspeakUser;
	private String teamspeakPass;
	private String teamspeakNick;
	private String teamspeakGroupID;
	private String teamspeakServerID;
	private String twitchUser;
	private String twitchToken;
	private String twitchChannel;
	
	public Config() {
		configFile = new File("config.properties");
	}
	
	public void loadConfig() {
		if(!configFile.exists()) {
			createConfig();
			System.out.println("You have to prepare the config.");
			System.exit(0);
		}
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(configFile);
			prop.load(input);
			this.teamspeakIP = prop.getProperty("teamspeak.ip");
			this.teamspeakPort = prop.getProperty("teamspeak.queryport");
			this.teamspeakUser = prop.getProperty("teamspeak.queryuser");
			this.teamspeakPass = prop.getProperty("teamspeak.querypass");
			this.teamspeakNick = prop.getProperty("teamspeak.querynick");
			this.teamspeakGroupID = prop.getProperty("teamspeak.servergroup");
			this.teamspeakServerID = prop.getProperty("teamspeak.serverid");
			this.twitchUser = prop.getProperty("twitch.user");
			this.twitchToken = prop.getProperty("twitch.oauth");
			this.twitchChannel = prop.getProperty("twitch.channel");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void createConfig() {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			prop.setProperty("teamspeak.ip", "");
			prop.setProperty("teamspeak.queryport", "10011");
			prop.setProperty("teamspeak.queryuser", "");
			prop.setProperty("teamspeak.querypass", "");
			prop.setProperty("teamspeak.querynick", "");
			prop.setProperty("teamspeak.servergroup", "");
			prop.setProperty("teamspeak.serverid", "1");
			prop.setProperty("twitch.user", "");
			prop.setProperty("twitch.oauth", "");
			prop.setProperty("twitch.channel", "");
			prop.store(output, null);
		} catch (IOException io) {
			if(output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getTeamspeakIP() { return this.teamspeakIP; }
	public int getTeamspeakPort() { return Integer.parseInt(this.teamspeakPort); }
	public String getTeamspeakUser() { return this.teamspeakUser; }
	public String getTeamspeakPass() { return this.teamspeakPass; }
	public String getTeamspeakNick() { return this.teamspeakNick; }
	public int getTeamspeakGroup() { return Integer.parseInt(this.teamspeakGroupID); }
	public int getTeamspeakServer() { return Integer.parseInt(this.teamspeakServerID); }
	public String getTwitchUser() { return this.twitchUser; }
	public String getTwitchToken() { return this.twitchToken; }
	public String getTwitchChannel() { return this.twitchChannel; }
}
