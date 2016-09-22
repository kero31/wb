/**
 * 
 */
package batifree.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.dao.interfaces.IBibliothequeDao;
import batifree.api.manager.interfaces.IBibliothequeManager;
import batifree.api.metier.interfaces.IBibEltBib;
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IBibliothequeElement;
import batifree.api.metier.interfaces.IEngin;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.ILot;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;
import batifree.api.metier.interfaces.IMainOeuvre;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;
import batifree.api.metier.interfaces.IMateriaux;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;
import batifree.api.metier.interfaces.ISousTraitant;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;
import batifree.api.metier.interfaces.ITva;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>BibliothequeManagerImpl</b><br/>
 *
 * @param <IT> IBibliotheque
 */
public abstract class BibliothequeManagerImpl<IT extends IBibliotheque> extends BfGenericManagerImpl<IT, Integer> implements
        IBibliothequeManager<IT> {

	@Override
	public <BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest) throws BatifreeException {
		return getClone(pBibOrigin, pBibNewDest, false);
	}

	@Override
	public <BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest, Boolean pIsUseForImport) throws BatifreeException {
		BIBD bibDest = getCloneBib(pBibOrigin, pBibNewDest);
		if (pIsUseForImport && bibDest instanceof IBibEltBib && pBibOrigin instanceof IBibEltBib) {
			IBibEltBib bibDestBib = (IBibEltBib) bibDest;
			IBibEltBib bibOriginBib = (IBibEltBib) pBibOrigin;
			bibDestBib.setElementOrigin(bibOriginBib);
		}
		return bibDest;
	}

	@Override
	@Deprecated
	public <BIBD extends IBibliotheque> BIBD getClone(IT pBibOrigin, BIBD pBibNewDest, IT pParentDest) throws BatifreeException {
		BIBD bibDest = getCloneBib(pBibOrigin, pBibNewDest);
		bibDest.setParent(pParentDest);
		return bibDest;
	}

	/**
	 * Retourne le clone de l'objet de bib origine en mettant à jour une nouvelle instance de bib destination
	 * 
	 * @param <BIBD> Bibliotheque destination
	 * @param pBibOrigin Bib Origin
	 * @param pBibNewDest Nouvelle instance de Bib Dest
	 * @return clone à partir de l'objet bib origine
	 * @throws BatifreeException BatifreeException
	 */
	private <BIBD extends IBibliotheque> BIBD getCloneBib(IBibliotheque pBibOrigin, BIBD pBibNewDest) throws BatifreeException {
		if (pBibOrigin instanceof IEngin && pBibNewDest instanceof IEngin) {
			return getCloneBibEngin((IEngin) pBibOrigin, (IEngin) pBibNewDest);
		} else if (pBibOrigin instanceof IMateriaux && pBibNewDest instanceof IMateriaux) {
			return getCloneBibMateriaux((IMateriaux) pBibOrigin, (IMateriaux) pBibNewDest);
		} else if (pBibOrigin instanceof ITache && pBibNewDest instanceof ITache) {
			return getCloneBibTache((ITache) pBibOrigin, (ITache) pBibNewDest);
		}

		return getCloneBibElement(pBibOrigin, pBibNewDest);
	}

	/**
	 * Retourne le clone de l'objet de Engin origine en mettant à jour une nouvelle instance de Engin destination
	 * 
	 * @param <BIBD> Bibliotheque destination
	 * @param pBibOrigin Engin Origin
	 * @param pBibNewDest Nouvelle instance de Engin Dest
	 * @return clone à partir de l'objet Engin origine
	 * @throws BatifreeException BatifreeException
	 */
	@SuppressWarnings("unchecked")
	private <BIBD extends IEngin> BIBD getCloneBibEngin(IEngin pBibOrigin, IEngin pBibNewDest) throws BatifreeException {
		IEngin bibNewDest = null;
		if (pBibOrigin != null && pBibNewDest != null) {
			bibNewDest = getCloneBibElement(pBibOrigin, pBibNewDest);

			bibNewDest.setImmatriculation(pBibOrigin.getImmatriculation());
			bibNewDest.setImmatriculationDate(pBibOrigin.getImmatriculationDate());
		}
		return (BIBD) bibNewDest;
	}

	/**
	 * Retourne le clone de l'objet de Materiaux origine en mettant à jour une nouvelle instance de Materiaux destination.
	 * 
	 * @param <BIBD> Bibliotheque destination
	 * @param pBibOrigin Materiaux Origin
	 * @param pBibNewDest Nouvelle instance de Materiaux Dest
	 * @return clone à partir de l'objet Materiaux origine
	 * @throws BatifreeException BatifreeException
	 */
	@SuppressWarnings("unchecked")
	private <BIBD extends IMateriaux> BIBD getCloneBibMateriaux(IMateriaux pBibOrigin, IMateriaux pBibNewDest) throws BatifreeException {
		IMateriaux bibNewDest = null;
		if (pBibOrigin != null && pBibNewDest != null) {
			bibNewDest = getCloneBibElement(pBibOrigin, pBibNewDest);

			bibNewDest.setRemise(pBibOrigin.getRemise());
			bibNewDest.setPrixTarif(pBibOrigin.getPrixTarif());
			bibNewDest.setFournisseurDefaut(pBibOrigin.getFournisseurDefaut());

			List<IFournisseurMateriaux> listNewFrnMx = new ArrayList<>();
			List<IFournisseurMateriaux> listFrnMx = pBibOrigin.getListFournisseurMateriaux();
			if (listFrnMx != null) {
				for (IFournisseurMateriaux iFournisseurMateriaux : listFrnMx) {
					listNewFrnMx.add(getClone(iFournisseurMateriaux, bibNewDest));
				}
			}
		}
		return (BIBD) bibNewDest;
	}

	/**
	 * Retourne le clone de l'objet de Tache origine en mettant à jour une nouvelle instance de Tache destination
	 * 
	 * @param <BIB> Bibliotheque
	 * @param pBibOrigin Tache Origin
	 * @param pBibNewDest Nouvelle instance de Tache Dest
	 * @return clone à partir de l'objet Tache origine
	 * @throws BatifreeException BatifreeException
	 */
	@SuppressWarnings("unchecked")
	private <BIB extends ITache> BIB getCloneBibTache(ITache pBibOrigin, ITache pBibNewDest) throws BatifreeException {
		ITache bibNewDest = null;
		if (pBibOrigin != null && pBibNewDest != null) {
			bibNewDest = getCloneBibElement(pBibOrigin, pBibNewDest);

			bibNewDest.setPrixVenteFixe(pBibOrigin.isPrixVenteFixe());
			bibNewDest.setFraisGenerauxMx(pBibOrigin.getFraisGenerauxMx());
			bibNewDest.setBeneficeMx(pBibOrigin.getBeneficeMx());
			bibNewDest.setFraisGenerauxMo(pBibOrigin.getFraisGenerauxMo());
			bibNewDest.setBeneficeMo(pBibOrigin.getBeneficeMo());
			bibNewDest.setFraisGenerauxSt(pBibOrigin.getFraisGenerauxSt());
			bibNewDest.setBeneficeSt(pBibOrigin.getBeneficeSt());
			bibNewDest.setFraisGenerauxEng(pBibOrigin.getFraisGenerauxEng());
			bibNewDest.setBeneficeEng(pBibOrigin.getBeneficeEng());
		}
		return (BIB) bibNewDest;
	}

	/**
	 * Retourne le clone de l'objet de Materiaux origine en mettant à jour une nouvelle instance de Materiaux destination.
	 * 
	 * @param pFrnMxOrigin FournisseurMateriaux Origin
	 * @param pMxDest Materiaux dest
	 * @return clone à partir de l'objet FournisseurMateriaux origine
	 * @throws BatifreeException
	 */
	private IFournisseurMateriaux getClone(IFournisseurMateriaux pFrnMxOrigin, IMateriaux pMxDest) throws BatifreeException {
		IFournisseurMateriaux frnbMx = ApplicationBf.getApplication().getFactory().createNewInstance(IFournisseurMateriaux.class);
		frnbMx.setFournisseur(pFrnMxOrigin.getFournisseur());
		// frnbMx.setMateriaux(pMxDest);
		frnbMx.setPrixTarif(pFrnMxOrigin.getPrixTarif());
		frnbMx.setQuantiteMini(pFrnMxOrigin.getQuantiteMini());
		frnbMx.setRemise(pFrnMxOrigin.getRemise());
		return frnbMx;
	}

	/**
	 * Retourne le clone de l'objet de bib origine en mettant à jour une nouvelle instance de bib destination
	 * 
	 * @param <BIBD> Bibliotheque destination
	 * @param pBibOrigin Bib Origin
	 * @param pBibNewDest Nouvelle instance de Bib Dest
	 * @return clone à partir de l'objet bib origine
	 * @throws BatifreeException BatifreeException
	 */
	protected <BIBD extends IBibliotheque> BIBD getCloneBibElement(IBibliotheque pBibOrigin, BIBD pBibNewDest) throws BatifreeException {
		if (pBibOrigin != null && pBibNewDest != null) {
			// Clone l'objet pBibOrigin -> pBibNewDest

			// Si les 2 objets sont de type Etude, alors on copie les infos spécifiques
			if ((pBibOrigin instanceof IBibEltEtude) && (pBibNewDest instanceof IBibEltEtude)) {
				IBibEltEtude bibEtudeOrigin = (IBibEltEtude) pBibOrigin;
				IBibEltEtude bibEtudeDest = (IBibEltEtude) pBibNewDest;
				bibEtudeDest.setEtude(bibEtudeOrigin.getEtude());
				bibEtudeDest.setMetre(bibEtudeOrigin.getMetre());
			}

			// Si les 2 objets sont de type Bib, alors on copie les infos spécifiques
			if ((pBibOrigin instanceof IBibEltBib) && (pBibNewDest instanceof IBibEltBib)) {
				IBibEltBib bibOrigin = (IBibEltBib) pBibOrigin;
				IBibEltBib bibDest = (IBibEltBib) pBibNewDest;
				bibDest.setElementOrigin(bibOrigin.getElementOrigin());
			}

			// Si les 2 objets sont de type IBibliothequeElement, alors on copie les infos spécifiques
			if ((pBibOrigin instanceof IBibliothequeElement) && (pBibNewDest instanceof IBibliothequeElement)) {
				IBibliothequeElement bibEtudeOrigin = (IBibliothequeElement) pBibOrigin;
				IBibliothequeElement bibEtudeDest = (IBibliothequeElement) pBibNewDest;
				bibEtudeDest.setBarCode(bibEtudeOrigin.getBarCode());
				bibEtudeDest.setBenefice(bibEtudeOrigin.getBenefice());
				bibEtudeDest.setFraisGeneraux(bibEtudeOrigin.getFraisGeneraux());
				bibEtudeDest.setNumSerie(bibEtudeOrigin.getNumSerie());
				bibEtudeDest.setPrixAchatUnitaire(bibEtudeOrigin.getPrixAchatUnitaire());
			}

			pBibNewDest.setCode(pBibOrigin.getCode());
			pBibNewDest.setDescriptif(pBibOrigin.getDescriptif());
			pBibNewDest.setDescriptionCommerciale(pBibOrigin.getDescriptionCommerciale());
			pBibNewDest.setDescriptionTechnique(pBibOrigin.getDescriptionTechnique());
			pBibNewDest.setFamille(pBibOrigin.getFamille());
			pBibNewDest.setImage(pBibOrigin.getImage());
			pBibNewDest.setMotCle(pBibOrigin.getMotCle());
			pBibNewDest.setNotes(pBibOrigin.getNotes());
			pBibNewDest.setTva(pBibOrigin.getTva());
			pBibNewDest.setUnite(pBibOrigin.getUnite());
			pBibNewDest.setQuantite(pBibOrigin.getQuantite());

			// Clone les enfants de pBibOrigin
			getCloneSubComposition(pBibOrigin, pBibNewDest);
		}

		return pBibNewDest;
	}

	/**
	 * Retourne le clone de l'objet de Composition origine en mettant à jour une nouvelle instance de Composition destination mais que ses sous
	 * tâches.
	 * 
	 * @param <BIBD> Bibliotheque destination
	 * @param pBibOrigin Composition Origin
	 * @param pBibNewDest Nouvelle instance de Composition Dest
	 * @return clone à partir de l'objet Composition origine
	 * @throws BatifreeException BatifreeException
	 */
	private <BIBD extends IBibliotheque> BIBD getCloneSubComposition(BIBD pBibOrigin, BIBD pBibNewDest) throws BatifreeException {
		if (pBibOrigin != null && pBibNewDest != null) {

			List<IBibliotheque> listLigneDest = new ArrayList<>();
			for (IBibliotheque sousBibOrigin : pBibOrigin.getListLigne()) {
				Class<? extends IBibliotheque> sousBibDestClazz = null;

				// Engin
				if (sousBibOrigin instanceof IEngin) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = IEnginEtude.class;
					} else {
						sousBibDestClazz = IEnginBib.class;
					}
				}

				// Materiaux
				if (sousBibOrigin instanceof IMateriaux) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = IMateriauxEtude.class;
					} else {
						sousBibDestClazz = IMateriauxBib.class;
					}
				}

				// MainOeuvre
				if (sousBibOrigin instanceof IMainOeuvre) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = IMainOeuvreEtude.class;
					} else {
						sousBibDestClazz = IMainOeuvreBib.class;
					}
				}

				// SousTraitant
				if (sousBibOrigin instanceof ISousTraitant) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = ISousTraitantEtude.class;
					} else {
						sousBibDestClazz = ISousTraitantBib.class;
					}
				}

				// Tache
				if (sousBibOrigin instanceof ITache) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = ITacheEtude.class;
					} else {
						sousBibDestClazz = ITacheBib.class;
					}
				}

				// Lot
				if (sousBibOrigin instanceof ILot) {
					if (pBibNewDest instanceof IBibEltEtude) {
						sousBibDestClazz = ILotEtude.class;
					} else {
						sousBibDestClazz = ILotBib.class;
					}
				}

				// Clone l'élément sous bib origin
				if (sousBibDestClazz != null) {
					IBibliotheque sousBibDest = ApplicationBf.getApplication().getFactory().createNewInstance(sousBibDestClazz);
					if (sousBibDest != null) {
						getCloneBib(sousBibOrigin, sousBibDest);
						listLigneDest.add(sousBibDest);
					}
				}
			}
			pBibNewDest.setListLigne(listLigneDest);
		}

		return pBibNewDest;
	}

	/**
	 * Retourne la liste des tâches parente à partir de l'objet de la bib
	 * 
	 * @param pBib objet de la bib
	 * @return liste des tâches parente
	 * @throws BatifreeException
	 */
	public List<ITache> getListTacheParente(IT pBib) throws BatifreeException {
		return ((IBibliothequeDao<IT>) getDao()).getListTacheParente(pBib);
	}

	@Override
	public IT getBibEltUpdated(IT pBibEltOrigin) {
		@SuppressWarnings("unchecked")
		IT bibEltOrigin = (IT) getBibEltUpdatedGeneric(pBibEltOrigin, pBibEltOrigin);
		return bibEltOrigin;
	}

	/**
	 * Met à jour sur l'élément courant et sur tous ses sous éléments, les prix, ....
	 * 
	 * @param pBibEltOrigin élément qui est utilisé pour mettre à jour tous les sous éléments
	 * @param pBibEltToUpdate l'élément courant
	 * @return l'élément courant mis à jour
	 */
	private IBibliotheque getBibEltUpdatedGeneric(IBibliotheque pBibEltOrigin, IBibliotheque pBibEltToUpdate) {
		if (pBibEltToUpdate != null) {
			List<IBibliotheque> listLigneBib = pBibEltToUpdate.getListLigne();
			if (listLigneBib != null) {
				for (IBibliotheque bibLigne : listLigneBib) {
					getBibEltUpdatedGeneric(pBibEltOrigin, bibLigne);
				}
			}
			pBibEltToUpdate.setQuantite(pBibEltOrigin.getQuantite());
			if (pBibEltToUpdate instanceof IBibliothequeElement) {
				IBibliothequeElement bibElt = (IBibliothequeElement) pBibEltToUpdate;
				bibElt.setBenefice(pBibEltOrigin.getBenefice());
				bibElt.setFraisGeneraux(pBibEltOrigin.getFraisGeneraux());
				bibElt.setPrixAchatUnitaire(pBibEltOrigin.getPrixAchatUnitaire());
			}
		}
		return pBibEltToUpdate;
	}

	@Override
	public IT getBibEltUpdatedForTVA(IT pBibEltOrigin, ITva pTva) {
		@SuppressWarnings("unchecked")
		IT bibEltOrigin = (IT) getBibEltUpdatedForTVAGeneric(pBibEltOrigin, pTva);
		return bibEltOrigin;
	}

	/**
	 * Met à jour sur l'élément courant et sur tous ses sous éléments, la nouvelle TVA.
	 * 
	 * @param pBibEltToUpdate l'élément courant
	 * @param pTva nouvelle TVA
	 * @return l'élément courant mis à jour
	 */
	private IBibliotheque getBibEltUpdatedForTVAGeneric(IBibliotheque pBibEltToUpdate, ITva pTva) {
		if (pBibEltToUpdate != null) {
			List<IBibliotheque> listLigneBib = pBibEltToUpdate.getListLigne();
			if (listLigneBib != null) {
				for (IBibliotheque bibLigne : listLigneBib) {
					getBibEltUpdatedForTVAGeneric(bibLigne, pTva);
				}
			}
			pBibEltToUpdate.setTva(pTva);
		}
		return pBibEltToUpdate;
	}

	@Override
	public <BIB extends IBibliotheque> BIB saveLigne(IT pObjectMetier) throws BatifreeException {
		return ((IBibliothequeDao<IT>) getMainDao()).saveLigne(pObjectMetier);
	}

	@Override
	public List<IT> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException {
		return ((IBibliothequeDao<IT>) getMainDao()).getList(pMaxResult, pFirstResult, pWithChildren);
	}

	@Override
	public List<IT> getList(boolean pWithChildren) throws BatifreeException {
		return ((IBibliothequeDao<IT>) getMainDao()).getList(NB_ROW_DEFAULT, 0, pWithChildren);
	}

	@Override
	public List<IT> getList(int pMaxResult, int pFirstResult) throws BatifreeException {
		return getList(pMaxResult, pFirstResult, false);
	}

	@Override
	public IT getWithChildren(IT pObject) throws BatifreeException {
		return refresh(pObject);
	}

}
