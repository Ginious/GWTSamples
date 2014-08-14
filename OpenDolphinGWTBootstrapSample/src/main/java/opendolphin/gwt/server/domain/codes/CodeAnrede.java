package opendolphin.gwt.server.domain.codes;

public class CodeAnrede extends AbstractCode {

	public static final CodeAnrede HERR = new CodeAnrede(0, "Herr");
	public static final CodeAnrede FRAU = new CodeAnrede(1, "Frau");

	private CodeAnrede(int inId, String inDispName) {
		super(inId, inDispName);
	}
}