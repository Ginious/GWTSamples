package opendolphin.gwt.shared;

public final class ConstApp {

	/**
	 * Versteckter Konstruktor.
	 */
	private ConstApp() {
		super();
	}

	public static class CMD {

		public static final String SUCHEN = "CMD_SUCHEN";
		public static final String RESET = "CMD_RESET";
		public static final String NEU = "CMD_NEU";
	}
		
	public static class KUNDE {
		
		public static final String PM_KUNDENSUCHE = "PM_KD_SUCHE";
		public static final String PM_KUNDENDETAILS = "PM_KD_DETAILS";
		
		public static final String NUMMER = "KD_NUMMER";
		public static final String NAME = "KD_NAME";
		public static final String EMAIL = "KD_EMAIL";
		public static final String TYP = "KD_TYP";
	}
}