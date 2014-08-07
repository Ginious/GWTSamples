package opendolphin.gwt.client.presenter;

import opendolphin.gwt.client.view.View;
import opendolphin.gwt.client.view.ViewKundeSuchen;

import com.canoo.opendolphin.client.gwt.ClientDolphin;

public class PresenterKundeSuchen extends AbstractPresenter {

	public PresenterKundeSuchen(ClientDolphin inClientDolphin) {
		super(inClientDolphin);
	}

	@Override
	public View getView() {
		return new ViewKundeSuchen();
	}

	@Override
	public void bindView() {

	}
}