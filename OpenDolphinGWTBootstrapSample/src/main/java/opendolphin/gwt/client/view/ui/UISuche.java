package opendolphin.gwt.client.view.ui;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UISuche extends Composite {

	interface Binder extends UiBinder<Widget, UISuche> {
		// empty
	}

	private static Binder UIBINDER = GWT.create(Binder.class);

	public static Binder getUIBINDER() {
		return UIBINDER;
	}

	@UiField
	Button btnSuchen;
	@UiField
	Button btnZuruecksetzen;
	@UiField
	Label lblName;
	@UiField
	Label lblVorname;
	@UiField
	TextBox txtName;

	@UiField
	TextBox txtVorname;

	public UISuche() {
		super();

		initWidget(UIBINDER.createAndBindUi(this));
	}

	public Button getBtnSuchen() {
		return btnSuchen;
	}

	public Button getBtnZuruecksetzen() {
		return btnZuruecksetzen;
	}

	public Label getLblName() {
		return lblName;
	}

	public Label getLblVorname() {
		return lblVorname;
	}

	public TextBox getTxtName() {
		return txtName;
	}

	public TextBox getTxtVorname() {
		return txtVorname;
	}
}