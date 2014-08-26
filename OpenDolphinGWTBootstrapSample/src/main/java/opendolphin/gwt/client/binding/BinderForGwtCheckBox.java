package opendolphin.gwt.client.binding;

import opendolphin.gwt.shared.ConstApp.TAG;

import com.canoo.opendolphin.client.gwt.AttributeChangeHandler;
import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * Binder for a common GWT {@link CheckBox}.
 * 
 * Inherit this class in order to implement bindings for more specific check box
 * widgets like e.g. the check box widget of GWT Bootstrap.
 */
public final class BinderForGwtCheckBox {

	/**
	 * 
	 */
	protected BinderForGwtCheckBox() {
		super();
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
	public final void bind(final CheckBox inCheckBox, final ClientPresentationModel inPm, final String inAttName) {

		// bind all supported tagged values
		bindTaggedAttribute(inCheckBox, inPm, inAttName, TAG.VALUE);
		bindTaggedAttribute(inCheckBox, inPm, inAttName, TAG.ENABLED);

		inCheckBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent inEvent) {

				ClientAttribute attr = inPm.getAt(inAttName + TAG.VALUE);
				attr.setValue(String.valueOf(inCheckBox.getValue()));
			}
		});

		bindCustom(inCheckBox, inPm, inAttName);
	}

	/**
	 * Performs sub class specific binding.
	 * 
	 * @param inCheckBox
	 *            The check box widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 */
	protected void bindCustom(CheckBox inCheckBox, final ClientPresentationModel inPm, final String inAttName) {

	}

	/**
	 * Convenience method for binding to a specifically tagged attribute.
	 * 
	 * @param inCheckBox
	 *            The check box widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 * @param inTag
	 *            The name of the attribute tag to bind to.
	 */
	private void bindTaggedAttribute(final CheckBox inCheckBox, ClientPresentationModel inPm, String inAttName, final String inTag) {

		ClientAttribute anAttr = inPm.getAt(inAttName + inTag);
		if (anAttr != null) {

			anAttr.addValueChangedHandler(new AttributeChangeHandler() {

				@Override
				public void handleChange(String oldValue, String newValue) {
					handleUpdate(inCheckBox, inTag, newValue);
				}
			});
		} // if
	}

	/**
	 * Handles the update of the given Label with the given tag and value.
	 * 
	 * @param inCheckBox
	 *            The check box widget to update.
	 * @param inTag
	 *            The tag for which an update was received.
	 * @param inValue
	 *            The new value.
	 */
	private void handleUpdate(CheckBox inCheckBox, String inTag, String inValue) {

		if (TAG.ENABLED.equals(inTag)) {
			inCheckBox.setEnabled(Boolean.valueOf(inValue));
		} else if (TAG.VALUE.equals(inTag)) {
			inCheckBox.setValue(Boolean.valueOf(inValue));
		} // else if

		handleUpdateCustom(inCheckBox, inTag, inValue);
	}

	/**
	 * Performs sub class specific binding of the given CheckBox with the given
	 * tag and value.
	 * 
	 * @param inCheckBox
	 *            The check box widget to update.
	 * @param inTag
	 *            The tag for which an update was received.
	 * @param inValue
	 *            The new value.
	 */
	protected void handleUpdateCustom(CheckBox inCheckBox, String inTag, String inValue) {

	}
}