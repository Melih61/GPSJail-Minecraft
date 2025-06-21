package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class DeopCommand extends AbstractCommand{

    public DeopCommand() {
        super("deop");
    }

    @Override
    public String getHelpMessage() {
        return "deop <Player>";
    }

    public String getDescription() {
        return "Removes op permission";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            if(!p.isOp()){
                MessagesUtils.form(p, "You are not a server operator");
            } else {
                p.setOp(false);
                MessagesUtils.form(p, "You are no longer server operator");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            OfflinePlayer targeto = Bukkit.getOfflinePlayer(args[1]);
            if(target==null){
                if (!targeto.isOp()) {
                    MessagesUtils.form(p, "The player §6" +targeto.getName()+ "§7 is not a sever operator");
                } else {
                    targeto.setOp(false);
                    MessagesUtils.form(p, "The player §6" + targeto.getName() + "§7 is no longer server operator");
                }
            } else {
                if (!target.isOp()) {
                    MessagesUtils.form(p, "The player §6" +target.getName()+ "§7 is not a sever operator");
                } else {
                    target.setOp(false);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 is no longer server operator");
                }
            }
        });
    }

}
