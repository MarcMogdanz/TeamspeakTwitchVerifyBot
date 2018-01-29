# TeamspeakTwitchVerifyBot

A tool to verify twitch users on your teamspeak.

## Usage

Start the jar via command line, adjust the config and start again.

## How to verify

Change your teamspeak name to match your twitch name (all lowercase) and type !verify in twitch chat.

## Configuration

* teamspeak.ip - The IP of your teamspeak server
* teamspeak.queryport - The query port
* teamspeak.queryuser - The query username
* teamspeak.querypass - The query password
* teamspeak.querynick - The desired nickname of the bot
* teamspeak.servergroup - The server group id of the verified users (TeamSpeak -> Permissions -> Server Groups, there you can see all group names with their ids)
* teamspeak.serverid - The virtual server id of your teamspeak (default should be 1)
* twitch.user - The twitch username of your bot
* twitch.oauth - The oauth token (you can get one [here](http://www.twitchapps.com/tmi/) for example)
* twitch.channel - The channel to verify in

## Download

See the releases over [here](https://github.com/MineKayama/TeamspeakTwitchVerifyBot/releases).

## Credits

* [TeamSpeak 3 Java API](https://github.com/TheHolyWaffle/TeamSpeak-3-Java-API)
* [PircBot](http://www.jibble.org/pircbot.php)
