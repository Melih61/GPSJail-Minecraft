package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;

public class FlyCommand extends AbstractCommand{

    public FlyCommand() {
        super("fly");
    }

    @Override
    public String getHelpMessage() {
        return "fly (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            if(p.getAllowFlight() == false){
                p.setAllowFlight(true);
                p.setFlying(true);
                MessagesUtils.form(p, "Du kannst nun fliegen");
            } else {
                p.setAllowFlight(false);
                p.setFlying(false);
                MessagesUtils.form(p, "Du kannst nicht mehr fliegen");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            if(target==null){
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                if (target.getAllowFlight() == false) {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    MessagesUtils.form(p, "Der Spieler " +target.getName()+ " kann nun fliegen");
                } else {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    MessagesUtils.form(p, "Der Spieler " + target.getName()+ " kann nicht mehr fliegen");
                }
            }
        });
    }

}
