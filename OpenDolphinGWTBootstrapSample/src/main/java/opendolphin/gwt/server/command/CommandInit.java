package opendolphin.gwt.server.command;

import java.util.ArrayList;
import java.util.List;

import opendolphin.gwt.shared.ConstApp.CMD;
import opendolphin.gwt.shared.ConstApp.GUI;
import opendolphin.gwt.shared.ConstApp.PM;

import org.opendolphin.core.comm.Command;
import org.opendolphin.core.server.DTO;
import org.opendolphin.core.server.Slot;
import org.opendolphin.core.server.action.DolphinServerAction;
import org.opendolphin.core.server.comm.ActionRegistry;
import org.opendolphin.core.server.comm.CommandHandler;

/**
 * Command zum Initialisieren
 */
public class CommandInit extends DolphinServerAction {

	public CommandInit() {
		super();
	}

	@Override
	public void registerIn(ActionRegistry inRegistry) {

		inRegistry.register(CMD.INIT, new CommandHandler<Command>() {
			@Override
			public void handleCommand(Command command, List<Command> response) {

				List<Slot> aListOfSlots = new ArrayList<Slot>();
				aListOfSlots.add(new Slot(GUI.KONTAKT.GEBURTSDATUM, "Geburtsdatum"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.GESCHLECHT, "Geschlecht"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.NAME, "Name"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.VORNAME, "Vorname"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.ZIVILSTAND, "Zivilstand"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.ANREDE, "Anrede"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.BUTTON_SUCHEN, "Suchen"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.BUTTON_ZURUECKSETZEN, "Zurücksetzen"));
				aListOfSlots.add(new Slot(GUI.KONTAKT.BUTTON_NEU, "Neuen Kontakt anlegen"));

				getServerDolphin().presentationModel(PM.GUI, null, new DTO(aListOfSlots));
			}
		});
	}
}