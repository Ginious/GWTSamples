package opendolphin.gwt.client.view.ui;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UIDetail extends Composite {

	interface Binder extends UiBinder<Widget, UIDetail> {
		// empty
	}

	private static Binder UIBINDER = GWT.create(Binder.class);

	@UiField
	Label lblVorname;
	@UiField
	Label lblName;
	@UiField
	Label lblGeburtsdatum;
	@UiField
	Label lblGeschlecht;
	@UiField
	Label lblZivilstand;
	@UiField
	Label lblAnrede;
	@UiField
	TextBox txtName;
	@UiField
	TextBox txtVorname;
	@UiField
	Button btnNeu;
	
	public UIDetail() {
		super();

		initWidget(UIBINDER.createAndBindUi(this));
	}


	public static Binder getUIBINDER() {
		return UIBINDER;
	}


	public Label getLblVorname() {
		return lblVorname;
	}


	public Label getLblName() {
		return lblName;
	}


	public Label getLblGeburtsdatum() {
		return lblGeburtsdatum;
	}


	public Label getLblGeschlecht() {
		return lblGeschlecht;
	}


	public Label getLblZivilstand() {
		return lblZivilstand;
	}


	public Label getLblAnrede() {
		return lblAnrede;
	}


	public TextBox getTxtName() {
		return txtName;
	}


	public TextBox getTxtVorname() {
		return txtVorname;
	}


	public Button getBtnNeu() {
		return btnNeu;
	}
}