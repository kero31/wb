/**
 * 
 */
package webbati.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IAffaireDao;
import webbati.api.dao.interfaces.IEcheancierDao;
import webbati.api.dao.interfaces.IEtudeDao;
import webbati.api.manager.interfaces.IAffaireManager;
import webbati.api.manager.interfaces.IEcheancierManager;
import webbati.api.manager.interfaces.IEtudeManager;
import webbati.api.metier.impl.AffaireImpl;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IAffaireDevis;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEtude;

/**
 * 
 * Classe/Interface <b>AffaireManagerImpl</b><br/>
 *
 * @param <IT> IAffaire
 */
public abstract class AffaireManagerImpl<IT extends IAffaire> extends BfGenericManagerImpl<IT, Integer> implements IAffaireManager<IT> {

	/** L'étude DAO. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EtudeDao")
	private IEtudeDao etudeDao;

	/** L'écheancier DAO. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierDao")
	private IEcheancierDao echeancierDao;

	/** Le echeancierManager. */
	@Resource(name = ApplicationWb.CODE_PROJECT + "_EcheancierManager")
	private IEcheancierManager echeancierManager;

	@Override
	public List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws WebbatiException {
		return getListDaoFromObject(pAffaire, ((IAffaireDao<IT>) getDao()).getListEcheancier(pAffaire));
	}

	@Override
	public List<IEtude> getListEtude(IAffaire pAffaire) throws WebbatiException {
		return getListDaoFromObject(pAffaire, ((IAffaireDao<IT>) getDao()).getListEtude(pAffaire));
	}

	@Override
	public <AFF extends IAffaire> AFF getClone(IT pAffaireOrigin, AFF pNewAffaireDest) throws WebbatiException {
		if (pAffaireOrigin != null && pNewAffaireDest != null) {
			pNewAffaireDest.setChantier(pAffaireOrigin.getChantier());
			pNewAffaireDest.setClient(pAffaireOrigin.getClient());
			pNewAffaireDest.setCode(pAffaireOrigin.getCode());
			pNewAffaireDest.setConclusion(pAffaireOrigin.getConclusion());
			pNewAffaireDest.setDateCloture(pAffaireOrigin.getDateCloture());
			pNewAffaireDest.setDateDebTravaux(pAffaireOrigin.getDateDebTravaux());
			pNewAffaireDest.setDateFinTravaux(pAffaireOrigin.getDateFinTravaux());
			pNewAffaireDest.setDescriptif(pAffaireOrigin.getDescriptif());
			pNewAffaireDest.setDureeValidite(pAffaireOrigin.getDureeValidite());
			pNewAffaireDest.setEtat(pAffaireOrigin.getEtat());
			pNewAffaireDest.setIntroduction(pAffaireOrigin.getIntroduction());
			pNewAffaireDest.setMetre(pAffaireOrigin.getMetre());
			pNewAffaireDest.setNotes(pAffaireOrigin.getNotes());
			pNewAffaireDest.setReference(pAffaireOrigin.getReference());
			pNewAffaireDest.setTermine(pAffaireOrigin.isTermine());
			pNewAffaireDest.setValide(pAffaireOrigin.isValide());

			// Etude
			List<IEtude> listEtudeOrigine = pAffaireOrigin.getListEtude();
			List<IEtude> listEtudeDest = new ArrayList<>();
			for (IEtude iEtude : listEtudeOrigine) {
				listEtudeDest.add(iEtude.getClone(pNewAffaireDest));
			}
			if (pNewAffaireDest instanceof AffaireImpl) {
				((AffaireImpl) pNewAffaireDest).setListEtude(listEtudeDest);
			}

			// Echeancier
			List<IEcheancier> listEcheancierOrigin = pAffaireOrigin.getListEcheancier();
			List<IEcheancier> listEcheancierDest = new ArrayList<>();
			for (IEcheancier iEcheancier : listEcheancierOrigin) {
				listEcheancierDest.add(iEcheancier.getClone(pNewAffaireDest));
			}
			if (pNewAffaireDest instanceof AffaireImpl) {
				((AffaireImpl) pNewAffaireDest).setListEcheancier(listEcheancierDest);
			}

			// Si le cloneage se fait sur des instances de IAffaireDevis, alors on copie aussi le lien vers le devis
			if (pAffaireOrigin instanceof IAffaireDevis && pNewAffaireDest instanceof IAffaireDevis) {
				IAffaireDevis affDevisOrigin = (IAffaireDevis) pAffaireOrigin;
				IAffaireDevis affDevisDest = (IAffaireDevis) pNewAffaireDest;
				affDevisDest.setDevis(affDevisOrigin.getDevis());
			}
		}
		return pNewAffaireDest;
	}

	@Override
	public IT save(IT pAffaire) throws WebbatiException {
		// Enregistre le nouvel objet
		IT affaire = super.save(pAffaire);

		// Etude
		if (pAffaire.isListEtudeChanged()) {
			// Récupère la nouvelle liste
			List<IEtude> listEtudeNew = pAffaire.getListEtude();

			// Récupère l'ancienne liste
			List<IEtude> listEtudeActual = affaire.getListEtude();

			// Supprime les éléments qui ne sont plus utilisés
			deleteMetierFromNewListMetier(listEtudeActual, listEtudeNew, etudeDao);

			// Save des Etudes
			IEtudeManager etudeMng = ApplicationWb.getApplication().getEtudeManager();
			for (IEtude etude : listEtudeNew) {
				etude.setAffaire(affaire);
				etudeMng.save(etude);
			}
		}

		// Echeancier
		if (pAffaire.isListEcheancierChanged()) {
			// Récupère la nouvelle liste
			List<IEcheancier> listEcheancierNew = pAffaire.getListEcheancier();

			// Récupère l'ancienne liste
			List<IEcheancier> listEcheancierActual = affaire.getListEcheancier();

			// Supprime les éléments qui ne sont plus utilisés
			deleteMetierFromNewListMetier(listEcheancierActual, listEcheancierNew, echeancierDao);

			// Save des Echeancier
			IEcheancierManager echeancierMng = ApplicationWb.getApplication().getEcheancierManager();
			for (IEcheancier echeancier : listEcheancierNew) {
				echeancier.setAffaire(affaire);
				echeancierMng.save(echeancier);
			}
		}

		return affaire;
	}

}
