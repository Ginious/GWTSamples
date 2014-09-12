package opendolphin.gwt.client.binding;

 import opendolphin.gwt.client.action.Command;

import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.TextBox;

public final class Binder {

	/**
	 * Hide constructor.
	 */
	private Binder() {
		super();
	}

	/**
	 * Binds the GWT Button widget.
	 * 
	 * @param inGwtButton
	 *            The Button to bind.
	 * @param inDolphin
	 *            The server dolphin required for invoking an OpenDolphin
	 *            command on the server side.
	 * @param inPm
	 *            The client presentation model containing the attributes to
	 *            bind the button to.
	 * @param inAttName
	 *            The name of the attribut the button will be bound to (requires
	 *            following Tags: ENABLED, LABEL, TEXTNR).
	 * @param inCommandId
	 *            The ID of the OpenDolphin command to be executed on the server
	 *            side.
	 * @param inCommandToExec
	 *            Optional client side command to be executed when the server
	 *            side command has been executed or <code>null</code> if the
	 *            client does not require a command being executed.
	 */
	public static void bind(final Button inGwtButton, final ClientDolphin inDolphin, final ClientPresentationModel inPm,
			final String inAttName, final String inCommandId, final Command inCommandToExec) {
		new BinderForBootstrapButton().bind(inGwtButton, inDolphin, inPm, inAttName, inCommandId, inCommandToExec);
	}

	/**
	 * Binds the GWT CellTable widget to the given table Id that is contained in
	 * the given client presentation model.
	 * 
	 * @param inGwtCellTable
	 *            The cell table widget to bind.
	 * @param inClient
	 *            The client dolphin for accessing presentation models.
	 * @param inTableId
	 *            The ID of the table used for binding.
	 */
	@SuppressWarnings("rawtypes")
	public static void bind(CellTable inGwtCellTable, ClientDolphin inClient, String inTableId) {
		new BinderForBootstrapCellTable().bind(inGwtCellTable, inClient, inTableId);
	}

	/**
	 * Binds the GWT check box widget to the given attribute of the given client
	 * presentation model.
	 * 
	 * @param inGwtLabel
	 *            The label widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 */
	public static void bind(final CheckBox inCheckBox, final ClientPresentationModel inPm, final String inAttName) {
		new BinderForBootstrapCheckBox().bind(inCheckBox, inPm, inAttName);
	}

	/**
	 * Binds the GWT Label widget to the given attribute of the given client
	 * presentation model.
	 * 
	 * @param inGwtLabel
	 *            The label widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 */
	public static void bind(Label inGwtLabel, final ClientPresentationModel inPm, final String inAttName) {
		new BinderForBootstrapLabel().bind(inGwtLabel, inPm, inAttName);
	}

	/**
	 * Binds the GWT TextBox widget to the given attribute of the given client
	 * presentation model.
	 * 
	 * @param inTextBox
	 *            The {@link TextBox} to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 */
	public static void bindTB(final TextBox inTextBox, final ClientPresentationModel inPm, final String inAttName) {
		new BinderForBootstrapTextBox().bind(inTextBox, inPm, inAttName);
	}
}