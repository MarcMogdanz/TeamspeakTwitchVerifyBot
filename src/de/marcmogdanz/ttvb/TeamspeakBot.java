package de.marcmogdanz.ttvb;

import java.util.Collections;
import java.util.logging.Level;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.ClientProperty;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

public class TeamspeakBot {
	private static TS3Api api;
	private static Config config;
	
	public static void main(Config config) {
		TeamspeakBot.config = config;
		final TS3Config tsconfig = new TS3Config();
		tsconfig.setHost(config.getTeamspeakIP());
		tsconfig.setQueryPort(config.getTeamspeakPort());
		tsconfig.setDebugLevel(Level.ALL);
		final TS3Query query = new TS3Query(tsconfig);
		query.connect();
		api = query.getApi();
		api.login(config.getTeamspeakUser(), config.getTeamspeakPass());
		api.selectVirtualServerById(config.getTeamspeakServer());
		api.setNickname(config.getTeamspeakNick());
	}
	
	public boolean isUserOnline(String user) {
		Client client = api.getClientByNameExact(user, false);
		if(client != null) return true; else return false;
	}
	
	public boolean isVerified(String user) {
		Client client = api.getClientByNameExact(user, false);
		int[] groups = client.getServerGroups();
		for(int x = 0; x < groups.length; x++) {
			if(groups[x] == config.getTeamspeakGroup()) return true;
		}
		return false;
	}
	
	public void verifyUser(String user) {
		Client client = api.getClientByNameExact(user, false);
		api.addClientToServerGroup(config.getTeamspeakGroup(), client.getDatabaseId());
		api.editClient(client.getId(), Collections.singletonMap(ClientProperty.CLIENT_DESCRIPTION, "Twitch: " + user));
	}
}
