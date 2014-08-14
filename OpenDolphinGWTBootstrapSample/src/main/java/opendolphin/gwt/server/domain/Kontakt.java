package opendolphin.gwt.server.domain;

import java.util.Date;

import opendolphin.gwt.server.domain.codes.CodeAnrede;
import opendolphin.gwt.server.domain.codes.CodeGeschlecht;
import opendolphin.gwt.server.domain.codes.CodeStatus;
import opendolphin.gwt.server.domain.codes.CodeZivilstand;

public final class Kontakt {

	private CodeAnrede anrede;
	private String ersteller;
	private Date geburtsdatum;
	private CodeGeschlecht geschlecht;
	private String name;
	private CodeStatus status;
	private String vorname;
	private CodeZivilstand zivilstand;

	public Kontakt() {
		super();
	}

	public CodeAnrede getAnrede() {
		return anrede;
	}

	public String getErsteller() {
		return ersteller;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public CodeGeschlecht getGeschlecht() {
		return geschlecht;
	}

	public String getName() {
		return name;
	}

	public CodeStatus getStatus() {
		return status;
	}

	public String getVorname() {
		return vorname;
	}

	public CodeZivilstand getZivilstand() {
		return zivilstand;
	}

	public void setAnrede(CodeAnrede anrede) {
		this.anrede = anrede;
	}

	public void setErsteller(String ersteller) {
		this.ersteller = ersteller;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public void setGeschlecht(CodeGeschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(CodeStatus status) {
		this.status = status;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setZivilstand(CodeZivilstand zivilstand) {
		this.zivilstand = zivilstand;
	}
}