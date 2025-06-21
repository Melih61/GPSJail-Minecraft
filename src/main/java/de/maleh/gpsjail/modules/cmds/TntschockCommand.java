package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TntschockCommand extends AbstractCommand {

    public TntschockCommand() {
        super("faketnt");
    }

    @Override
    public String getHelpMessage() {
        return "faketnt <Player>";
    }

    public String getDescription() {
        return "Spawn fake TNT at players postion (Only visible for him)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            }
            try {
                for(double x = target.getLocation().getX() - 10; x <= target.getLocation().getX() + 10; x++){
                    for(double y = target.getLocation().getY() - 10; y <= target.getLocation().getY() + 10; y++){
                        for(double z = target.getLocation().getZ() - 10; z <= target.getLocation().getZ() + 10; z++){
                            Location l = new Location(target.getWorld(),x,y,z);
                            if(!l.getBlock().getType().equals(Material.AIR)){
                                target.sendBlockChange(l, Material.TNT, (byte)0);
                            }
                        }
                    }
                }
                MessagesUtils.form(p, "Most of the blocks at §6" + target.getName() + "'s§7§7 postition got changed to TNT");
            } catch (Exception e){

            }
        });
    }

}
