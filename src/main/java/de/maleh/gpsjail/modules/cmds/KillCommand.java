package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand extends AbstractCommand {

    public KillCommand() {
        super("kill");
    }

    @Override
    public String getHelpMessage() {
        return "kill <Player>";
    }

    public String getDescription() {
        return "Kill a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            p.setHealth(0);
            MessagesUtils.form(p, "You killed yourself");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                target.setHealth(0);
                MessagesUtils.form(p, "You killed §6" + target.getName());
            }
        });
    }

}