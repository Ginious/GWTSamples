package opendolphin.gwt.client.view;

import opendolphin.gwt.client.view.ui.UILayoutSuchen;

import com.google.gwt.user.client.ui.Widget;

public class ViewKundeSuchen implements View {

	public ViewKundeSuchen() {
		super();
	}

	@Override
	public Widget asWidget() {

		return new UILayoutSuchen();
	}
}