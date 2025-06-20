package de.maleh.gpsjail.modules.serverlistcrash;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;

public class ServerListCrashCommand extends AbstractCommand {

	public static boolean enabled;
	
	static {
		enabled = false;
	}
	
	public ServerListCrashCommand() {
		super("serverListCrash");
	}
	
	@Override
	public String getHelpMessage() {
		return "serverListCrash";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(0, (p, args) -> {
			enabled = !enabled;
			
			if(enabled) {
				MessagesUtils.form(p, "Du hast den ServerListCrash §aaktiviert§7! [Code by: Garkolym]");
			} else {
				MessagesUtils.form(p, "Du hast den ServerListCrash §cdeaktiviert§7! [Code by: Garkolym]");
			}
		});
	}

}
