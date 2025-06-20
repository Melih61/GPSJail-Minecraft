package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearCommand extends AbstractCommand {

    public ClearCommand() {
        super("clear");
    }

    @Override
    public String getHelpMessage() {
        return "clear (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            p.getInventory().clear();
            MessagesUtils.form(p, "Dein Inventar wurde geleert");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                target.getInventory().clear();
                MessagesUtils.form(p, "Das Inventar von " + target.getName() + " wurde geleert");
            }
        });
    }

}
