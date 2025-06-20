package de.maleh.gpsjail.modules.console;

import org.bukkit.Bukkit;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;

public class ConsoleCommand extends AbstractCommand {

	public ConsoleCommand() {
		super("console");
	}

	@Override
	public String getHelpMessage() {
		return "console <Command>";
	}

	@Override
	public void setupCommand() {
		Executor exe = (p, args) -> {
			StringBuilder builder = new StringBuilder();

			for (int i = 1; i < args.length; i++) {
				if (i == args.length-1) {
					builder.append(args[i]);
				} else {
					builder.append(args[i] + " ");
				}
			}

			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), builder.toString());
			MessagesUtils.form(p, "Du hast §c" + builder.toString() + " §7in der Console ausgeführt!");
		};

		for (int i = 1; i < 15; i++) {
			super.registerParameter(i, exe);
		}
	}

}
