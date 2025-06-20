package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealCommand extends AbstractCommand {

    public HealCommand() {
        super("heal");
    }

    @Override
    public String getHelpMessage() {
        return "heal (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            double maxhealth = p.getMaxHealth();
            MessagesUtils.form(p, "Du wurdest geheilt");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                double maxhealth = target.getMaxHealth();
                target.setHealth(maxhealth);
                MessagesUtils.form(p, "Du hast " + target.getName() + " geheilt");
            }
        });
    }

}
