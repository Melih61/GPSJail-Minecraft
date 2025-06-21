package de.maleh.gpsjail.modules.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.Files;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;

public class CloneCommand extends AbstractCommand {

	public CloneCommand() {
		super("clone");
	}

	@Override
	public String getHelpMessage() {
		return "clone <Filename>";
	}

	public String getDescription() {
		return "Clone GPSJail in the plugins folder with a custom name";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(1, (p, args) -> {

			this.copyFile(args[1]);
			MessagesUtils.form(p, "You cloned GPSJail as §c" + args[1]);
		});
	}

	private void copyFile(String fileOut) {
		//File original = new File(
		//		"plugins" + File.separator + JavaPlugin.getPlugin(Main.class).getDescription().getName() + ".jar");
		File original = new File(
				"plugins" + File.separator + Main.pluginname.getName());
		File copy = new File("plugins" + File.separator + fileOut + ".jar");
		JavaPlugin pl = (JavaPlugin) Bukkit.getServer().getPluginManager().getPlugin("GPSJail");


		try {
			Files.copy(original, copy);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
