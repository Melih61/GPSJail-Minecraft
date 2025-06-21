package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpawnschwanzCommand extends AbstractCommand {

    public SpawnschwanzCommand() {
        super("spawnpenis");
    }

    @Override
    public String getHelpMessage() {
        return "spawnpenis <Player>";
    }

    public String getDescription() {
        return "Spawns a penis near a player (Only visible for him)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            }
            try {
                for(double x = target.getLocation().getX() - 4; x <= target.getLocation().getX() + 4; x++){
                    for(double y = target.getLocation().getY() + 4; y <= target.getLocation().getY() + 6; y++){
                        for(double z = target.getLocation().getZ(); z <= target.getLocation().getZ() + 2; z++){
                            target.sendBlockChange(new Location(target.getWorld(),x,y,z), Material.PINK_WOOL, (byte)6);
                        }
                    }
                }
                for(double x = target.getLocation().getX() - 1; x <= target.getLocation().getX() + 1; x++){
                    for(double y = target.getLocation().getY() + 6; y <= target.getLocation().getY() + 12; y++){
                        for(double z = target.getLocation().getZ(); z <= target.getLocation().getZ() + 2; z++){
                            target.sendBlockChange(new Location(target.getWorld(),x,y,z), Material.PINK_WOOL, (byte)6);
                        }
                    }
                }
                for(double x = target.getLocation().getX() - 1; x <= target.getLocation().getX() + 1; x++){
                    for(double y = target.getLocation().getY() + 12; y <= target.getLocation().getY() + 14; y++){
                        for(double z = target.getLocation().getZ(); z <= target.getLocation().getZ() + 2; z++){
                            target.sendBlockChange(new Location(target.getWorld(),x,y,z), Material.WHITE_WOOL, (byte)2);
                        }
                    }
                }
                MessagesUtils.form(p, "Near the location of §6" + target.getName() + "§7§7 spawned a penis");
            } catch (Exception e){

            }
        });
    }

}
