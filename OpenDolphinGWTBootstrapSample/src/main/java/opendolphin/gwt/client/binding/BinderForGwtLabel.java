package opendolphin.gwt.client.binding;

import opendolphin.gwt.shared.ConstApp.TAG;

import com.canoo.opendolphin.client.gwt.AttributeChangeHandler;
import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.google.gwt.user.client.ui.Label;

/**
 * Binder for a common GWT {@link Label}.
 * 
 * Inherit this class in order to implement bindings for more specific label
 * widgets like e.g. the label widget of GWT Bootstrap.
 */
public class BinderForGwtLabel {

	/**
	 * Default constructor.
	 */
	protected BinderForGwtLabel() {
		super();
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
	public final void bind(Label inGwtLabel, final ClientPresentationModel inPm, final String inAttName) {

		bindTaggedAttribute(inGwtLabel, inPm, inAttName, TAG.LABEL);

		bindCustom(inGwtLabel, inPm, inAttName);
	}

	/**
	 * Performs sub class specific binding.
	 * 
	 * @param inGwtLabel
	 *            The label widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 */
	protected void bindCustom(Label inGwtLabel, final ClientPresentationModel inPm, final String inAttName) {

	}

	/**
	 * Convenience method for binding to a specifically tagged attribute.
	 * 
	 * @param inLabel
	 *            The label widget to bind.
	 * @param inPm
	 *            The client side presentation model to bind to.
	 * @param inAttName
	 *            The name of the attribute to bind to.
	 * @param inTag
	 *            The name of the attribute tag to bind to.
	 */
	protected final void bindTaggedAttribute(final Label inLabel, ClientPresentationModel inPm, String inAttName, final String inTag) {

		ClientAttribute anAttr = inPm.getAt(inAttName + inTag);
		if (anAttr != null) {

			anAttr.addValueChangedHandler(new AttributeChangeHandler() {
				@Override
				public void handleChange(String oldValue, String newValue) {
					handleUpdate(inLabel, inTag, newValue);
				}
			});
			handleUpdate(inLabel, inTag, anAttr.getValue());
		} // if
	}

	/**
	 * Handles the update of the given Label with the given tag and value.
	 * 
	 * @param inLabel
	 *            The label widget to update.
	 * @param inTag
	 *            The tag for which an update was received.
	 * @param inValue
	 *            The new value.
	 */
	private void handleUpdate(Label inLabel, String inTag, String inValue) {

		if (TAG.LABEL.equals(inTag)) {
			inLabel.setText(inValue);
		}

		handleUpdateCustom(inLabel, inTag, inValue);
	}

	/**
	 * Performs sub class specific binding of the given Label with the given tag
	 * and value.
	 * 
	 * @param inLabel
	 *            The label widget to update.
	 * @param inTag
	 *            The tag for which an update was received.
	 * @param inValue
	 *            The new value.
	 */
	protected void handleUpdateCustom(Label inLabel, String inTag, String inValue) {

	}
}