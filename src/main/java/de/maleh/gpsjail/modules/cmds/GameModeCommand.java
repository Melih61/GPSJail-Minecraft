package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GameModeCommand extends AbstractCommand {

    public GameModeCommand() {
        super("gamemode", "gm");
    }

    @Override
    public String getHelpMessage() {
        return "gamemode <0:1:2:3> <Player>";
    }

    public String getDescription() {
        return "Change gamemode";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            if(args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0")){
                p.setGameMode(GameMode.SURVIVAL);
                MessagesUtils.form(p, "You changed your GAMEMODE to SURVIVAL");
            } else if(args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1")){
                p.setGameMode(GameMode.CREATIVE);
                MessagesUtils.form(p, "You changed your GAMEMODE to CREATIVE");
            } else if(args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2")){
                p.setGameMode(GameMode.ADVENTURE);
                MessagesUtils.form(p, "You changed your GAMEMODE to ADVENTURE");
            } else if(args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("3")){
                p.setGameMode(GameMode.SPECTATOR);
                MessagesUtils.form(p, "You changed your GAMEMODE to SPECTATOR");
            }
        });
        super.registerParameter(2, (p, args)->{
            Player target = Utils.checkOffline(p, args[2]);
            if (target == null) {
                return;
            } else {
                if(args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0")){
                    target.setGameMode(GameMode.SURVIVAL);
                    MessagesUtils.form(p, "You changed the GAMEMODE of player §6" + target.getName() + "§7§7 to SURVIVAL");
                } else if(args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1")){
                    target.setGameMode(GameMode.CREATIVE);
                    MessagesUtils.form(p, "You changed the GAMEMODE of player §6" + target.getName() + "§7§7 to CREATIVE");
                } else if(args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2")){
                    target.setGameMode(GameMode.ADVENTURE);
                    MessagesUtils.form(p, "You changed the GAMEMODE of player §6" + target.getName() + "§7§7 to ADVENTURE");
                } else if(args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("3")){
                    target.setGameMode(GameMode.SPECTATOR);
                    MessagesUtils.form(p, "You changed the GAMEMODE of player §6" + target.getName() + "§7§7 to SPECTATOR");
                }
            }
        });
    }
}
