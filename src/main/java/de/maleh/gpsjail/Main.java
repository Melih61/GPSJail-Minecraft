package de.maleh.gpsjail;

import org.bukkit.plugin.java.JavaPlugin;

import de.maleh.gpsjail.modules.serverlistcrash.ServerListCrashListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerPunishListener(), this);

		this.getServer().getPluginManager().registerEvents(new ServerListCrashListener(), this);
		this.getServer().getPluginManager().registerEvents(new SpyListener(), this);
		
		this.getServer().getPluginManager().registerEvents(new AntiStopListener(), this);
		
	}

}
