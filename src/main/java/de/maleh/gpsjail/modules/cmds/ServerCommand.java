package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class ServerCommand extends AbstractCommand {

    public ServerCommand() {
        super("server");
    }

    @Override
    public String getHelpMessage() {
        return "server";
    }

    public String getDescription() {
        return "See informations about server";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            MessagesUtils.form(p, "Server Informations:");
            MessagesUtils.form(p, "Players: " + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
            MessagesUtils.form(p, "OP-Players: " + Bukkit.getServer().getOperators().size());
            MessagesUtils.form(p, "IP: " + Bukkit.getServer().getIp());
            if(Bukkit.getServer().hasWhitelist()){
                MessagesUtils.form(p, "Whitelist: §aEnabled");
            } else {
                MessagesUtils.form(p, "Whitelist: §cDisabled");
            }
            MessagesUtils.form(p, "Name: " + Bukkit.getServer().getName());
            MessagesUtils.form(p, "Motd: " + Bukkit.getServer().getMotd());
            MessagesUtils.form(p, "Banned users: " + Bukkit.getServer().getBannedPlayers().size());
            if(Bukkit.getServer().isHardcore()){
                MessagesUtils.form(p, "Hardcore: §aYes");
            } else {
                MessagesUtils.form(p, "Hardcore: §cNo");
            }
            if(Bukkit.getServer().getOnlineMode()){
                MessagesUtils.form(p, "Cracked: §cNo");
            } else {
                MessagesUtils.form(p, "Cracked: §aYes");
            }
        });
    }

}