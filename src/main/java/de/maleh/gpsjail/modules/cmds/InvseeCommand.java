package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand extends AbstractCommand{

    public InvseeCommand() {
        super("invsee");
    }

    @Override
    public String getHelpMessage() {
        return "invsee (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                Inventory i = target.getInventory();
                p.openInventory(i);
                MessagesUtils.form(p, "Du hast das Inventar von " + target.getName() + " geöffnet");
            }
        });
    }

}
