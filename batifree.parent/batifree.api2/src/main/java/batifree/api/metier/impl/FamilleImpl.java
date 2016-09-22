/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFamille;

import common.api.exception.BatifreeException;
import common.api.metier.impl.LigneImpl;

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
	public List<IBibliotheque> getListBibliotheque() throws BatifreeException {
		return ApplicationBf.getApplication().getFamilleManager().getListBibliotheque(this);
	}

	@Override
	protected List<IFamille> getListLigneFromManager() throws BatifreeException {
		IFamille famille = ApplicationBf.getApplication().getFamilleManager().getWithChildren(this);
		if (famille != null) {
			return famille.getListLigne();
		}
		return null;
	}

}
