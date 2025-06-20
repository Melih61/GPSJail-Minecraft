package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.BanList;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class BanCommand extends AbstractCommand{

    public BanCommand() {
        super("ban");
    }

    @Override
    public String getHelpMessage() {
        return "ban (Spieler) (Grund)";
    }

    @Override
    public void setupCommand() {
        Executor exe = (p, args) -> {
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[1]);
                OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
                if (target == null) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), "Du wurdest von diesem Server gebannt", null, "console");
                    MessagesUtils.form(p, "Du hast den Spieler " + t.getName() + " gebannt");
                } else {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Du wurdest von diesem Server gebannt", null, "console");
                    target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                    MessagesUtils.form(p, "Du hast den Spieler " + target.getName() + " gebannt");
                }
            } else {
                StringBuilder builder = new StringBuilder();

                for (int i = 2; i < args.length; i++) {
                    if (i == args.length - 1) {
                        builder.append(args[i]);
                    } else {
                        builder.append(args[i] + " ");
                    }
                }
                Player target = Bukkit.getPlayer(args[1]);
                OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
                if (builder.toString() == "") {
                    if (target == null) {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), "Du wurdest von diesem Server gebannt", null, "console");
                        MessagesUtils.form(p, "Du hast den Spieler " + t.getName() + " gebannt");
                    } else {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Du wurdest von diesem Server gebannt", null, "console");
                        target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                        MessagesUtils.form(p, "Du hast den Spieler " + target.getName() + " gebannt");
                    }
                } else {
                    if (target == null) {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), builder.toString(), null, "console");
                        MessagesUtils.form(p, "Du hast den Spieler " + t.getName() + " gebannt");
                    } else {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), builder.toString(), null, "console");
                        target.kickPlayer(builder.toString());
                        MessagesUtils.form(p, "Du hast den Spieler " + target.getName() + " gebannt");
                    }
                }
            }
        };

        for (int i = 2; i < 15; i++) {
            super.registerParameter(i, exe);
        }
    }

}
