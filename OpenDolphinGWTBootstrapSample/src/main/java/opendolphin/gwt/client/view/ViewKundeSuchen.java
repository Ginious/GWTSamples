package opendolphin.gwt.client.view;

import opendolphin.gwt.client.view.ui.UILayoutSuchen;

import com.google.gwt.user.client.ui.Widget;

public class ViewKundeSuchen implements View {

	private UILayoutSuchen layout = new UILayoutSuchen();

	public ViewKundeSuchen() {
		super();
	}

	@Override
	public Widget asWidget() {

		return layout;
	}

	public UILayoutSuchen getLayout() {
		return layout;
	}
}