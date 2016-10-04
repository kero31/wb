/**
 * 
 */
package common.api.dao.hibernate.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import common.api.dao.hibernate.impl.HibernateDaoImpl;
import common.api.dao.interfaces.ILigneHibernateDaoContainer;
import common.api.dao.interfaces.ILigneWithModificationHibernateDaoContainer;
import common.api.exception.WebbatiException;
import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;

/**
 * 
 * Classe/Interface <b>LigneHibernateDaoUtil</b>
 *
 */
public class LigneHibernateDaoUtil {

	public static final Integer BORNE_GAUCHE_START = 1;
	public static final Integer NIVEAU_START = 1;
	public static final Integer ORDRE_START = 1;
	private final ILigneHibernateDaoContainer containerLigne;
	private ILigneWithModificationHibernateDaoContainer containerModifLigne;

	/**
	 * Constructeur.
	 * 
	 * @param pContainerLigne container d'utilisation de ligne pour une utilisation de récupération de ligne
	 */
	public LigneHibernateDaoUtil(ILigneHibernateDaoContainer pContainerLigne) {
		containerLigne = pContainerLigne;
	}

	/**
	 * Constructeur.
	 * 
	 * @param pContainerModifLigne container d'utilisation de ligne pour une utilisation de récupération de ligne, d'ajout, de modification et de
	 *            suppression
	 */
	public LigneHibernateDaoUtil(ILigneWithModificationHibernateDaoContainer pContainerModifLigne) {
		containerModifLigne = pContainerModifLigne;
		containerLigne = pContainerModifLigne;
	}

	/**
	 * Retourne une liste de ligne EJB à partir du plus haut parent de la ligne.
	 * 
	 * @param pMetier la ligne
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return liste de ligne EJ
	 * @throws WebbatiException
	 */
	private <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> List<ILIGNEEJB> getListEjbFromMetier(ILIGNE pMetier)
	        throws WebbatiException {
		if (pMetier != null) {
			List<ILIGNE> listMetier = new ArrayList<>();
			listMetier.add(getHighLigneFromMetier(pMetier));
			return getListEjbFromListMetier(listMetier);
		}

		return null;
	}

	/**
	 * Retourne l'élément le plus haut à partir de la ligne.
	 * 
	 * @param pMetier la ligne
	 * @param <ILIGNE> ILigne
	 * @return l'élément le plus haut
	 */
	private <ILIGNE extends ILigne<ILIGNE, ?>> ILIGNE getHighLigneFromMetier(ILIGNE pMetier) {
		if (pMetier != null) {
			ILIGNE parent = pMetier.getParent();
			if (parent != null) {
				return getHighLigneFromMetier(parent);
			}
		}
		return pMetier;
	}

	/**
	 * Retourne une liste de lignes EJB à partir d'une liste de lignes.
	 * 
	 * @param pListMetier liste de lignes
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return liste de ligne EJB
	 * @throws WebbatiException
	 */
	public <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> List<ILIGNEEJB> getListEjbFromListMetier(List<ILIGNE> pListMetier)
	        throws WebbatiException {
		return getListEjbFromListMetier(pListMetier, BORNE_GAUCHE_START, NIVEAU_START);
	}

	/**
	 * Retourne une liste de lignes EJB à partir d'une liste de lignes en fonction de la borne gauche, et du niveau.
	 * 
	 * @param pListMetier liste de lignes
	 * @param pBorneGauche borne gauche
	 * @param pNiveau niveau
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return liste de lignes EJB
	 * @throws WebbatiException
	 */
	@SuppressWarnings("unchecked")
	protected <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> List<ILIGNEEJB> getListEjbFromListMetier(List<ILIGNE> pListMetier,
	        Integer pBorneGauche, Integer pNiveau) throws WebbatiException {
		List<ILIGNEEJB> listLigEjb = new ArrayList<>();

		if (pListMetier != null && containerLigne != null) {

			Integer borneGauche = pBorneGauche;
			for (ILIGNE iLigne : pListMetier) {
				// Crée un nouvel EJB
				// Mise à jour des éléments du métier vers l'ejb
				Class<? extends ILigneEjb> clazzEjb = containerLigne.getClassEjbFromMetierImplForLigneDao(iLigne);
				ILIGNEEJB newEjb = (ILIGNEEJB) HibernateDaoImpl.getEjbNewFromMetier(iLigne, clazzEjb);

				// Mise à jour des éléments principaux
				newEjb.setBorneGauche(borneGauche);
				Integer borneDroite = getBorneDroite(iLigne, borneGauche);
				newEjb.setBorneDroite(borneDroite);
				newEjb.setNiveau(pNiveau);
				// Ajout de l'EJB dans la liste finale
				listLigEjb.add(newEjb);

				// Enregistrement des sous ligne de la ligne courante
				listLigEjb.addAll((Collection<? extends ILIGNEEJB>) getListEjbFromListMetier(iLigne.getListLigne(), borneGauche + 1, pNiveau + 1));
				borneGauche = borneDroite + 1;
			}
		}

		return listLigEjb;
	}

	/**
	 * Récupère la borne droite de la ligne pLigneEtude à partir de la borne gauche pBorneGauche.
	 * 
	 * @param pLigne ligne
	 * @param pBorneGauche borne gauche
	 * @param <ILIGNE> ILigne
	 * @return borne droite
	 */
	private <ILIGNE extends ILigne<ILIGNE, ?>> Integer getBorneDroite(ILIGNE pLigne, Integer pBorneGauche) {
		Integer borneDroite = 0;
		if (pLigne != null) {
			if (pLigne.getListLigne().size() == 0) {
				borneDroite = pBorneGauche + 1;
			} else {
				Integer borneGauche = pBorneGauche;
				for (ILIGNE iLigneEtude : pLigne.getListLigne()) {
					borneDroite = getBorneDroite(iLigneEtude, borneGauche + 1);
					borneGauche = borneDroite;
				}
				borneDroite++;
			}
		}
		return borneDroite;
	}

	/**
	 * Retourne une collection d'arbre à partir d'une liste de ligne
	 * 
	 * @param pSetLigneEjb Liste de ligne EJB
	 * @param pClazzReturn classe métier retournée
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return collection d'arbre à partir d'une liste de ligne
	 * @throws WebbatiException WebbatiException
	 */
	public <ILIGNE, ILIGNEEJB extends ILigneEjb> List<ILIGNE> getListFromListLigneEjb(Collection<ILIGNEEJB> pSetLigneEjb, Class<ILIGNE> pClazzReturn)
	        throws WebbatiException {
		List<ILIGNEEJB> listLigneEjb = new ArrayList<>();
		if (pSetLigneEjb != null) {
			listLigneEjb.addAll(pSetLigneEjb);
		}

		return getListFromListLigneEjb(listLigneEjb, pClazzReturn);
	}

	/**
	 * Retourne une collection d'arbre à partir d'une liste de ligne
	 * 
	 * @param pListLigneEjb Liste de ligne EJB
	 * @param pClazzReturn classe métier retournée
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return collection d'arbre à partir d'une liste de ligne
	 * @throws WebbatiException WebbatiException
	 */
	public <ILIGNE, ILIGNEEJB extends ILigneEjb> List<ILIGNE> getListFromListLigneEjb(List<ILIGNEEJB> pListLigneEjb, Class<ILIGNE> pClazzReturn)
	        throws WebbatiException {
		// Tri la liste EJB par BorneGauche
		Collections.sort(pListLigneEjb, new Comparator<ILIGNEEJB>() {

			@Override
			public int compare(ILIGNEEJB pArg0, ILIGNEEJB pArg1) {
				return pArg0.getBorneGauche().compareTo(pArg1.getBorneGauche());
			}
		});

		// Renvoie la collection d'arbre
		return getListFromListLigneEjb(pListLigneEjb, NIVEAU_START, null, null, pClazzReturn, null);
	}

	/**
	 * Retourne une collection d'arbre à partir d'une liste de ligne
	 * 
	 * @param pListLigneEjb Liste de ligne EJB
	 * @param pNiveau niveau
	 * @param pBorneGauche borne gauche
	 * @param pBorneDroite borne droite
	 * @param pClazzReturn classe métier retournée
	 * @param pBibParent objet métier parent
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @param <ILIGNELIST> ILIGNELIST
	 * @return collection d'arbre à partir d'une liste de ligne
	 * @throws WebbatiException WebbatiException
	 */
	@SuppressWarnings("unchecked")
	private <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNELIST, ILIGNEEJB extends ILigneEjb> List<ILIGNELIST> getListFromListLigneEjb(
	        List<ILIGNEEJB> pListLigneEjb, Integer pNiveau, Integer pBorneGauche, Integer pBorneDroite, Class<ILIGNELIST> pClazzReturn,
	        ILIGNE pBibParent) throws WebbatiException {
		List<ILIGNELIST> listLigMetier = new ArrayList<>();

		// Récup de la liste avec ses enfants
		if (pListLigneEjb != null && !pListLigneEjb.isEmpty()) {

			// Recherche de tous les noeuds de 1er niveau
			List<ILIGNEEJB> listNoeud = new ArrayList<>();
			for (ILIGNEEJB ligEjb : pListLigneEjb) {
				if (ligEjb.getNiveau() == pNiveau) {
					boolean bFind = false;
					if (pBorneGauche != null && pBorneDroite != null) {
						if (ligEjb.getBorneGauche() >= pBorneGauche && ligEjb.getBorneDroite() <= pBorneDroite) {
							bFind = true;
						}
					} else {
						bFind = true;
					}

					if (bFind) {
						listNoeud.add(ligEjb);
					}
				}
			}

			// Ordre
			Integer ordre = ORDRE_START;

			// Parcours tous les peres de 1er niveau et crée ses enfants
			for (ILIGNEEJB ligEjb : listNoeud) {
				// Crée un nouvel ITI
				ILIGNE newMetier = null;
				if (containerLigne != null) {
					Class<ILIGNE> clazzMetierImpl = containerLigne.getClassMetierImplFromEjbForLigneDao(ligEjb);
					if (clazzMetierImpl != null) {
						try {
							newMetier = clazzMetierImpl.newInstance();
						} catch (InstantiationException | IllegalAccessException e) {
							throw new WebbatiException("getListFromListLigneEjb : Erreur création new instance Metier Impl");
						}

						// Mise à jour des éléments de l'ejb vers le métier
						HibernateDaoImpl.updateMetierFromEjb(newMetier, ligEjb);

						// Mise à jour des éléments principaux
						newMetier.setOrdre(ordre++);
						newMetier.setParent(pBibParent);
						newMetier.setListLigne((List<ILIGNE>) getListFromListLigneEjb(pListLigneEjb, pNiveau + 1, ligEjb.getBorneGauche(),
						        ligEjb.getBorneDroite(), pClazzReturn, newMetier));

						// Ajout du nouvel objet metier
						listLigMetier.add((ILIGNELIST) newMetier);
					} else {
						throw new WebbatiException("getListFromListLigneEjb : Erreur clazzMetierImpl est NULL, ligEjb_id=" + ligEjb.getId());
					}
				}
			}
		}

		return listLigMetier;
	}

	/**
	 * Retourne une liste de Iligne à partir d'un critère en prenant en compte la colonne parent (superParentId).
	 * 
	 * @param pCriteriaMain critère principal
	 * @param pClazzILigneMetier classe métier de retour
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return liste liste de Iligne
	 * @throws WebbatiException
	 */
	public <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> List<ILIGNE> getList(Criteria pCriteriaMain,
	        Class<ILIGNE> pClazzILigneMetier) throws WebbatiException {
		// Liste globale de tous les métier ligne
		List<ILIGNE> listLigneMetier = new ArrayList<>();

		if (containerModifLigne != null) {
			// Récupère les ejb de 1er niveau
			pCriteriaMain.add(Restrictions.eq("niveau", new Integer(LigneHibernateDaoUtil.NIVEAU_START)));
			List<?> listEjbFound = containerModifLigne.getListEJBGenericForLigneDao(pCriteriaMain);

			// Transforme la liste des ejb trouvée en liste d'ejb de ILigneEjb
			List<ILigneEjb> listEjb = new ArrayList<>();
			if (listEjbFound != null) {
				for (Object ejbFound : listEjbFound) {
					if (ejbFound instanceof ILigneEjb) {
						listEjb.add((ILigneEjb) ejbFound);
					}
				}
			}

			// Pour chaque ejb, charge tous les objets qui lui appartiennent et crée le métier ligne avec ses sous éléments
			if (listEjb != null) {
				for (ILigneEjb ejbPrincipal : listEjb) {
					// Liste globale de tous les ejb
					List<ILigneEjb> listAllEjb = new ArrayList<>();

					// Ajout à la liste globale, l'ejb chargé
					listAllEjb.add(ejbPrincipal);

					// Charge tous les ejb qui lui appartiennent
					Criteria critCurrent = containerModifLigne.getCriteriaSessionForLigneDao()
					        .add(Restrictions.eq("superParentId", ejbPrincipal.getId()))
					        .add(Restrictions.gt("borneGauche", ejbPrincipal.getBorneGauche()))
					        .add(Restrictions.lt("borneDroite", ejbPrincipal.getBorneDroite()));
					List<?> listCurrentEjb = containerModifLigne.getListEJBGenericForLigneDao(critCurrent);
					if (listCurrentEjb != null) {
						for (Object ejbCurrentParent : listCurrentEjb) {
							if (ejbCurrentParent instanceof ILigneEjb) {
								ILigneEjb ligne = (ILigneEjb) ejbCurrentParent;
								listAllEjb.add(ligne);
							}
						}
					}

					// Récupère la liste des métier ligne
					listLigneMetier.addAll(getListFromListLigneEjb(listAllEjb, pClazzILigneMetier));
				}
			}
		}

		return listLigneMetier;
	}

	/**
	 * Supprime les sous éléments de la ligne ejb et la ligne ejb. Ces sous éléments auront le même parentId (colonne : superParentId) que l'id de la
	 * ligne ejb.
	 * 
	 * @param pLigneEjbToDelete ligne ejb
	 * @param <ILIGNEEJB> ILigneEjb
	 * @throws WebbatiException
	 */
	public <ILIGNEEJB extends ILigneEjb> void deleteLigneEjb(ILIGNEEJB pLigneEjbToDelete) throws WebbatiException {
		// Supprime tous les bib rattaché à la bib
		if (pLigneEjbToDelete != null && containerModifLigne != null) {
			Criteria critSousElement = containerModifLigne.getCriteriaSessionForLigneDao()
			        .add(Restrictions.eq("superParentId", pLigneEjbToDelete.getId()))
			        .add(Restrictions.gt("borneGauche", pLigneEjbToDelete.getBorneGauche()))
			        .add(Restrictions.lt("borneDroite", pLigneEjbToDelete.getBorneDroite()));
			List<?> listSousElementFound = containerModifLigne.getListEJBGenericForLigneDao(critSousElement);

			// Transforme la liste des ejb trouvée en liste d'ejb de ILigneEjb
			List<ILigneEjb> listSousElement = new ArrayList<>();
			if (listSousElementFound != null) {
				for (Object ejbFound : listSousElementFound) {
					if (ejbFound instanceof ILigneEjb) {
						listSousElement.add((ILigneEjb) ejbFound);
					}
				}
			}

			// Pour chaque sous élément, supprime les sous lignes
			for (ILigneEjb ejb : listSousElement) {
				containerModifLigne.deleteGenericForLigneDao(ejb.getId(), ejb.getClass());
			}

			// Supprime l'élément courant si besoin
			containerModifLigne.deleteGenericForLigneDao(pLigneEjbToDelete.getId(), pLigneEjbToDelete.getClass());
		}
	}

	/**
	 * Renvoie une liste de métier à partir de l'objet métier et met à jour le parent sur ses sous éléments
	 * 
	 * @param pMetier Objet métier à créer ou à mettre à jour
	 * @param pClazzILigneMetier classe ILIGNE
	 * @param <ILIGNE> ILigne
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return liste de métier
	 * @throws WebbatiException WebbatiException
	 * */
	public <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> List<ILIGNE> getListFromMetierForSaveLigne(ILIGNE pMetier,
	        Class<ILIGNE> pClazzILigneMetier) throws WebbatiException {
		if (pMetier != null && containerModifLigne != null) {
			ILIGNE ligne = pMetier;

			// Récupère la liste des EJB à partir de l'objet métier
			List<ILIGNEEJB> listEjb = getListEjbFromMetier(ligne);
			if (listEjb != null) {
				// Cherche l'EJB du 1er niveau, le supprime ainsi que tous ses éléments et le sauve
				ILIGNEEJB ejbParent = null;
				for (ILIGNEEJB ejb : listEjb) {
					if (ejb.getNiveau() == LigneHibernateDaoUtil.NIVEAU_START) {
						// Défini l'élément de 1er niveau
						ejbParent = ejb;

						// Récupère un objet récent
						ejbParent = getUpdatedLigneEjbFromLigneEjb(ejbParent);

						// Sauve l'élément courant
						containerModifLigne.saveOrUpdateEjbForLigneDao(ejbParent);
					}
				}

				// Supprime les lignes obsolètes
				deleteLigneObsolete(listEjb, ejbParent);

				// Sauve la liste des EJB des sous niveaux en mettant à jour le super parent
				for (ILIGNEEJB ejb : listEjb) {
					// Récupère un objet récent
					ILIGNEEJB ejbToSave = getUpdatedLigneEjbFromLigneEjb(ejb);

					// Met à jour le super parent id
					ejbToSave.setSuperParentId(ejbParent.getId());

					// Sauve l'ejb
					containerModifLigne.saveOrUpdateEjbForLigneDao(ejbToSave);
				}

				// Récupère la liste des objets métier à partir de la liste des ejb sauvées
				return getListFromListLigneEjb(listEjb, pClazzILigneMetier);
			}
		}

		return null;
	}

	/**
	 * Supprime les lignes obsolètes. Ce sont les lignes qui font parties de la table associées au parent et qui ne sont plus utilisées dans la
	 * nouvelle liste d'ejb.
	 * 
	 * @param pNewListEjb nouvelle liste d'ejb
	 * @param pEjbParent le parent
	 * @param <ILIGNEEJB> ILigneEjb
	 * @throws WebbatiException
	 */
	private <ILIGNEEJB extends ILigneEjb> void deleteLigneObsolete(List<ILIGNEEJB> pNewListEjb, ILIGNEEJB pEjbParent) throws WebbatiException {
		// Supprime tous les bib rattaché à la bib
		if (pNewListEjb != null && pEjbParent != null && containerModifLigne != null) {
			Criteria critSousElement = containerModifLigne.getCriteriaSessionForLigneDao().add(Restrictions.eq("superParentId", pEjbParent.getId()));
			List<?> listSousElementFound = containerModifLigne.getListEJBGenericForLigneDao(critSousElement);

			// Transforme la liste des ejb trouvée en liste d'ejb de ILigneEjb
			List<ILIGNEEJB> listSousElement = new ArrayList<>();
			if (listSousElementFound != null) {
				for (Object ejbFound : listSousElementFound) {
					if (ejbFound instanceof ILigneEjb) {
						@SuppressWarnings("unchecked")
						ILIGNEEJB ejbFoundLigne = (ILIGNEEJB) ejbFound;
						listSousElement.add(ejbFoundLigne);
					}
				}
			}

			// Trasnforme la nouvelle liste d'ejb en liste d'id
			List<Integer> newListEjbId = new ArrayList<>();
			for (ILIGNEEJB ejb : pNewListEjb) {
				Integer id = ejb.getId();
				if (id != null) {
					newListEjbId.add(id);
				}
			}

			// Pour chaque élément, supprime les sous lignes
			for (ILIGNEEJB ejb : listSousElement) {
				Integer id = ejb.getId();
				if (id != null && !newListEjbId.contains(id)) {
					containerModifLigne.deleteGenericForLigneDao(id, ejb.getClass());
				}
			}
		}
	}

	/**
	 * Retourne un nouvel ejb mis à jour avec la dernière session.
	 * 
	 * @param pNewLigneEjb ejb qui doit être mis à jour
	 * @param <ILIGNEEJB> ILigneEjb
	 * @return nouvel ejb
	 * @throws WebbatiException
	 */
	private <ILIGNEEJB extends ILigneEjb> ILIGNEEJB getUpdatedLigneEjbFromLigneEjb(ILIGNEEJB pNewLigneEjb) throws WebbatiException {
		ILIGNEEJB newLigneEjb = pNewLigneEjb;
		if (newLigneEjb != null && newLigneEjb.getId() != null && containerModifLigne != null) {
			@SuppressWarnings("unchecked")
			ILIGNEEJB ejbNew = (ILIGNEEJB) containerModifLigne.getSessionForLigneDao().get(newLigneEjb.getClass(), newLigneEjb.getId());
			ejbNew.setBorneDroite(newLigneEjb.getBorneDroite());
			ejbNew.setBorneGauche(newLigneEjb.getBorneGauche());
			ejbNew.setNiveau(newLigneEjb.getNiveau());
			ejbNew.setSuperParentId(newLigneEjb.getSuperParentId());
			newLigneEjb = ejbNew;
		}
		return newLigneEjb;
	}

	/**
	 * Retourne l'objet correspondant à l'id.
	 * 
	 * @param <ILIGNE> ILigne
	 * @param pId id
	 * @param pClazzILigne classe interfacede l'objet de retour
	 * @return objet
	 * @throws WebbatiException
	 */
	public <ILIGNE extends ILigne<ILIGNE, ?>> ILIGNE getById(Integer pId, Class<ILIGNE> pClazzILigne) throws WebbatiException {
		// Liste globale de tous les métier ligne de l'objet
		if (pId != null && containerModifLigne != null) {
			Criteria crit = containerModifLigne.getCriteriaSessionForLigneDao();
			crit.add(Restrictions.eq("id", pId));
			List<ILIGNE> listRet = getList(crit, pClazzILigne);
			if (listRet != null && listRet.size() == 1) {
				// Nouvel objet
				return listRet.get(0);
			}
		}
		return null;
	}
}
