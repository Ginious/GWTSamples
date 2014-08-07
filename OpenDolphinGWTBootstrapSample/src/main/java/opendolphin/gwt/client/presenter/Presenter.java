package opendolphin.gwt.client.presenter;

import opendolphin.gwt.client.view.View;

public interface Presenter {

	View getView();
	
	void bindView();
}