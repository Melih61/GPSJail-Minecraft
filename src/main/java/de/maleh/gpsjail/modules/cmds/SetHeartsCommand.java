package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetHeartsCommand extends AbstractCommand {

    public SetHeartsCommand() {
        super("sethearts");
    }

    @Override
    public String getHelpMessage() {
        return "sethearts <Amount> <Player>";
    }

    public String getDescription() {
        return "Change the amount of hearts";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            double amount;
            try {
                amount = Double.parseDouble(args[1]);
            } catch (NumberFormatException e){
                MessagesUtils.form(p, "§cEnter a valid number");
                return;
            }
            if(amount < 0){
                MessagesUtils.form(p, "§cEnter a valid number");
                return;
            }
            double newHealth = amount*2;
            p.setMaxHealth(newHealth);
            MessagesUtils.form(p, "You now have §6" + amount + "§7 hearts");

        });
        super.registerParameter(2, (p,args)->{
            Player target = Utils.checkOffline(p, args[2]);
            if (target == null) {
                return;
            } else {
                double amount;
                try {
                    amount = Double.parseDouble(args[1]);
                } catch (NumberFormatException e){
                    MessagesUtils.form(p, "§cEnter a valid number");
                    return;
                }
                if(amount < 0){
                    MessagesUtils.form(p, "§cEnter a valid number");
                    return;
                }
                double newHealth = amount*2;
                target.setMaxHealth(newHealth);
                MessagesUtils.form(p, "The player §6" + target.getName() +  "§7 now has §6" + amount + "§7 hearts");
            }
        });
    }

}
