package opendolphin.gwt.client.binding;

import java.util.List;

import opendolphin.gwt.client.action.Command;
import opendolphin.gwt.shared.ConstApp.TAG;

import com.canoo.opendolphin.client.gwt.AttributeChangeHandler;
import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.canoo.opendolphin.client.gwt.OnFinishedHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * Binder for a common GWT {@link Button}.
 * 
 * Inherit this class in order to implement bindings for more specific button
 * widgets like e.g. the button widget of GWT Bootstrap.
 */
public class BinderForGwtButton {

	/**
	 * Default constructor.
	 */
	protected BinderForGwtButton() {
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
	public final void bind(final Button inGwtButton, final ClientDolphin inDolphin, final ClientPresentationModel inPm,
			final String inAttName, final String inCommandId, final Command inCommandToExec) {

		// bind all supported tagged values
		bindTaggedAttribute(inGwtButton, inPm, inAttName, TAG.ENABLED);
		bindTaggedAttribute(inGwtButton, inPm, inAttName, TAG.LABEL);

		// register action listener
		if (inDolphin != null) {
			inGwtButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent aEvent) {
					if (inCommandToExec != null) {
						inDolphin.send(inCommandId, new OnFinishedHandler() {
							@Override
							public void handlePresentationModels(List<ClientPresentationModel> pms) {
								inCommandToExec.execute();
							}
						});
					} else {
						inDolphin.send(inCommandId);
					}
				}
			});
		} // if

		bindCustom(inGwtButton, inDolphin, inPm, inAttName, inCommandId, inCommandToExec);
	}

	/**
	 * Performs sub class specific binding.
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
	 *            The optional client side command to be executed when the
	 *            server side command has been executed.
	 */
	protected void bindCustom(final Button inGwtButton, final ClientDolphin inDolphin, final ClientPresentationModel inPm,
			final String inAttName, final String inCommandId, final Command inCommandToExec) {

	}

	/**
	 * Convenience method for binding to a specifically tagged attribute.
	 * 
	 * @param inButton
	 *            The button to bind.
	 * @param inPm
	 *            The client presentation model containing the attributes to
	 *            bind the button to.
	 * @param inAttName
	 *            The name of the attribut the button will be bound to (requires
	 *            following Tags: ENABLED, LABEL, TEXTNR).
	 * @param inTag
	 *            The name of the tag.
	 */
	private void bindTaggedAttribute(final Button inButton, ClientPresentationModel inPm, String inAttName, final String inTag) {

		if (inAttName != null) {

			ClientAttribute anAttr = inPm.getAt(inAttName + inTag);
			if (anAttr != null) {

				anAttr.addValueChangedHandler(new AttributeChangeHandler() {

					@Override
					public void handleChange(String oldValue, String newValue) {
						handleUpdate(inButton, inTag, newValue.toString());
					}
				});
			} // if
		} // if
	}

	/**
	 * Method for applying changes to the GUI that occur in the model.
	 * 
	 * @param inButton
	 *            The button to update.
	 * @param inTag
	 *            The tag for which a change was recognized.
	 * @param inValue
	 *            The new value of the changed attribute.
	 */
	private void handleUpdate(Button inButton, String inTag, String inValue) {

		if (TAG.ENABLED.equals(inTag)) {
			inButton.setEnabled(Boolean.valueOf(inValue));
		} else if (TAG.LABEL.equals(inTag)) {
			inButton.setText(inValue);
		} // else if

		handleUpdateCustom(inButton, inTag, inValue);
	}

	/**
	 * Performs sub class specific binding of the given Label with the given tag
	 * and value.
	 * 
	 * @param inButton
	 *            The button to update.
	 * @param inTag
	 *            The tag for which a change was recognized.
	 * @param inValue
	 *            The new value of the changed attribute.
	 */
	protected void handleUpdateCustom(Button inButton, String inTag, String inValue) {

	}
}