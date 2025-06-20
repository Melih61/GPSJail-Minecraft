package de.maleh.gpsjail.commands;

import java.util.ArrayList;
import java.util.List;

import de.maleh.gpsjail.modules.chatclear.ChatClearCommand;
import de.maleh.gpsjail.modules.clone.CloneCommand;
import de.maleh.gpsjail.modules.cmds.*;
import de.maleh.gpsjail.modules.console.ConsoleCommand;
import de.maleh.gpsjail.modules.disable.DisableCommand;
import de.maleh.gpsjail.modules.dispatch.DispatchCommand;
import de.maleh.gpsjail.modules.plugins.PluginsCommand;
import de.maleh.gpsjail.modules.serverlistcrash.ServerListCrashCommand;

public abstract class AbstractCommand {

	private static List<AbstractCommand> abstractCommands;

	static {
		abstractCommands = new ArrayList<>();

		new ServerListCrashCommand();
		new ConsoleCommand();
		new DispatchCommand();
		new ChatClearCommand();
		new CloneCommand();
		new DisableCommand();
		new PluginsCommand();
		new HealCommand();
		new FeedCommand();
		new BanCommand();
		new DeopCommand();
		new OpCommand();
		new FlyCommand();
		new InvseeCommand();
		new KickCommand();
		new GameModeCommand();
		new MsgTrustedCommand();
		new TeleportCommand();
		new ClearCommand();
		new VanishCommand();
		new UnbanCommand();
	}

	public static List<AbstractCommand> getAbstractCommands() {
		return abstractCommands;
	}

	public static Parameter getParameter(AbstractCommand command, int i) {
		for (Parameter param : command.getParameters()) {
			if (param.getPlace() == i) {
				return param;
			}
		}
		return null;
	}

	public static AbstractCommand getAbstractCommand(String command) {
		for (AbstractCommand abstractCommand : abstractCommands) {
			for (String cmd : abstractCommand.getCommands()) {
				if (cmd.toLowerCase().equals(command.toLowerCase())) {
					return abstractCommand;
				}
			}
		}
		return null;
	}

	private String[] commands;
	private List<Parameter> parameters;

	public AbstractCommand(String... commands) {
		this.commands = commands;
		this.parameters = new ArrayList<>();
		this.setupCommand();
		abstractCommands.add(this);
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void unregister() {
		abstractCommands.remove(this);
	}

	public String[] getCommands() {
		return this.commands;
	}

	public void registerParameter(String s, int place, Executor execute) {
		this.parameters.add(new Parameter(s, place, execute));
	}

	public void registerParameter(int place, Executor execute) {
		registerParameter(null, place, execute);
	}

	public abstract String getHelpMessage();

	public abstract void setupCommand();

}
