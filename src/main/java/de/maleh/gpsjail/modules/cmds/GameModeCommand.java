package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
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
        return "gamemode (Gamemode) (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            if(args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0")){
                p.setGameMode(GameMode.SURVIVAL);
                MessagesUtils.form(p, "Du bist nun im Gamemode Survival");
            } else if(args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1")){
                p.setGameMode(GameMode.CREATIVE);
                MessagesUtils.form(p, "Du bist nun im Gamemode Creative");
            } else if(args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2")){
                p.setGameMode(GameMode.ADVENTURE);
                MessagesUtils.form(p, "Du bist nun im Gamemode Adventure");
            } else if(args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("3")){
                p.setGameMode(GameMode.SPECTATOR);
                MessagesUtils.form(p, "Du bist nun im Gamemode Spectator");
            }
        });
        super.registerParameter(2, (p, args)->{
            Player target = Bukkit.getPlayer(args[2]);
            if(target==null) {
                MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
            } else {
                if(args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0")){
                    target.setGameMode(GameMode.SURVIVAL);
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nun im Gamemode Survival");
                } else if(args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1")){
                    target.setGameMode(GameMode.CREATIVE);
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nun im Gamemode Creative");
                } else if(args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2")){
                    target.setGameMode(GameMode.ADVENTURE);
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nun im Gamemode Adventure");
                } else if(args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("3")){
                    target.setGameMode(GameMode.SPECTATOR);
                    MessagesUtils.form(p, "Du Spieler " + target.getName() + " ist nun im Gamemode Spectator");
                }
            }
        });
    }
}
