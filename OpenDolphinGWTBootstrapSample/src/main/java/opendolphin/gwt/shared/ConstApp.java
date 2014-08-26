package opendolphin.gwt.shared;

public final class ConstApp {

	/**
	 * Versteckter Konstruktor.
	 */
	private ConstApp() {
		super();
	}

	public static class TABLE {
		public static final String PM_POSTFIX_DEF = "-TABLEDEF";
		public static final String PM_POSTFIX_ROW = "-TABLEROW-";

		public static final String ATT_SELMODE = "SELMODE";
		public static final String ATT_SELROWS = "SELROWS";
		public static final String ATT_SEL_PM_IDS = "SELPMIDS";
		public static final String ATT_PK_ATT_NAME = "PKATTNAME";

		public static final String SELECTION_MODE_SINGLE = "SELMODESINGLE";
		public static final String SELECTION_MODE_MULTI = "SELMODEMULTI";

		public static class COLUMN {
			public static final String PM_POSTFIX_COLDEF = "-TABLECOLDEF-";

			public static final String ATT_TITLE = "TITLE";
			public static final String ATT_SORTABLE = "SORTABLE";
			public static final String ATT_PM_ATTRIBUTE = "PMATTRIBUTE";
		}
	}

	public static class TAG {

		public static final String CODELIST_EXCLUDES = ".CODELIST_EXCLUDES";
		public static final String CODELIST_INCLUDES = ".CODELIST_INCLUDES";
		public static final String ENABLED = ".ENABLED";
		public static final String ERROR = ".ERROR";
		public static final String INFO = ".INFO";
		public static final String ITEMS = ".ITEMS";
		public static final String LABEL = ".LABEL";
		public static final String MANDATORY = ".MANDATORY";
		// Kennzeichen fuer I18N -> aendert spaeter das LABEL Attribut
		public static final String TEXTNR = ".TEXTNR";
		public static final String TOOLTIP = ".TOOLTIP";
		public static final String VALUE = ".VALUE";
		public static final String WARN = ".WARN";
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