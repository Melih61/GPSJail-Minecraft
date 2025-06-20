package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class UnbanCommand extends AbstractCommand {

    public UnbanCommand() {
        super("unban");
    }

    @Override
    public String getHelpMessage() {
        return "unban (Spieler)";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
            if(target.isBanned()) {
                Bukkit.getBanList(BanList.Type.NAME).pardon(target.getName());
                MessagesUtils.form(p, "Du hast den Spieler " + target.getName() + " entbannt");
            }
        });
    }

}
