package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class TitleCommand extends AbstractCommand {

    public TitleCommand() {
        super("title");
    }

    @Override
    public String getHelpMessage() {
        return "title <Player> <Text>";
    }

    public String getDescription() {
        return "Show a text in the middle of the screen";
    }

    @Override
    public void setupCommand() {
        Executor exe = (p, args) -> {
            if(args[1].equals("@a") || args[1].equals("*")){

            }
            Player target = Utils.checkOffline(p, args[1]);
            if (target != null || target.getName().equals("@a") || target.getName().equals("*")) {
                StringBuilder builder = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    if (i == args.length - 1) {
                        builder.append(args[i]);
                    } else {
                        builder.append(String.valueOf(args[i]) + " ");
                    }
                }
                if (target.getName().contains("@a") || target.getName().contains("*")) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(builder.toString(), "");
                        MessagesUtils.form(p, "You showed §6" + builder.toString() + "§7 for everyone");
                    }
                }
                target.sendTitle(builder.toString(), "");
                MessagesUtils.form(p, "You showed §6" + builder.toString() + "§7 to §6" + target.getName());
            } else if (target == null) {
                return;
            }
        };
        for (int i = 2; i < 15; i++)
            registerParameter(i, exe);
    }

}