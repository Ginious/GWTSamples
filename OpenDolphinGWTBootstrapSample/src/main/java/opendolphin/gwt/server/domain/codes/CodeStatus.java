package opendolphin.gwt.server.domain.codes;

public class CodeStatus extends AbstractCode {

	public static final CodeStatus AKTIV = new CodeStatus(0, "aktiv");
	public static final CodeStatus INAKTIV = new CodeStatus(1, "inaktiv");
	public static final CodeStatus ARCHIVIERT = new CodeStatus(2, "archiviert");

	private CodeStatus(int inId, String inDispName) {
		super(inId, inDispName);
	}
}