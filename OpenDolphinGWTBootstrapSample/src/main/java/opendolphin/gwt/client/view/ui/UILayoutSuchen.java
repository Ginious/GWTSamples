package opendolphin.gwt.client.view.ui;

import com.github.gwtbootstrap.client.ui.Column;
import com.github.gwtbootstrap.client.ui.Row;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UILayoutSuchen extends Composite {

	interface Binder extends UiBinder<Widget, UILayoutSuchen> {
		// empty
	}

	private static Binder UIBINDER = GWT.create(Binder.class);

	@UiField
	Row rowSearch;
	@UiField
	Column colDetails;

	public UILayoutSuchen() {
		super();

		initWidget(UIBINDER.createAndBindUi(this));

		rowSearch.add(new UISuche());
		colDetails.add(new UIDetail());
	}
}