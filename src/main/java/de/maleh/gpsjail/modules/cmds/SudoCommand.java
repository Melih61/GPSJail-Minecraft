package de.maleh.gpsjail.modules.cmds;

import org.bukkit.entity.Player;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;

public class SudoCommand extends AbstractCommand {

	public SudoCommand() {
		super("sudo");
	}

	@Override
	public String getHelpMessage() {
		return "sudo <Player> <Command>";
	}

	public String getDescription() {
		return "Run messages for other players";
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
			
			MessagesUtils.form(p, target.getName() + " executed §6" + builder.toString());
		};

		for (int i = 2; i < 15; i++) {
			super.registerParameter(i, exe);
		}

	}

}
