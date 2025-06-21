package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealCommand extends AbstractCommand {

    public HealCommand() {
        super("heal");
    }

    @Override
    public String getHelpMessage() {
        return "heal <Player>";
    }

    public String getDescription() {
        return "Heal a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            double maxhealth = p.getMaxHealth();
            p.setHealth(maxhealth);
            MessagesUtils.form(p, "You got healed");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                double maxhealth = target.getMaxHealth();
                target.setHealth(maxhealth);
                MessagesUtils.form(p, "You healed §6" + target.getName());
            }
        });
    }

}
