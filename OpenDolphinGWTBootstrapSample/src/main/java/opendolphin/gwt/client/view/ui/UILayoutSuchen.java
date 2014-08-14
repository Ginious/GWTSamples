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

	public static Binder getUIBINDER() {
		return UIBINDER;
	}
	@UiField
	Column colDetails;
	
	private UIDetail detail = new UIDetail();
	@UiField
	Row rowSearch;

	private UISuche suche = new UISuche();

	public UILayoutSuchen() {
		super();

		initWidget(UIBINDER.createAndBindUi(this));

		rowSearch.add(suche);
		colDetails.add(detail);
	}

	public Column getColDetails() {
		return colDetails;
	}

	public UIDetail getDetail() {
		return detail;
	}

	public Row getRowSearch() {
		return rowSearch;
	}

	public UISuche getSuche() {
		return suche;
	}
}