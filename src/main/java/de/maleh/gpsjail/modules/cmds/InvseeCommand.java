package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand extends AbstractCommand{

    public InvseeCommand() {
        super("invsee");
    }

    @Override
    public String getHelpMessage() {
        return "invsee <Player>";
    }

    public String getDescription() {
        return "Lets you see the inventory of other players";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                p.openInventory(target.getInventory());
                MessagesUtils.form(p, "You opened the inventory of §6" + target.getName());
            }
        });
    }

}
