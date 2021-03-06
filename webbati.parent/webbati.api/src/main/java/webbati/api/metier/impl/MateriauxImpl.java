/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IBibliothequeManager;
import webbati.api.manager.interfaces.IMateriauxManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IMateriaux;

/**
 * Classe <MateriauxImpl>.
 * 
 */
public abstract class MateriauxImpl extends BibliothequeElementImpl implements IMateriaux {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Float prixTarif;
	private Float remise;
	private Integer fournisseurDefautId;
	private List<IFournisseurMateriaux> listFrnMxSaved = null;
	private boolean isListFrnMxUpdated = false;

	@Override
	public Float getPrixTarif() {
		return getValue(prixTarif);
	}

	@Override
	public void setPrixTarif(Float pPrixTarif) {
		prixTarif = pPrixTarif;
	}

	@Override
	public Float getRemise() {
		return getValue(remise);
	}

	@Override
	public void setRemise(Float pRemise) {
		remise = pRemise;
	}

	@Override
	public IFournisseur getFournisseurDefaut() throws WebbatiException {
		return ApplicationWb.getApplication().getFournisseurManager().getById(fournisseurDefautId);
	}

	@Override
	public void setFournisseurDefaut(IFournisseur pFournisseurDefaut) {
		if (pFournisseurDefaut != null) {
			setFournisseurDefautId(pFournisseurDefaut.getId());
		} else {
			setFournisseurDefautId(null);
		}
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux() throws WebbatiException {
		if (isListFrnMxUpdated) {
			return listFrnMxSaved;
		}
		return getMateriauxManager().getListFournisseurMateriaux(this);
	}

	@Override
	public void setListFournisseurMateriaux(List<IFournisseurMateriaux> pListFrnMx) {
		isListFrnMxUpdated = true;
		listFrnMxSaved = pListFrnMx;
	}

	/**
	 * Retourne le champ fournisseurDefautId.
	 * 
	 * @return le fournisseurDefautId
	 */
	public Integer getFournisseurDefautId() {
		return fournisseurDefautId;
	}

	/**
	 * Met à jour le champ fournisseurDefautId.
	 * 
	 * @param pFournisseurDefautId le fournisseurDefautId à mettre à jour
	 */
	public void setFournisseurDefautId(Integer pFournisseurDefautId) {
		fournisseurDefautId = pFournisseurDefautId;
	}

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface Materiaux
	 * @param <TM> interface Materiaux manager
	 * @return manager
	 */
	protected abstract <IT extends IMateriaux, TM extends IMateriauxManager<IT>> TM getMateriauxManager() throws WebbatiException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException {
		return (TM) getMateriauxManager();
	}

}
