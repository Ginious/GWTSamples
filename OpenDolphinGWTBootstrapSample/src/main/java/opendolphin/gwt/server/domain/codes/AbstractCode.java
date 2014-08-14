package opendolphin.gwt.server.domain.codes;

abstract class AbstractCode implements Code {

	private String dispName;
	private int id;

	protected AbstractCode(int inId, String inDispName) {

		id = inId;
		dispName = inDispName;
	}

	@Override
	public String getDisplayName() {
		return dispName;
	}

	@Override
	public int getId() {
		return id;
	}
}