package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;

public class ReloadCommand extends AbstractCommand {
    public ReloadCommand() {
        super("reload", "rl");
    }

    public String getHelpMessage() {
        return "reload";
    }

    public String getDescription() {
        return "Reload the server";
    }

    public void setupCommand() {
        registerParameter(0, (p, args) -> {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "reload confirm");
            MessagesUtils.form(p, "Der Server wurde erfolgreich reloaded");
        });
    }
}