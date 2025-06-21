package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class FreezeCommand extends AbstractCommand implements Listener {

    ArrayList<Player> freeze = new ArrayList<>();
    public FreezeCommand() {
        super("freeze");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "freeze <Player>";
    }

    public String getDescription() {
        return "Freeze a player";
    }

    @Override
    public void setupCommand() {
        registerParameter(1, (p, args) -> {
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                if (!freeze.contains(target)) {
                    freeze.add(target);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 is now freezed");
                } else if (freeze.contains(p)) {
                    freeze.remove(target);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 can move again");
                }
            }
        });
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(freeze.contains(e.getPlayer())){
            if(e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ()){
                e.setCancelled(true);
            }
        } else {
            e.setCancelled(false);
        }
    }

}
