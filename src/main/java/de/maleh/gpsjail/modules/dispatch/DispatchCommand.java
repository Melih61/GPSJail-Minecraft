package de.maleh.gpsjail.modules.dispatch;

import org.bukkit.entity.Player;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;

public class DispatchCommand extends AbstractCommand {

	public DispatchCommand() {
		super("sudo");
	}

	@Override
	public String getHelpMessage() {
		return "sudo <Spieler> <Command>";
	}

	@Override
	public void setupCommand() {
		Executor exe = (p, args) -> {
			Player target = Utils.checkOffline(p, args[1]);
			
			if(target == null) {
				return;
			}
			
			StringBuilder builder = new StringBuilder();
			
			for (int i = 2; i < args.length; i++) {
				if (i == args.length-1) {
					builder.append(args[i]);
				} else {
					builder.append(args[i] + " ");
				}
			}
			
			target.chat(builder.toString());
			
			MessagesUtils.form(p, target.getName() + " hat §c" + builder.toString() + " §7ausgeführt");
		};

		for (int i = 2; i < 15; i++) {
			super.registerParameter(i, exe);
		}

	}

}
