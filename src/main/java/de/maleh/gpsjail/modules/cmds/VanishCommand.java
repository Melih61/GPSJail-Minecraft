package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishCommand extends AbstractCommand implements Listener {
    private Set<Player> vanishedPlayers;


    public VanishCommand() {
        super("vanish");
        vanishedPlayers = new HashSet<>();
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "vanish <Player>";
    }

    public String getDescription() {
        return "Activate/Disable vanish";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            boolean isVanished = toogleVanish(p);
            if(isVanished){
                MessagesUtils.form(p, "You activated vanish");
            } else {
                MessagesUtils.form(p, "You disabled vanish");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                boolean isVanished = toogleVanish(target);
                if(isVanished){
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 is now in vanish");
                } else {
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 is not in vanish anymore");
                }
            }
        });
    }

    private boolean toogleVanish(Player p){
        boolean isVanished = vanishedPlayers.contains(p);

        if(isVanished){
            for(Player onlinePlayer : p.getServer().getOnlinePlayers()){
                onlinePlayer.showPlayer(p);
            }
            vanishedPlayers.remove(p);
        } else {
            for(Player onlinePlayer : p.getServer().getOnlinePlayers()){
                onlinePlayer.hidePlayer(p);
            }
            vanishedPlayers.add(p);
        }
        return !isVanished;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(!vanishedPlayers.isEmpty()){
            for(Player p : vanishedPlayers){
                e.getPlayer().hidePlayer(p);
            }
        }
    }

}