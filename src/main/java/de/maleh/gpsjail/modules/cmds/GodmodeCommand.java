package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class GodmodeCommand extends AbstractCommand {

    public GodmodeCommand() {
        super("godmode", "god");
    }

    @Override
    public String getHelpMessage() {
        return "godmode <Player>";
    }

    public String getDescription() {
        return "Turn on/off godmode";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            boolean godModeEnabled = toggleGodMode(p);
            if(godModeEnabled){
                MessagesUtils.form(p, "You activated godmode");
            } else {
                MessagesUtils.form(p, "You disabled godmode");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                boolean godModeEnabled = toggleGodMode(target);
                if (godModeEnabled) {
                    MessagesUtils.form(p, "You activated godmode for  §6" + target.getName());
                } else {
                    MessagesUtils.form(p, "You disabled godmode for  §6" + target.getName());
                }
            }
        });

    }

    private boolean toggleGodMode(Player p){
        if(!p.isInvulnerable()) {
            p.setInvulnerable(true);
            return true;
        } else {
            p.setInvulnerable(false);
            return false;
        }
    }

}
