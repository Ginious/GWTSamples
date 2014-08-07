package opendolphin.gwt.client;

import opendolphin.gwt.client.presenter.Presenter;
import opendolphin.gwt.client.presenter.PresenterKundeSuchen;

import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.canoo.opendolphin.client.gwt.DolphinStarter;
import com.canoo.opendolphin.client.js.DolphinLoaderJS;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class SampleAppEntryPoint implements EntryPoint {

	private static ClientDolphin dolphin;

	public static ClientDolphin getClientDolphin() {
		return dolphin;
	}

	public SampleAppEntryPoint() {
		super();
	}

	@Override
	public void onModuleLoad() {

		// Start Open Dolphin communication stack
		DolphinLoaderJS.load(GWT.getHostPageBaseURL() + "opendolphin", new DolphinStarter() {
			@Override
			public void start(ClientDolphin inDolphin) {
				dolphin = inDolphin;
				initLayout();
			}
		});
	}

	private void initLayout() {
		Presenter aKundensuchePresenter = new PresenterKundeSuchen(dolphin);
		aKundensuchePresenter.bindView();

		RootPanel.get().add(aKundensuchePresenter.getView().asWidget());
	}
}