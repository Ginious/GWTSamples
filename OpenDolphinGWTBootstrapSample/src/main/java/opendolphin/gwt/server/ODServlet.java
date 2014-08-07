package opendolphin.gwt.server;

import opendolphin.gwt.server.command.CommandNeu;
import opendolphin.gwt.server.command.CommandSuchen;
import opendolphin.gwt.server.command.CommandZuruecksetzen;

import org.opendolphin.core.server.ServerDolphin;
import org.opendolphin.server.adapter.DolphinServlet;

//@WebServlet(name = "OpenDolphinServlet", urlPatterns = "/opendolphin", loadOnStartup = 1)
public class ODServlet extends DolphinServlet {

	private static final long serialVersionUID = 6887741078088616813L;

	public ODServlet() {
		super();
	}

	@Override
	protected void registerApplicationActions(ServerDolphin inServerDolphin) {

		inServerDolphin.register(new CommandNeu());
		inServerDolphin.register(new CommandZuruecksetzen());
		inServerDolphin.register(new CommandSuchen());
	}
}