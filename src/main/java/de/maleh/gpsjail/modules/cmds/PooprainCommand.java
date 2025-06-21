package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class PooprainCommand extends AbstractCommand implements Listener {
    private ArrayList<Player> vics;

    private int ticks;

    public PooprainCommand() {
        super("pooprain");
        this.vics = new ArrayList<>();
        this.ticks = 0;
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    public String getHelpMessage() {
        return "pooprain <Spieler>";
    }

    public String getDescription() {
        return "Raining shit over player";
    }

    public void setupCommand() {
        registerParameter(1, (p, args) -> {
            Player victim = Utils.checkOffline(p, args[1]);
            if (victim == null)
                return;
            if (!this.vics.contains(victim)) {
                this.vics.add(victim);
                MessagesUtils.form(p, "The player §6" + victim.getName() + "§7 now gets shit on");
            } else {
                this.vics.remove(victim);
                MessagesUtils.form(p, "The player §6" + victim.getName() + "§7 doesn't get shitted on anymore");
            }
        });
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        this.ticks++;
        if (this.ticks > 2) {
            this.ticks = 0;
            for (Player v : this.vics)
                v.getWorld().spawnFallingBlock(new Location(v.getWorld(), v.getLocation().getX(), v.getLocation().getY() + 5.0D, v.getLocation().getZ()), Material.BROWN_WOOL, (byte)12);
        }
    }
}
