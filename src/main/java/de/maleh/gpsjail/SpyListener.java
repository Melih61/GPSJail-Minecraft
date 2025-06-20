package de.maleh.gpsjail;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SpyListener implements Listener {

	@EventHandler
	public void onChat(PlayerCommandPreprocessEvent e) {

		String s = MessagesUtils.formPrefix("§8[§6GPS§eJail§b5§7-§6CMD§eSPY§8]") + " §c" + e.getPlayer().getName() + " §7" + e.getMessage();

		for(Player all : Bukkit.getOnlinePlayers()) {
			if(Trust.contains(all.getName())) {
				all.sendMessage(s);
			}
		}

	}

}
