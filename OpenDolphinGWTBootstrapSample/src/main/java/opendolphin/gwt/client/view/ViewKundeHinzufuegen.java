package opendolphin.gwt.client.view;

import opendolphin.gwt.client.view.ui.UILayoutSuchen;

import com.google.gwt.user.client.ui.Widget;

public class ViewKundeHinzufuegen implements View {

	public ViewKundeHinzufuegen() {
		super();
	}

	@Override
	public Widget asWidget() {

		return new UILayoutSuchen();
	}
}