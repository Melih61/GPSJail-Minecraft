package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FlySpeedCommand extends AbstractCommand {

    public FlySpeedCommand() {
        super("flyspeed");
    }

    @Override
    public String getHelpMessage() {
        return "flyspeed <Number> <Player>";
    }

    public String getDescription() {
        return "Change flyspeed";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            try {
                int speed = Integer.parseInt(args[1]);
                if (speed < 0 || speed > 100) {
                    MessagesUtils.form(p, "§cEnter a number between 0-100");
                } else {
                    float speedValue = speed / 100.0f;
                    p.setFlySpeed(speedValue);
                    MessagesUtils.form(p, "Your flyspeed was changed to §6" + speed);
                }
            } catch (NumberFormatException nfe){
                if(args[1].equalsIgnoreCase("default")){
                    p.setFlySpeed(0.1F);
                    MessagesUtils.form(p, "Your flyspeed was changed to §6DEFAULT");
                } else {
                    MessagesUtils.form(p, "§cEnter a number between 0-100");
                }
            }
        });
        super.registerParameter(2, (p,args)->{
            Player target = Utils.checkOffline(p, args[2]);
            if (target == null) {
                return;
            } else {
                try {
                    int speed = Integer.parseInt(args[1]);
                    if (speed < 0 || speed > 100) {
                        MessagesUtils.form(p, "§cEnter a number between 0-100");
                    } else {
                        float speedValue = speed / 100.0f;
                        target.setFlySpeed(speedValue);
                        MessagesUtils.form(p, "The flyspeed of §6" + target.getName() + "§7§7 was changed to §6" + speed);
                    }
                } catch (NumberFormatException nfe){
                    if(args[1].equalsIgnoreCase("default")){
                        target.setFlySpeed(0.1F);
                        MessagesUtils.form(p, "The flyspeed of §6" + target.getName() + "§7§7 was changed to §6DEFAULT");
                    } else {
                        MessagesUtils.form(p, "§cEnter a number between 0-100");
                    }
                }
            }
        });
    }

}
