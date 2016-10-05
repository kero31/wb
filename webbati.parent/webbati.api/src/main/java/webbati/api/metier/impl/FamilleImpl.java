/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import common.api.metier.impl.LigneImpl;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IFamille;

/**
 * Classe <FamilleImpl>.
 * 
 */
public class FamilleImpl extends LigneImpl<IFamille, Integer> implements IFamille {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private Short type;
	private String descriptif;

	@Override
	public Short getType() {
		return getValue(type);
	}

	@Override
	public void setType(Short pType) {
		type = pType;
	}

	@Override
	public String getDescriptif() {
		return descriptif;
	}

	@Override
	public void setDescriptif(String pDescriptif) {
		descriptif = pDescriptif;
	}

	@Override
	public List<IBibliotheque> getListBibliotheque() throws WebbatiException {
		return ApplicationWb.getApplication().getFamilleManager().getListBibliotheque(this);
	}

	@Override
	protected List<IFamille> getListLigneFromManager() throws WebbatiException {
		IFamille famille = ApplicationWb.getApplication().getFamilleManager().getWithChildren(this);
		if (famille != null) {
			return famille.getListLigne();
		}
		return null;
	}

}
