package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;

public class FlyCommand extends AbstractCommand{

    public FlyCommand() {
        super("fly");
    }

    @Override
    public String getHelpMessage() {
        return "fly <Player>";
    }

    public String getDescription() {
        return "Activate or disable fly";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            if(p.getAllowFlight() == false){
                p.setAllowFlight(true);
                p.setFlying(true);
                MessagesUtils.form(p, "You can fly now");
            } else {
                p.setAllowFlight(false);
                p.setFlying(false);
                MessagesUtils.form(p, "You can't fly anymore");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                if (target.getAllowFlight() == false) {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 can fly now");
                } else {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7can't fly anymore");
                }
            }
        });
    }

}
