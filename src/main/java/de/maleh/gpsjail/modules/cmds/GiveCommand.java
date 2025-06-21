package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand extends AbstractCommand {
    public GiveCommand() {
        super("give");
    }

    public String getHelpMessage() {
        return "give <Player> <Item>";
    }

    public String getDescription() {
        return "Give players items";
    }

    public void setupCommand() {
        registerParameter(2, (p, args) -> {
            Player target = Utils.checkOffline(p, args[1]);
            if(target == null){
                return;
            }
            Material item = Material.matchMaterial(args[2]);
            if(!(item == null)){
                ItemStack itemStack = new ItemStack(item, 1);
                target.getInventory().addItem(itemStack);
                MessagesUtils.form(p, "Gave §61 " + item + "§7 to §6" + target.getName());
            } else {
                MessagesUtils.form(p, "§cThe item " + args[2] + " was not found");
            }
        });
        registerParameter(3, (p, args) -> {
            Player target = Utils.checkOffline(p, args[1]);
            int amount;
            if(target == null){
                return;
            }
            Material item = Material.matchMaterial(args[2]);
            if(!(item == null)){
                try {
                    amount = Integer.parseInt(args[3]);
                    if(amount > 0) {
                        ItemStack itemStack = new ItemStack(item, amount);
                        target.getInventory().addItem(itemStack);
                        MessagesUtils.form(p, "Gave §6" + amount + " " + item + "§7 to §6" + target.getName());
                    } else {
                        MessagesUtils.form(p, "§cEnter a valid amount");
                    }
                } catch (NumberFormatException e) {
                    MessagesUtils.form(p, "§cEnter a valid amount");
                }
            } else {
                MessagesUtils.form(p, "§cThe item " + args[2] + " was not found");
            }
        });
    }
}
