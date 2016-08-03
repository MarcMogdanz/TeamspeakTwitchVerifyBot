package de.marcmogdanz.ttvb;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

public class TwitchBot extends PircBot {
	private static VerifyManager vm;
	
	public static void main(Config config) {
		TwitchBot bot = new TwitchBot();
		bot.setVerbose(true);
		bot.setName("nattfary");
		bot.setLogin("nattfary");
		
		vm = new VerifyManager();
		
		try {
			bot.connect("irc.chat.twitch.tv", 6667, "oauth:dlr7rddyxvgnb4hxq0osrdad1sl7jt");
		} catch(NickAlreadyInUseException e) {
			System.err.println("Nickname already in use");
		} catch(IrcException e) {
			System.err.println("Server did not accept the connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("A IO Exception occured.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void onConnect() {
		System.out.println("Connected to twitch.");
		joinChannel("#nattfary");
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if(message.equalsIgnoreCase("!verify")) {
			if(vm.checkUser(sender)) {
				sendMessage(channel, "@" + sender + ": You were verified.");
			} else {
				sendMessage(channel, "@" + sender + ": You're not online on the teamspeak or already verified!");
			}
		}
	}
}
