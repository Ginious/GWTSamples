package opendolphin.gwt.client.binding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import opendolphin.gwt.shared.ConstApp.TABLE;
import opendolphin.gwt.shared.ConstApp.TABLE.COLUMN;
import opendolphin.gwt.shared.ConstApp.TAG;

import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.canoo.opendolphin.client.gwt.ModelStoreChangeEventType;
import com.canoo.opendolphin.client.gwt.ModelStoreChangeHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * Binder for a common GWT {@link CellTable}.
 * 
 * Inherit this class in order to implement bindings for more specific table
 * widgets like e.g. the cell table widget of GWT Bootstrap.
 */
class BinderForGwtCellTable {

	/**
	 * Liste der Tabellendaten, die bewirtschaftet wird.
	 */
	private List<ClientPresentationModel> data;

	/**
	 * Das {@link BaslerTable} Widget.
	 */
	@SuppressWarnings("rawtypes")
	private CellTable widgetTable;

	/**
	 * Default Konstruktor.
	 */
	BinderForGwtCellTable() {
		super();
	}

	/**
	 * Binds the GWT CellTable widget to the given table Id that is contained in
	 * the given client presentation model.
	 * 
	 * @param inGwtCellTable
	 *            The cell table widget to bind.
	 * @param inClient
	 *            The client dolphin for accessing presentation models.
	 * @param inTableId
	 *            The ID of the table used for binding.
	 */
	@SuppressWarnings("rawtypes")
	void bind(CellTable inGwtCellTable, ClientDolphin inClient, String inTableId) {

		// Tabelle initialisieren
		initTableDataChangeListener(inClient, inTableId);
		initTableSelectionMode(inClient, inTableId);
		initTableData(inGwtCellTable);

		// Spalten initialisieren
		initColumns(inClient, inTableId);
	}

	/**
	 * Erzeugt eine Spalte fuer das angegebene Attribut.
	 * 
	 * @param aColValueAttName
	 *            Der Name des Attributs, welches den Spaltenwert haelt.
	 * @return Die erzeugte Tabellenspalte.
	 */
	private Column<ClientPresentationModel, String> createTableColumn(final String aColValueAttName, final String aSortable) {

		TextColumn<ClientPresentationModel> outCol = new TextColumn<ClientPresentationModel>() {
			@Override
			public String getValue(ClientPresentationModel inPm) {
				ClientAttribute att = inPm.getAt(aColValueAttName + TAG.VALUE);
				return att.getValue().toString();
			}
		};
		outCol.setSortable(Boolean.valueOf(aSortable));

		return outCol;
	}

	/**
	 * Definiert das Sorting sofern es fuer die gegebene Spalte spezifiziert
	 * wurde.
	 * 
	 * @param aNewColumn
	 *            Die neu erstellte Spalte, fuer welche Sorting definiert werden
	 *            soll.
	 * @param aColName
	 *            Der Name der Spalte, nach welcher sortiert werden soll.
	 */
	private void defineColumnSorting(Column<ClientPresentationModel, String> aNewColumn, final String aColName) {

		if (aNewColumn.isSortable()) {

			ListHandler<ClientPresentationModel> lSortHandler = new ListHandler<ClientPresentationModel>(data);
			lSortHandler.setComparator(aNewColumn, new Comparator<ClientPresentationModel>() {
				@Override
				public int compare(ClientPresentationModel aPm1, ClientPresentationModel aPm2) {
					String lValue1 = aPm1.getAt(aColName + TAG.VALUE).getValue();
					String lValue2 = aPm2.getAt(aColName + TAG.VALUE).getValue();

					if (lValue1 == lValue2) {
						return 0;
					} // if

					if (lValue1 != null) {
						return (lValue2 != null) ? lValue1.compareTo(lValue2) : 1;
					} // if

					return -1;
				}
			});

			widgetTable.addColumnSortHandler(lSortHandler);
		} // if
	}

	/**
	 * Erzeugt und initialisiert die Spalten der Tabelle basierend auf allen OD
	 * Attributen der gegeben Tabelle.
	 * 
	 * @param aClient
	 *            Der Dolphin Client fuer die Registrierung des Listeners.
	 * @param aTableId
	 *            Die ID der Tabellendefinition.
	 */
	@SuppressWarnings("unchecked")
	private void initColumns(final ClientDolphin aClient, final String aTableId) {

		// alle PMs holen, die eine Spalte spezifizieren
		for (ClientPresentationModel currPm : aClient.findAllPresentationModelsByType(aTableId + COLUMN.PM_POSTFIX_COLDEF)) {

			// Spezifikation der aktuellen Spalte holen
			String lSort = currPm.getAt(COLUMN.ATT_SORTABLE + TAG.VALUE).getValue();
			String lLabel = currPm.getAt(COLUMN.ATT_TITLE + TAG.LABEL).getValue();
			String lColValueAttName = currPm.getAt(COLUMN.ATT_PM_ATTRIBUTE + TAG.VALUE).getValue();

			// sicherstellen, dass Spezifikation vollstaendig ist
			assert lSort != null : "Die Sortierung fuer Tabellenspalte '" + currPm.getId() + "' wurde nicht gefunden!";
			assert lLabel != null : "Das Label fuer den Titel der Tabellenspalte '" + currPm.getId() + "' wurde nicht gefunden!";
			assert lColValueAttName != null : "Der Name des Attributs fuer den Spaltenwert von Spalte '" + currPm.getId()
					+ "' wurde nicht gefunden!";

			// neue Spalte ggf. mit Sortierung erzeugen
			Column<ClientPresentationModel, String> lNewColumn = createTableColumn(lColValueAttName, lSort);
			widgetTable.addColumn(lNewColumn, lLabel);
			defineColumnSorting(lNewColumn, lColValueAttName);
		} // for
	}

	/**
	 * Initialisiert die Tabelle mit einer leeren Liste, die im weiteren Verlauf
	 * bewirtschaftet werden kann.
	 * 
	 * @param aTableWidget
	 *            Das Tabellen Widget.
	 */
	@SuppressWarnings({ "unchecked" })
	private void initTableData(Composite aTableWidget) {

		data = new ArrayList<ClientPresentationModel>();
		widgetTable.setRowData(data);
	}

	/**
	 * Initialisiert einen Open Dolphin spezifischen Listener, welcher
	 * informiert wird, sobald ein PM hinzugefuegt bzw. entfernt wurde, um die
	 * Tabellendaten entsprechend nachfuehren zu koennen.
	 * 
	 * @param aClient
	 *            Der Dolphin Client fuer die Registrierung des Listeners.
	 * @param aTableId
	 *            Die ID der Tabellendefinition.
	 */
	private void initTableDataChangeListener(final ClientDolphin aClient, final String aTableId) {

		aClient.addModelStoreListener(new ModelStoreChangeHandler() {
			@Override
			public void handleChange(ModelStoreChangeEventType inChangeType, ClientPresentationModel inPm) {

				// nur dem PM Identifier entsprechende Modelle beruecksichtigen
				if (inPm.getPresentationModelType() != null
						&& inPm.getPresentationModelType().equals(aTableId + TABLE.PM_POSTFIX_ROW)) {
					if (ModelStoreChangeEventType.ADDED.equals(inChangeType)) {
						data.add(inPm);
					} else {
						data.remove(inPm);
					} // else
				} // if
			}
		});
	}

	/**
	 * Initialisiert das zu verwendende Tabellen Selectionsmodell und setzt bei
	 * einer Selektion den Wert der Attribute <code>[TABELLEN_ID]SELROWS</code>
	 * sowie <code>[TABELLEN_ID]SELPMIDS</code>.
	 * 
	 * @param aClient
	 *            Der Dolphin Client fuer die Registrierung des Listeners.
	 * @param aTableId
	 *            Die ID der Tabellendefinition.
	 */
	@SuppressWarnings("unchecked")
	private void initTableSelectionMode(final ClientDolphin aClient, final String aTableId) {

		// PM "Tabellendefinition"
		String lLookupName = aTableId + TABLE.PM_POSTFIX_DEF;
		final ClientPresentationModel lTableDefPm = aClient.getAt(lLookupName);
		assert lTableDefPm != null : "Das PM mit der Definition von Tabelle '" + lLookupName + "' wurde nicht gefunden";

		// Attribut "Selection Mode"
		lLookupName = TABLE.ATT_SELMODE + TAG.VALUE;
		ClientAttribute lSelModeAttr = lTableDefPm.getAt(lLookupName);
		assert lSelModeAttr != null : "Das Attribut '" + lLookupName + "' zum Festlegen des SelectionModes wurde im PM '"
				+ lTableDefPm.getId() + "' nicht gefunden!";
		final String lSelModeAttrValue = lSelModeAttr.getValue();

		// Attribut "PK Attributsname"
		lLookupName = TABLE.ATT_PK_ATT_NAME + TAG.VALUE;
		ClientAttribute lTableRowPkAttr = lTableDefPm.getAt(lLookupName);
		assert lTableRowPkAttr != null : "Das Attribut '" + lLookupName + "' zum Festlegen des PK Attributs wurde in PM '"
				+ lTableDefPm.getId() + "' nicht gefunden!";
		final String lTableRowPkAttName = lTableRowPkAttr.getValue();
		assert lTableRowPkAttName != null && lTableRowPkAttName.trim().length() > 0 : "Der Wert des Attributs '" + lLookupName
				+ "' ist erforderlich!";

		// single row selection
		if (TABLE.SELECTION_MODE_SINGLE.equals(lSelModeAttrValue)) {
			SelectionModel<ClientPresentationModel> sm = new SingleSelectionModel<ClientPresentationModel>();
			widgetTable.setSelectionModel(sm);

			// Einfachselektion an PM Attribute "weitergeben"
			sm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

				@Override
				public void onSelectionChange(SelectionChangeEvent inEvent) {
					SingleSelectionModel<ClientPresentationModel> selModel = (SingleSelectionModel<ClientPresentationModel>) inEvent
							.getSource();
					ClientPresentationModel selRowPm = selModel.getSelectedObject();
					String selPkVal = selRowPm.getAt(lTableRowPkAttName + TAG.VALUE).getValue();
					lTableDefPm.getAt(TABLE.ATT_SELROWS + TAG.VALUE).setValue(selPkVal);
					lTableDefPm.getAt(TABLE.ATT_SEL_PM_IDS + TAG.VALUE).setValue(selRowPm.getId());
				}
			});
		} else

		// multi row selection
		if (TABLE.SELECTION_MODE_MULTI.equals(lSelModeAttrValue)) {
			SelectionModel<ClientPresentationModel> sm = new MultiSelectionModel<ClientPresentationModel>();
			widgetTable.setSelectionModel(sm);

			// Mehrfachselektion an PM Attribute "weitergeben"
			sm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
				@Override
				public void onSelectionChange(SelectionChangeEvent inEvent) {
					MultiSelectionModel<ClientPresentationModel> selModel = (MultiSelectionModel<ClientPresentationModel>) inEvent
							.getSource();
					StringBuilder selRowsBuilder = new StringBuilder();
					StringBuilder selPmIdsBuilder = new StringBuilder();
					for (ClientPresentationModel currPm : selModel.getSelectedSet()) {
						selRowsBuilder.append(currPm.getAt(lTableRowPkAttName + TAG.VALUE).getValue());
						selRowsBuilder.append(",");
						selPmIdsBuilder.append(currPm.getId());
						selPmIdsBuilder.append(",");
					} // for
					lTableDefPm.getAt(TABLE.ATT_SELROWS + TAG.VALUE).setValue(selRowsBuilder.toString());
				}
			});
		} // else if
	}
}