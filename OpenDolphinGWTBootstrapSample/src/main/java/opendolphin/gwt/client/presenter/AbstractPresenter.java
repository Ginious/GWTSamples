package opendolphin.gwt.client.presenter;

import com.canoo.opendolphin.client.gwt.ClientDolphin;

abstract class AbstractPresenter implements Presenter {

	private ClientDolphin clientDolphin;

	public AbstractPresenter(ClientDolphin inClientDolphin) {
		super();

		clientDolphin = inClientDolphin;
	}

	protected final ClientDolphin getClientDolphin() {

		return clientDolphin;
	}
}