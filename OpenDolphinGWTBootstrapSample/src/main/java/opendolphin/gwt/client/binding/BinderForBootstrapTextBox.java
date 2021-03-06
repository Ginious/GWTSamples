package opendolphin.gwt.client.binding;

import opendolphin.gwt.shared.ConstApp.TAG;

import com.canoo.opendolphin.client.gwt.AttributeChangeHandler;
import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

/**
 * Binder for a common GWT {@link TextBox}.
 */
class BinderForBootstrapTextBox {

	/**
	 * Default constructor.
	 */
	BinderForBootstrapTextBox() {
		super();
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
	void bind(final TextBox inTextBox, final ClientPresentationModel inPm, final String inAttName) {

		// bind all supported tagged values
		bindTaggedAttribute(inTextBox, inPm, inAttName, TAG.VALUE);
		bindTaggedAttribute(inTextBox, inPm, inAttName, TAG.ENABLED);
		bindTaggedAttribute(inTextBox, inPm, inAttName, TAG.ERROR);

		// update PM with text changes of TextBox
		inTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				handleChange(inTextBox, inPm, inAttName);
			}
		});
	}

	/**
	 * Convenience method for binding to a specifically tagged attribute.
	 */
	protected final void bindTaggedAttribute(final TextBox inTextBox, ClientPresentationModel inPm, String inAttName,
			final String inTag) {

		ClientAttribute anAttr = inPm.getAt(inAttName + inTag);
		if (anAttr != null) {

			anAttr.addValueChangedHandler(new AttributeChangeHandler() {

				@Override
				public void handleChange(String oldValue, String newValue) {
					handleUpdate(inTextBox, inTag, newValue);
				}
			});
		} // if
	}

	protected void bindTaggedAttributeCustom(final TextBox inTextBox, ClientPresentationModel inPm, String inAttName,
			final String inTag) {

	}

	/**
	 * 
	 * @param inTextBox
	 * @param inPm
	 * @param inAttName
	 */
	protected final void handleChange(TextBox inTextBox, ClientPresentationModel inPm, String inAttName) {

		ClientAttribute attr = inPm.getAt(inAttName + TAG.VALUE);
		String text = inTextBox.getText();
		attr.setValue(text);
	}

	protected void handleUpdate(TextBox inTextBox, String inTag, String inValue) {

		if (TAG.ENABLED.equals(inTag)) {
			inTextBox.setEnabled(Boolean.valueOf(inValue));
		} else if (TAG.VALUE.equals(inTag)) {
			inTextBox.setText(inValue);
		} // else if
	}
}