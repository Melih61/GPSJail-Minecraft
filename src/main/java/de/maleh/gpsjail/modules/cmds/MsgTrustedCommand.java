package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Trust;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MsgTrustedCommand extends AbstractCommand {

    public MsgTrustedCommand() {
        super("msgtrusted");
    }

    @Override
    public String getHelpMessage() {
        return "msgtrusted (Nachricht)";
    }

    @Override
    public void setupCommand() {
        Executor exe = (p, args) -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 2; i < args.length; i++) {
                if (i == args.length - 1) {
                    builder.append(args[i]);
                } else {
                    builder.append(args[i] + " ");
                }
            }

            for(Player all : Bukkit.getOnlinePlayers()) {
                if(Trust.contains(all.getName())) {
                    all.sendMessage("§6" + p.getName() + " §8» §7" + builder.toString());
                }
            }
        };
        for (int i = 2; i < 15; i++) {
            super.registerParameter(i, exe);
        }
    }

}