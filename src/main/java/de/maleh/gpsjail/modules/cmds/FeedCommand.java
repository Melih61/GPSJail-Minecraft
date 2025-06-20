package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FeedCommand extends AbstractCommand {

    public FeedCommand() {
        super("feed");
    }

    @Override
    public String getHelpMessage() {
        return "feed (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            p.setFoodLevel(20);
            MessagesUtils.form(p, "Du wurdest gefüttert");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                target.setFoodLevel(20);
                MessagesUtils.form(p, "Du hast " + target.getName() + " gefüttert");
            }
        });
    }

}