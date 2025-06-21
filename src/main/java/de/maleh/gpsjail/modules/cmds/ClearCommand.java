package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearCommand extends AbstractCommand {

    public ClearCommand() {
        super("clear");
    }

    public String getDescription() {
        return "Clears the inventory";
    }

    @Override
    public String getHelpMessage() {
        return "clear <Player>";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            p.getInventory().clear();
            MessagesUtils.form(p, "Your inventory got cleared");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                target.getInventory().clear();
                MessagesUtils.form(p, "Cleared the inventory from player §6" + target.getName());
            }
        });
    }

}
