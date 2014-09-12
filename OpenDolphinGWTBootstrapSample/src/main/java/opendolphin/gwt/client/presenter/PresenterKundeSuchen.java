package opendolphin.gwt.client.presenter;

import java.util.List;

import opendolphin.gwt.client.binding.Binder;
import opendolphin.gwt.client.view.View;
import opendolphin.gwt.client.view.ViewKundeSuchen;
import opendolphin.gwt.shared.ConstApp.CMD;
import opendolphin.gwt.shared.ConstApp.GUI;
import opendolphin.gwt.shared.ConstApp.PM;

import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.canoo.opendolphin.client.gwt.OnFinishedHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;

public class PresenterKundeSuchen extends AbstractPresenter {

	private ViewKundeSuchen view = new ViewKundeSuchen();

	public PresenterKundeSuchen(ClientDolphin inClientDolphin) {
		super(inClientDolphin);
	}

	@Override
	public View getView() {
		return view;
	}

	@Override
	public void bindView() {

		getClientDolphin().send(CMD.INIT, new OnFinishedHandler() {
			@Override
			public void handlePresentationModels(List<ClientPresentationModel> inListOfPms) {

				ClientPresentationModel aGuiPM = getClientDolphin().findPresentationModelById(PM.GUI);
				ClientAttribute aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.NAME);


				// Label und TextBox "Name"
				Binder.bind(view.getLayout().getSuche().getLblName(), aGuiPM, GUI.KONTAKT.NAME);
				Binder.bindTB(view.getLayout().getSuche().getTxtName(), aGuiPM, GUI.KONTAKT.NAME);

				// Label und TextBox "Vorname"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.VORNAME);
				view.getLayout().getSuche().getLblVorname().setText(aCurrAttr.getValue().toString());
				view.getLayout().getSuche().getTxtVorname().setPlaceholder(aCurrAttr.getValue().toString());

				// Button "Suchen"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.BUTTON_SUCHEN);
				view.getLayout().getSuche().getBtnSuchen().setText(aCurrAttr.getValue().toString());
				view.getLayout().getSuche().getBtnSuchen().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent inEvent) {
						getClientDolphin().send(CMD.SUCHEN);
					}
				});

				// Button "Zuruecksetzen"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.BUTTON_ZURUECKSETZEN);
				view.getLayout().getSuche().getBtnZuruecksetzen().setText(aCurrAttr.getValue().toString());
				view.getLayout().getSuche().getBtnZuruecksetzen().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent inEvent) {
						getClientDolphin().send(CMD.RESET);
					}
				});

				//
				// Details
				//

				// Label "Name"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.NAME);
				view.getLayout().getDetail().getLblName().setText(aCurrAttr.getValue().toString());

				// Label "Vorname"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.VORNAME);
				view.getLayout().getDetail().getLblVorname().setText(aCurrAttr.getValue().toString());

				// Label "Geburtsdatum"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.GEBURTSDATUM);
				view.getLayout().getDetail().getLblGeburtsdatum().setText(aCurrAttr.getValue().toString());

				// Label "Geschlecht"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.GESCHLECHT);
				view.getLayout().getDetail().getLblGeschlecht().setText(aCurrAttr.getValue().toString());

				// Label "Zivilstand"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.ZIVILSTAND);
				view.getLayout().getDetail().getLblZivilstand().setText(aCurrAttr.getValue().toString());

				// Label "Anrede"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.ANREDE);
				view.getLayout().getDetail().getLblAnrede().setText(aCurrAttr.getValue().toString());

				// Button "Neu"
				aCurrAttr = aGuiPM.getAt(GUI.KONTAKT.BUTTON_NEU);
				view.getLayout().getDetail().getBtnNeu().setText(aCurrAttr.getValue().toString());
				view.getLayout().getDetail().getBtnNeu().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent inEvent) {
						getClientDolphin().send(CMD.NEU);
					}
				});
			}
		});
	}
}