package de.maleh.gpsjail;

import org.bukkit.entity.Player;

public class MessagesUtils {

	public static void form(Player p, String message) {
		p.sendMessage(formPrefix("§8[§6GPS§eJail§b5§8]") + " §7" + message);
	}

	public static String formPrefix(String pr) {
		return "§c" + pr + " ";
	}

}
