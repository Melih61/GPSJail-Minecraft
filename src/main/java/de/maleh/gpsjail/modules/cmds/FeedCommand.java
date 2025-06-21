package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FeedCommand extends AbstractCommand {

    public FeedCommand() {
        super("feed");
    }

    @Override
    public String getHelpMessage() {
        return "feed <Player>";
    }

    public String getDescription() {
        return "Feed a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            p.setFoodLevel(20);
            MessagesUtils.form(p, "You have been fed");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                target.setFoodLevel(20);
                MessagesUtils.form(p, "You fed §6" + target.getName());
            }
        });
    }

}