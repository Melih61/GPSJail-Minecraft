package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishCommand extends AbstractCommand {
    private Set<UUID> vanishedPlayers;


    public VanishCommand() {
        super("vanish");
        vanishedPlayers = new HashSet<>();
    }

    @Override
    public String getHelpMessage() {
        return "vanish (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            boolean isVanished = toogleVanish(p);
            if(isVanished){
                MessagesUtils.form(p, "Du bist nun im Vanish");
            } else {
                MessagesUtils.form(p, "Du bist nicht mehr im Vanish");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                boolean isVanished = toogleVanish(target);
                if(isVanished){
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nun im Vanish");
                } else {
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nicht mehr im Vanish");
                }
            }
        });
    }

    private boolean toogleVanish(Player p){
        UUID playerUUID = p.getUniqueId();
        boolean isVanished = vanishedPlayers.contains(playerUUID);

        if(isVanished){
            for(Player onlinePlayer : p.getServer().getOnlinePlayers()){
                onlinePlayer.showPlayer(p);
            }
            vanishedPlayers.remove(playerUUID);
        } else {
            for(Player onlinePlayer : p.getServer().getOnlinePlayers()){
                onlinePlayer.hidePlayer(p);
            }
            vanishedPlayers.add(playerUUID);
        }
        return !isVanished;
    }

}