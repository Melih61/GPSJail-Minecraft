package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class KackregenCommand extends AbstractCommand implements Listener {

    public KackregenCommand() {
        super("pooprain");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    private ArrayList<Player> vics = new ArrayList<Player>();
    private int ticks = 0;

    @Override
    public String getHelpMessage() {
        return "pooprain <Player>";
    }

    public String getDescription() {
        return "Spawns poop above player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player victim = Utils.checkOffline(p, args[1]);
            if(victim == null){
                return;
            } else {
                if (!this.vics.contains(victim)) {
                    this.vics.add(victim);
                    MessagesUtils.form(p, "It rains poop over §6" + victim.getName());
                } else {
                    this.vics.remove(victim);
                    MessagesUtils.form(p, "It stopped raining poop over §6" + victim.getName());
                }
            }
        });
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        this.ticks++;
        if (this.ticks > 2) {
            this.ticks = 0;
            for (Player v : this.vics) {
                v.getWorld().spawnFallingBlock(new Location(v.getWorld(), v.getLocation().getX(), v.getLocation().getY() + 5, v.getLocation().getZ()), Material.BROWN_WOOL, (byte) 12);
            }
        }
    }

}
