package de.maleh.gpsjail.modules.plugins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;

public class PluginsCommand extends AbstractCommand {

	public PluginsCommand() {
		super("plugins", "pl");
	}

	@Override
	public String getHelpMessage() {
		return "plugins";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(0, (p, args) -> {
			
			MessagesUtils.form(p, "Plugins:");
			
			List<String> list = new ArrayList<>();
			
			for (Plugin pl : Bukkit.getServer().getPluginManager().getPlugins()) {
				if(pl.isEnabled()) {
					list.add("§a-"+pl.getName());
				} else {
					list.add("§c-"+pl.getName());
				}
				
			}
			
			Collections.sort(list);
			
			for(String pl : list) {
				p.sendMessage(pl);
			}
		});
	}

}
