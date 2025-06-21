package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class BlindnessCommand extends AbstractCommand {

    ArrayList<Player> blind = new ArrayList<>();
    public BlindnessCommand() {
        super("blindness");
    }

    @Override
    public String getHelpMessage() {
        return "blindness <Player>";
    }

    public String getDescription() {
        return "Makes a player blind";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                if(!blind.contains(target)){
                    blind.add(target);
                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2147483647, 5));
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 is blind");
                } else if(blind.contains(target)){
                    blind.remove(target);
                    target.removePotionEffect(PotionEffectType.BLINDNESS);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7 is not blind anymore");
                }
            }
        });

    }

}