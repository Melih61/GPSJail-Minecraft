package de.maleh.gpsjail.commands;

import java.util.ArrayList;
import java.util.List;

import de.maleh.gpsjail.modules.cmds.ChatClearCommand;
import de.maleh.gpsjail.modules.cmds.CloneCommand;
import de.maleh.gpsjail.modules.cmds.*;
import de.maleh.gpsjail.modules.cmds.ConsoleCommand;
import de.maleh.gpsjail.modules.cmds.DisableCommand;
import de.maleh.gpsjail.modules.cmds.SudoCommand;
import de.maleh.gpsjail.modules.cmds.PluginsCommand;

public abstract class AbstractCommand {

	private static List<AbstractCommand> abstractCommands;

	static {
		abstractCommands = new ArrayList<>();

		new HelpCommand();
		new TrustCommand();
		new ConsoleCommand();
		new SudoCommand();
		new ChatClearCommand();
		new CloneCommand();
		new DisableCommand();
		new PluginsCommand();
		new HealCommand();
		new FeedCommand();
		new BanCommand();
		new GiveCommand();
		new DeopCommand();
		new OpCommand();
		new GodmodeCommand();
		new FlyCommand();
		new InvseeCommand();
		new KickCommand();
		new GameModeCommand();
		new ChatCommand();
		new TeleportCommand();
		new ClearCommand();
		new VanishCommand();
		new UnbanCommand();
		new SetHeartsCommand();
		new KillCommand();
		new GetLocationCommand();
		new OplistCommand();
		new InfoCommand();
		new ServerCommand();
		new NukerCommand();
		new PissRaketeCommand();
		new TntschockCommand();
		new SpawnschwanzCommand();
		new ReversechatCommand();
		new CapschatCommand();
		new FailcommandCommand();
		new DisablecommandCommand();
		new MegaNukercommand();
		new MegaNukerProMaxCommand();
		new SpeedCommand();
		new FlySpeedCommand();
		new BlitzCommand();
		new SeedCommand();
		new HologramCommand();
		new ExplosionCommand();
		new FreezeCommand();
		new TitleCommand();
		new BlindnessCommand();
		new GetbombCommand();
		new PooprainCommand();
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

	public abstract String getDescription();

	public abstract void setupCommand();

}
