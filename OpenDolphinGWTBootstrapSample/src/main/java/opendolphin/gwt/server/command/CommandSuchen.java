package opendolphin.gwt.server.command;

import java.util.List;

import opendolphin.gwt.shared.ConstApp.CMD;

import org.opendolphin.core.comm.Command;
import org.opendolphin.core.server.action.DolphinServerAction;
import org.opendolphin.core.server.comm.ActionRegistry;
import org.opendolphin.core.server.comm.CommandHandler;

/**
 * Command zum Suchen
 */
public class CommandSuchen extends DolphinServerAction {

	public CommandSuchen() {
		super();
	}

	@Override
	public void registerIn(ActionRegistry inRegistry) {

		inRegistry.register(CMD.SUCHEN, new CommandHandler<Command>() {
			@Override
			public void handleCommand(Command command, List<Command> response) {

				System.out.println("************* SUCHEN");
			}
		});
	}
}