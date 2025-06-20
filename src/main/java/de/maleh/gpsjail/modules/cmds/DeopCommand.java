package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;

public class DeopCommand extends AbstractCommand{

    public DeopCommand() {
        super("deop");
    }

    @Override
    public String getHelpMessage() {
        return "deop (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            if(!p.isOp()){
                MessagesUtils.form(p, "Du hast keine OP Rechte");
            } else {
                p.setOp(false);
                MessagesUtils.form(p, "Du hast keine OP Rechte mehr");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                if (!target.isOp()) {
                    MessagesUtils.form(p, "Der Spieler " +target.getName()+ " hat keine OP Rechte");
                } else {
                    target.setOp(false);
                    MessagesUtils.form(p, "Der Spieler " + target.getName()+ " hat keine OP Rechte mehr");
                }
            }
        });
    }

}
