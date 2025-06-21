package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public class OplistCommand extends AbstractCommand {

    public OplistCommand() {
        super("oplist");
    }

    @Override
    public String getHelpMessage() {
        return "oplist";
    }

    public String getDescription() {
        return "See all players with op permission";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            Set<OfflinePlayer> operators = Bukkit.getOperators();
            MessagesUtils.form(p, "All players with op permission:");
            for(OfflinePlayer operator : operators){
                p.sendMessage("§7" + operator.getName());
            }
        });
    }

}