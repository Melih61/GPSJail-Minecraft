package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class BlitzCommand extends AbstractCommand {

    public BlitzCommand() {
        super("thunder");
    }

    @Override
    public String getHelpMessage() {
        return "thunder <Player>";
    }

    public String getDescription() {
        return "Strikes a thunder at players position";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                target.getWorld().strikeLightning(target.getLocation());
                MessagesUtils.form(p, "A thunder hit §6" + target.getName());
            }
        });
    }

}
