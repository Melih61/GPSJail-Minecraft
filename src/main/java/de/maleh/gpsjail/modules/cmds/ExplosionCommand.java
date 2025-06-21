package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ExplosionCommand extends AbstractCommand {
    public ExplosionCommand() {
        super("explosion");
    }

    public String getHelpMessage() {
        return "explosion <Player>";
    }

    public String getDescription() {
        return "Creates a big explosion at players position";
    }

    public void setupCommand() {
        registerParameter(1, (p, args) -> {
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                try {
                    World t = target.getWorld();
                    t.createExplosion(target.getLocation(), Integer.valueOf(50).intValue(), true);
                    Thread.sleep(1000L);
                    MessagesUtils.form(p, "A explosion was created at §6" + target.getName() + "'s§7 position");
                } catch (Exception ex) {
                }
            }
        });
    }
}
