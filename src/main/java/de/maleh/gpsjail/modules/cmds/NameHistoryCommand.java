package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.NameHistory;
import java.util.List;
import org.bukkit.entity.Player;

public class NameHistoryCommand extends AbstractCommand {
    public NameHistoryCommand() {
        super(new String[] { "namehistory" });
    }

    public String getHelpMessage() {
        return "namehistory <Spieler>";
    }

    public String getDescription() {
        return "Zeigt die vorherigen Namen von Spielern";
    }

    public void setupCommand() {
        registerParameter(1, (p, args) -> {
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null)
                return;
            List<NameHistory> historys = NameHistory.getNameHistory(target.getUniqueId().toString().replace("-", ""));
            NameHistory.getNameHistory(target.getUniqueId().toString().replace("-", ""));
            if (historys == null) {
                MessagesUtils.form(p, "Es konnte keine UUID von diesem Spieler gefunden werden");
                MessagesUtils.form(p, "Mojang Server down?");
                return;
            }
            MessagesUtils.form(p, "Namen von §c"  + target.getName());
            for (NameHistory history : historys)
                MessagesUtils.form(p, history.toString());
        });
    }
}
