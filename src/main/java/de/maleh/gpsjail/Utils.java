package de.maleh.gpsjail;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
	
	public static Player checkOffline(Player p, String name) {
		Player target = Bukkit.getPlayer(name);
		
		if(target == null) {
			MessagesUtils.form(p, "§cThe player " + name + " was not found");
			return null;
		}
		return target;
	}
	
}
