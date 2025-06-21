package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GetLocationCommand extends AbstractCommand {

    public GetLocationCommand() {
        super("getlocation","getloc");
    }

    @Override
    public String getHelpMessage() {
        return "getlocation <Player>";
    }

    public String getDescription() {
        return "Shows the location of a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                double x = target.getLocation().getX();
                double y = target.getLocation().getY();
                double z = target.getLocation().getZ();
                int xInt = (int) x;
                int yInt = (int) y;
                int zInt = (int) z;
                MessagesUtils.form(p, "The coordinates from §6" + target.getName() + "§7§7 are " + xInt + " " + yInt + " " + zInt);
            }
        });
    }

}