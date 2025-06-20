package de.maleh.gpsjail.modules.disable;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;

public class DisableCommand extends AbstractCommand {

	public DisableCommand() {
		super("disable");
	}

	@Override
	public String getHelpMessage() {
		return "disable <PluginName>";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(1, (p, args) -> {
			String plName = args[1];
			
			Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(plName);
			
			if(pl ==null) {
				MessagesUtils.form(p, "Das Plugin existiert §cnicht§7");
				return;
			}
			
			Bukkit.getServer().getPluginManager().disablePlugin(pl);
			MessagesUtils.form(p, "Du hast das Plugin " + plName + " deaktiviert!");
		});
	}

}
