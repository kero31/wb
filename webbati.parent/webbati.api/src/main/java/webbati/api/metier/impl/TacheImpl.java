/**
 * 
 */
package webbati.api.metier.impl;

import common.api.exception.WebbatiException;
import webbati.api.manager.interfaces.IBibliothequeManager;
import webbati.api.manager.interfaces.ITacheManager;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.ITache;

/**
 * Classe <TacheImpl>.
 * 
 */
public abstract class TacheImpl extends BibliothequeElementImpl implements ITache {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Float beneficeEng;
	private Float beneficeMo;
	private Float beneficeMx;
	private Float beneficeSt;
	private Float fraisGenerauxEng;
	private Float fraisGenerauxMo;
	private Float fraisGenerauxMx;
	private Float fraisGenerauxSt;
	private Boolean prixVenteFixe;
	private Boolean isLot;

	/**
	 * Constructeur.
	 */
	public TacheImpl() {
		super();
		isLot = false;
	}

	/**
	 * Retourne TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 * 
	 * @return TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 */
	public Boolean getIsLot() {
		return isLot;
	}

	/**
	 * Set is lot
	 * 
	 * @param pIsLot TRUE si élément bib est un Lot, FALSE si élément bib est une tâche
	 */
	public void setIsLot(Boolean pIsLot) {
		this.isLot = pIsLot;
	}

	@Override
	public Boolean isPrixVenteFixe() {
		return getValue(prixVenteFixe);
	}

	/**
	 * Return Prix vente fixe.
	 * 
	 * @return Prix vente fixe
	 */
	public Boolean getPrixVenteFixe() {
		return prixVenteFixe;
	}

	@Override
	public void setPrixVenteFixe(Boolean pPrixVenteFixe) {
		prixVenteFixe = pPrixVenteFixe;
	}

	@Override
	public Float getFraisGenerauxMx() {
		return fraisGenerauxMx;
	}

	@Override
	public void setFraisGenerauxMx(Float pFraisGenerauxMx) {
		fraisGenerauxMx = pFraisGenerauxMx;
	}

	@Override
	public Float getBeneficeMx() {
		return beneficeMx;
	}

	@Override
	public void setBeneficeMx(Float pBeneficeMx) {
		beneficeMx = pBeneficeMx;
	}

	@Override
	public Float getFraisGenerauxMo() {
		return fraisGenerauxMo;
	}

	@Override
	public void setFraisGenerauxMo(Float pFraisGenerauxMo) {
		fraisGenerauxMo = pFraisGenerauxMo;
	}

	@Override
	public Float getBeneficeMo() {
		return beneficeMo;
	}

	@Override
	public void setBeneficeMo(Float pBeneficeMo) {
		beneficeMo = pBeneficeMo;
	}

	@Override
	public Float getFraisGenerauxSt() {
		return fraisGenerauxSt;
	}

	@Override
	public void setFraisGenerauxSt(Float pFraisGenerauxSt) {
		fraisGenerauxSt = pFraisGenerauxSt;
	}

	@Override
	public Float getBeneficeSt() {
		return beneficeSt;
	}

	@Override
	public void setBeneficeSt(Float pBeneficeSt) {
		beneficeSt = pBeneficeSt;
	}

	@Override
	public Float getFraisGenerauxEng() {
		return fraisGenerauxEng;
	}

	@Override
	public void setFraisGenerauxEng(Float pFraisGenerauxEng) {
		fraisGenerauxEng = pFraisGenerauxEng;
	}

	@Override
	public Float getBeneficeEng() {
		return beneficeEng;
	}

	@Override
	public void setBeneficeEng(Float pBeneficeEng) {
		beneficeEng = pBeneficeEng;
	}

	/**
	 * Retourne le manager.
	 * 
	 * @param <IT> interface Tache
	 * @param <TM> interface Tache manager
	 * @throws WebbatiException WebbatiException
	 * @return manager
	 */
	protected abstract <IT extends ITache, TM extends ITacheManager<IT>> TM getTacheManager() throws WebbatiException;

	@SuppressWarnings("unchecked")
	@Override
	public <IT extends IBibliotheque, TM extends IBibliothequeManager<IT>> TM getManager() throws WebbatiException {
		return (TM) getTacheManager();
	}

	@Override
	public Float getTempsUnitaire() {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}

	@Override
	public Float[] getDebourseParType() {
		// TODO Attente Didier pour méthode de calcul
		return null;
	}

}
