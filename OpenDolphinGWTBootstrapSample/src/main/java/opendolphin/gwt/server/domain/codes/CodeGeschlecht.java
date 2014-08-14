package opendolphin.gwt.server.domain.codes;

public class CodeGeschlecht extends AbstractCode {

	public static final CodeGeschlecht MAENNLICH = new CodeGeschlecht(0, "männlich");
	public static final CodeGeschlecht WEIBLICH = new CodeGeschlecht(1, "weiblich");

	private CodeGeschlecht(int inId, String inDispName) {
		super(inId, inDispName);
	}
}