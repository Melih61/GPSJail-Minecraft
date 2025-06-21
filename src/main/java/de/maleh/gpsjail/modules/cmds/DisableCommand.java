package de.maleh.gpsjail.modules.cmds;

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
		return "disable <Plugin>";
	}

	public String getDescription() {
		return "Disable plugins";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(1, (p, args) -> {
			String plName = args[1];
			
			Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(plName);
			
			if(pl ==null) {
				MessagesUtils.form(p, "§cThe plugin does not exist");
				return;
			}
			
			Bukkit.getServer().getPluginManager().disablePlugin(pl);
			MessagesUtils.form(p, "You disabled the plugin §6" + plName);
		});
	}

}
