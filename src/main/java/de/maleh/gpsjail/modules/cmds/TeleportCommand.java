package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportCommand extends AbstractCommand {

    public TeleportCommand() {
        super("teleport", "tp");
    }

    @Override
    public String getHelpMessage() {
        return "tp (Spieler) (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                p.teleport(target.getLocation());
                MessagesUtils.form(p, "Du hast dich zu " + target.getName() + " teleportiert");
            }
        });
        super.registerParameter(2, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            Player target2 = Bukkit.getPlayer(args[2]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else if(target2==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[2] + " ist nicht online");
            } else {
                target.teleport(target2.getLocation());
                MessagesUtils.form(p, "Du hast " + target.getName() + " zu " + target2.getName() + " telportiert");
            }
        });
        super.registerParameter(3, (p,args)->{
            double x, y, z;
            try {
                x = Double.parseDouble(args[1]);
                y = Double.parseDouble(args[2]);
                z = Double.parseDouble(args[3]);
            } catch (NumberFormatException e) {
                MessagesUtils.form(p, "§cDie eingegebenen Koordinaten sind nicht gültig");
                return;
            }
            p.teleport(p.getWorld().getBlockAt((int) x, (int) y, (int) z).getLocation());
            int xInt = (int)x;
            int yInt = (int)y;
            int zInt = (int)z;
            MessagesUtils.form(p, "Du hast dich zu " + xInt + " " + yInt + " " + zInt + " teleportiert");
        });
        super.registerParameter(4, (p, args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                double x, y, z;
                try {
                    x = Double.parseDouble(args[2]);
                    y = Double.parseDouble(args[3]);
                    z = Double.parseDouble(args[4]);
                } catch (NumberFormatException e) {
                    MessagesUtils.form(p, "§cDie eingegebenen Koordinaten sind nicht gültig");
                    return;
                }
                target.teleport(p.getWorld().getBlockAt((int) x, (int) y, (int) z).getLocation());
                int xInt = (int)x;
                int yInt = (int)y;
                int zInt = (int)z;
                MessagesUtils.form(p, "Du hast " + target.getName() + " zu " + xInt + " " + yInt + " " + zInt + " teleportiert");
            }
        });
    }

}
