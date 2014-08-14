package opendolphin.gwt.shared;

public final class ConstApp {

	/**
	 * Versteckter Konstruktor.
	 */
	private ConstApp() {
		super();
	}

	public static class CMD {

		public static final String INIT = "CMD_INIT";
		public static final String SUCHEN = "CMD_SUCHEN";
		public static final String RESET = "CMD_RESET";
		public static final String NEU = "CMD_NEU";
	}

	public static class PM {

		public static final String GUI = "PM_COMMON";
		public static final String KUNDENSUCHE = "PM_KD_SUCHE";
		public static final String KUNDENDETAILS = "PM_KD_DETAILS";
	}

	public static class KUNDE {

		public static final String NUMMER = "KD_NUMMER";
		public static final String NAME = "KD_NAME";
		public static final String EMAIL = "KD_EMAIL";
		public static final String TYP = "KD_TYP";
	}

	public static class GUI {
		public static class KONTAKT {

			public static final String NAME = "LBLNAME";
			public static final String VORNAME = "LBLVORNAME";
			public static final String GEBURTSDATUM = "LBLGEBURTSDATUM";
			public static final String GESCHLECHT = "LBLGESCHLECHT";
			public static final String ZIVILSTAND = "LBLZIVILSTAND";
			public static final String ANREDE = "LBLANREDE";
			
			public static final String BUTTON_SUCHEN = "BTN_SUCHEN";
			public static final String BUTTON_ZURUECKSETZEN = "BTN_ZURUECKSETZEN";
			public static final String BUTTON_NEU = "BTN_NEU";
		}
	}
}