package opendolphin.gwt.client.view.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UISuche extends Composite {

	interface Binder extends UiBinder<Widget, UISuche> {
		// empty
	}

	private static Binder UIBINDER = GWT.create(Binder.class);

	public UISuche() {
		super();

		initWidget(UIBINDER.createAndBindUi(this));
	}
}