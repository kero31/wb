package batifree.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.application.interfaces.IFactoryBf;
import batifree.api.dao.interfaces.IBibliothequeDao;
import batifree.api.metier.ejb.Bibliotheque;
import batifree.api.metier.ejb.EnginBib;
import batifree.api.metier.ejb.EnginEtude;
import batifree.api.metier.ejb.MainoeuvreBib;
import batifree.api.metier.ejb.MainoeuvreEtude;
import batifree.api.metier.ejb.MateriauxBib;
import batifree.api.metier.ejb.MateriauxEtude;
import batifree.api.metier.ejb.SoustraitantBib;
import batifree.api.metier.ejb.SoustraitantEtude;
import batifree.api.metier.ejb.TacheLot;
import batifree.api.metier.ejb.TacheLotBib;
import batifree.api.metier.ejb.TacheLotEtude;
import batifree.api.metier.impl.BibliothequeImpl;
import batifree.api.metier.impl.TacheBibImpl;
import batifree.api.metier.interfaces.IBibEltBib;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;
import batifree.api.metier.interfaces.ITache;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;

import common.api.dao.hibernate.util.LigneHibernateDaoUtil;
import common.api.dao.interfaces.ILigneWithModificationHibernateDaoContainer;
import common.api.exception.BatifreeException;
import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe/Interface <b>BibliothequeDaoImpl</b><br/>
 *
 * @param <T> Bibliotheque
 * @param <TI> BibliothequeImpl
 * @param <IT> IBibliotheque
 */
public abstract class BibliothequeDaoImpl<T extends Bibliotheque, TI extends BibliothequeImpl, IT extends IBibliotheque> extends
        BfGenericHibernateDaoImpl<T, TI, IT, Integer> implements IBibliothequeDao<IT>, ILigneWithModificationHibernateDaoContainer {

	private static final Logger LOGGER = Logger.getLogger(BibliothequeDaoImpl.class);

	private final LigneHibernateDaoUtil ligneDao;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public BibliothequeDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
		ligneDao = new LigneHibernateDaoUtil(this);
	}

	/**
	 * Retourne la classe BibliothequeImpl à partir de l'interface métier.
	 * 
	 * @param pInterfaceClass l'interface métier
	 * @param <TT> IMetier
	 * @return classe BibliothequeImpl
	 * @throws BatifreeException
	 */
	@SuppressWarnings("unchecked")
	private static <TT extends IMetier<?>> Class<? extends BibliothequeImpl> getClassImplFromInterface(Class<TT> pInterfaceClass)
	        throws BatifreeException {
		IFactoryBf factory = ApplicationBf.getApplication().getFactory();
		return (Class<? extends BibliothequeImpl>) factory.getClassImplementation(pInterfaceClass);
	}

	/**
	 * Retourne la classe EJB à partir de l'objet BibliothequeImpl.
	 * 
	 * @param <TBIB> Bibliotheque
	 * @param pBib ejb
	 * @return classe BibliothequeImpl
	 */
	public static <TBIB extends IBibliotheque> Class<?> getClassEjbFromMetierImpl(TBIB pBib) {
		if (pBib instanceof IMateriauxBib) {
			return MateriauxBib.class;
		} else if (pBib instanceof IMateriauxEtude) {
			return MateriauxEtude.class;
		} else if (pBib instanceof ISousTraitantBib) {
			return SoustraitantBib.class;
		} else if (pBib instanceof ISousTraitantEtude) {
			return SoustraitantEtude.class;
		} else if (pBib instanceof IEnginBib) {
			return EnginBib.class;
		} else if (pBib instanceof IEnginEtude) {
			return EnginEtude.class;
		} else if (pBib instanceof ILotBib || pBib instanceof ITacheBib) {
			return TacheLotBib.class;
		} else if (pBib instanceof ILotEtude || pBib instanceof ITacheEtude) {
			return TacheLotEtude.class;
		} else if (pBib instanceof IMainOeuvreBib) {
			return MainoeuvreBib.class;
		} else if (pBib instanceof IMainOeuvreEtude) {
			return MainoeuvreEtude.class;
		}
		return null;
	}

	/**
	 * Retourne la classe BibliothequeImpl à partir de l'ejb.
	 * 
	 * @param pEjb ejb
	 * @param <TEJB> ejb
	 * @return classe BibliothequeImpl
	 */
	public static <TEJB> Class<? extends BibliothequeImpl> getClassImplFromEjb(TEJB pEjb) {

		try {
			if (pEjb instanceof MateriauxBib) {
				return getClassImplFromInterface(IMateriauxBib.class);
			} else if (pEjb instanceof MateriauxEtude) {
				return getClassImplFromInterface(IMateriauxEtude.class);
			} else if (pEjb instanceof SoustraitantBib) {
				return getClassImplFromInterface(ISousTraitantBib.class);
			} else if (pEjb instanceof SoustraitantEtude) {
				return getClassImplFromInterface(ISousTraitantEtude.class);
			} else if (pEjb instanceof EnginBib) {
				return getClassImplFromInterface(IEnginBib.class);
			} else if (pEjb instanceof EnginEtude) {
				return getClassImplFromInterface(IEnginEtude.class);
			} else if (pEjb instanceof TacheLotBib) {
				TacheLotBib tacLot = (TacheLotBib) pEjb;
				if (tacLot.getIsLot()) {
					return getClassImplFromInterface(ILotBib.class);
				}
				return getClassImplFromInterface(ITacheBib.class);
			} else if (pEjb instanceof TacheLotEtude) {
				TacheLotEtude tacLot = (TacheLotEtude) pEjb;
				if (tacLot.getIsLot()) {
					return getClassImplFromInterface(ILotEtude.class);
				}
				return getClassImplFromInterface(ITacheEtude.class);
			} else if (pEjb instanceof MainoeuvreBib) {
				return getClassImplFromInterface(IMainOeuvreBib.class);
			} else if (pEjb instanceof MainoeuvreEtude) {
				return getClassImplFromInterface(IMainOeuvreEtude.class);
			}

		} catch (BatifreeException e) {
			LOGGER.error("getClassImplFromEjb", e);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IT> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException {
		if (pWithChildren) {
			// Liste globale de tous les métier ligne
			List<IBibliotheque> list = ligneDao.getList(getCriteria(pMaxResult, pFirstResult), IBibliotheque.class);

			// Liste de retour
			List<IT> listRet = new ArrayList<>();
			if (list != null) {
				for (IBibliotheque iBib : list) {
					listRet.add(((IT) iBib));
				}
			}
			return listRet;
		}

		// Liste des métier ligne de 1er niveau
		Criteria crit = getCriteria(pMaxResult, pFirstResult);
		crit.add(Restrictions.eq("niveau", new Integer(LigneHibernateDaoUtil.NIVEAU_START)));
		return getList(crit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IT getById(Integer pId) throws BatifreeException {
		// Liste globale de tous les métier ligne de l'objet
		if (pId != null) {
			Criteria crit = getCriteriaSession(getPersistentClass(), "bib");
			crit.add(Restrictions.eq("id", pId));

			List<IT> listRet = (List<IT>) ligneDao.getList(crit, IBibliotheque.class);
			if (listRet != null && listRet.size() == 1) {
				// Nouvel objet
				return listRet.get(0);
			}
		}
		return null;
		// return (IT) ligneDao.getById(pId, IBibliotheque.class);
	}

	@Override
	public List<?> getListEJBGenericForLigneDao(Criteria pCriteria) throws BatifreeException {
		return getListEJBGeneric(pCriteria);
	}

	@Override
	public <ILIGNE extends ILigne<ILIGNE, ?>> Class<ILIGNE> getClassMetierImplFromEjbForLigneDao(ILigneEjb pLigneEjb) {
		@SuppressWarnings("unchecked")
		Class<ILIGNE> ligne = (Class<ILIGNE>) BibliothequeDaoImpl.getClassImplFromEjb(pLigneEjb);
		return ligne;
	}

	@Override
	public <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> Class<ILIGNEEJB> getClassEjbFromMetierImplForLigneDao(ILIGNE pLigneMetier) {
		IBibliotheque bib = (IBibliotheque) pLigneMetier;
		@SuppressWarnings("unchecked")
		Class<ILIGNEEJB> ligne = (Class<ILIGNEEJB>) BibliothequeDaoImpl.getClassEjbFromMetierImpl(bib);
		return ligne;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <BIB extends IBibliotheque, ILIGNEEJB extends Bibliotheque> BIB saveLigne(IT pMetier) throws BatifreeException {
		BIB metierNew = null;

		// Récupère la liste des objets métier à partir de la liste des ejb sauvées
		List<IBibliotheque> listBib = ligneDao.getListFromMetierForSaveLigne(pMetier, IBibliotheque.class);
		if (listBib != null && listBib.size() == 1) {
			// Nouvel objet
			metierNew = (BIB) listBib.get(0);

			// Met à jour les éléments spécifiques
			saveLigneElement(pMetier, metierNew);
		}

		return metierNew;
	}

	@Override
	public Criteria getCriteriaSessionForLigneDao() throws BatifreeException {
		return getCriteriaSession(Bibliotheque.class, "bib");
	}

	@Override
	public <TEJB, IDD extends Serializable> void deleteGenericForLigneDao(IDD pId, Class<TEJB> pClazzEjb) throws BatifreeException {
		deleteGeneric(pId, pClazzEjb);
	}

	@Override
	public Session getSessionForLigneDao() throws BatifreeException {
		return getSession();
	}

	@Override
	public void saveOrUpdateEjbForLigneDao(Object pEjb) throws BatifreeException {
		Object ejbOld = null;
		Bibliotheque ejbBib = (Bibliotheque) pEjb;
		if (ejbBib.getId() != null) {
			ejbOld = getSession().get(Bibliotheque.class, ejbBib.getId());
		} else {
			ejbOld = ejbBib;
		}
		saveOrUpdateEjb(ejbOld);
	}

	/**
	 * Supprime la bib de 1er niveau ainsi que ses sous éléments.
	 * 
	 * @param pMetier bib de 1er niveau
	 * @throws BatifreeException
	 */
	@Override
	public void delete(IT pMetier) throws BatifreeException {
		// Supprime tous les bib rattaché à la bib
		if (pMetier != null && pMetier.getParent() == null) {
			// Recherche tous les éléments bib
			Criteria crit = getCriteriaSession(Bibliotheque.class, "bib").add(Restrictions.eq("bibOrigin.id", pMetier.getId()));
			List<?> list = getListEJBGeneric(crit);

			// Pour chaque bib, supprime l'objet
			for (Object ejb : list) {
				if (ejb instanceof Bibliotheque) {
					Bibliotheque bibEjb = (Bibliotheque) ejb;
					ligneDao.deleteLigneEjb(bibEjb);
				}
			}

			// Supprime l'élément courant ainsi que ses sous éléments
			ligneDao.deleteLigneEjb(getEjbFromMetier(pMetier));
		}
	}

	/**
	 * Sauvegarde les éléments spécifiques de l'objet métier nouveau. L'objet ancien peut être utilisé lors de la récupération de liste.
	 * 
	 * @param <BIB> Bibliotheque
	 * @param pMetierOld métier ancien
	 * @param pMetierNew métier nouveau
	 */
	protected <BIB extends IBibliotheque> void saveLigneElement(IT pMetierOld, BIB pMetierNew) throws BatifreeException {

	}

	@Override
	public List<ITache> getListTacheParente(IT pBib) throws BatifreeException {
		List<ITache> listTache = new ArrayList<>();

		if (pBib != null) {
			IBibliotheque bibOrigin = null;
			if (pBib instanceof IBibEltBib) {
				IBibEltBib bib = (IBibEltBib) pBib;
				bibOrigin = (IBibliotheque) bib.getElementOrigin();
			}

			String reqFilterBib = "bibO.bib_origin";
			if (bibOrigin != null) {
				reqFilterBib = "bibO.bib_id";
			}

			Query query = getSession().createSQLQuery("select bibTac.bib_id from BIBLIOTHEQUE bibO " + //
			        "inner join BIBLIOTHEQUE bibTac ON bibTac.BIB_Parent = bibO.BIB_Parent " + //
			        "inner join TACHE_LOT tac on bibTac.BIB_ID = tac.BIB_ID and tac.TAC_IS_LOT=0 " + //
			        "where " + reqFilterBib + " = :bibId").setParameter("bibId", pBib.getId());
			List<?> listTacheId = query.list();

			// Rempli la liste des ITache par rapport aux id
			for (Object id : listTacheId) {
				ITache tache = getByIdGeneric((Integer) id, TacheLot.class, TacheBibImpl.class);
				listTache.add(tache);
			}
		}

		return listTache;
	}

}