package opendolphin.gwt.server.domain.codes;

public class CodeZivilstand extends AbstractCode {

	public static final CodeZivilstand LEDIG = new CodeZivilstand(0, "ledig");
	public static final CodeZivilstand VERHEIRATET = new CodeZivilstand(1, "verheiratet");
	public static final CodeZivilstand GESCHIEDEN = new CodeZivilstand(2, "geschieden");
	public static final CodeZivilstand GETRENNT = new CodeZivilstand(3, "getrennt lebend");

	private CodeZivilstand(int inId, String inDispName) {
		super(inId, inDispName);
	}
}