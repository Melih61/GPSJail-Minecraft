package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportCommand extends AbstractCommand {

    public TeleportCommand() {
        super("teleport", "tp");
    }

    @Override
    public String getHelpMessage() {
        return "tp <Player>";
    }

    public String getDescription() {
        return "Teleport players";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                p.teleport(target.getLocation());
                MessagesUtils.form(p, "You teleported yourself to §6" + target.getName());
            }
        });
        super.registerParameter(2, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            Player target2 = Utils.checkOffline(p, args[2]);
            if (target == null) {
                return;
            } else if (target2 == null) {
                return;
            } else {
                target.teleport(target2.getLocation());
                MessagesUtils.form(p, "You teleported §6" + target.getName() + "§7§7 to §6" + target2.getName());
            }
        });
        super.registerParameter(3, (p,args)->{
            double x, y, z;
            try {
                x = Double.parseDouble(args[1]);
                y = Double.parseDouble(args[2]);
                z = Double.parseDouble(args[3]);
            } catch (NumberFormatException e) {
                MessagesUtils.form(p, "§cEnter valid coordinates");
                return;
            }
            p.teleport(p.getWorld().getBlockAt((int) x, (int) y, (int) z).getLocation());
            int xInt = (int)x;
            int yInt = (int)y;
            int zInt = (int)z;
            MessagesUtils.form(p, "You teleported yourself to " + xInt + " " + yInt + " " + zInt);
        });
        super.registerParameter(4, (p, args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                double x, y, z;
                try {
                    x = Double.parseDouble(args[2]);
                    y = Double.parseDouble(args[3]);
                    z = Double.parseDouble(args[4]);
                } catch (NumberFormatException e) {
                    MessagesUtils.form(p, "§cEnter valid coordinates");
                    return;
                }
                target.teleport(p.getWorld().getBlockAt((int) x, (int) y, (int) z).getLocation());
                int xInt = (int)x;
                int yInt = (int)y;
                int zInt = (int)z;
                MessagesUtils.form(p, "You teleported §6" + target.getName() + "§7§7 to " + xInt + " " + yInt + " " + zInt);
            }
        });
    }

}
