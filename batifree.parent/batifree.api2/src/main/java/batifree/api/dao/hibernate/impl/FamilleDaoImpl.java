package batifree.api.dao.hibernate.impl;

import java.util.List;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IFamilleDao;
import batifree.api.metier.ejb.Famille;
import batifree.api.metier.impl.BibliothequeImpl;
import batifree.api.metier.impl.FamilleImpl;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFamille;

import common.api.dao.hibernate.util.LigneHibernateDaoUtil;
import common.api.dao.interfaces.ILigneWithModificationHibernateDaoContainer;
import common.api.exception.BatifreeException;
import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;

/**
 * Classe <FamilleDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_FamilleDao")
public class FamilleDaoImpl extends BfGenericHibernateDaoImpl<Famille, FamilleImpl, IFamille, Integer> implements IFamilleDao,
        ILigneWithModificationHibernateDaoContainer {

	private final LigneHibernateDaoUtil ligneDao;

	/**
	 * Constructeur.
	 * 
	 */
	public FamilleDaoImpl() {
		super(Famille.class, FamilleImpl.class);
		ligneDao = new LigneHibernateDaoUtil(this);
	}

	@Override
	public List<IBibliotheque> getListBibliotheque(IFamille pFamille) throws BatifreeException {
		Famille obj = getEjbFromMetier(pFamille);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getBibliotheques(), BibliothequeImpl.class, IBibliotheque.class);
		}
		return null;
	}

	@Override
	protected <TEJB> Class<?> getClassMetierFromEjb(TEJB pEjb) {
		return BibliothequeDaoImpl.getClassImplFromEjb(pEjb);
	}

	@Override
	public List<IFamille> getList(int pMaxResult, int pFirstResult, boolean pWithChildren) throws BatifreeException {
		if (pWithChildren) {
			// Liste globale de tous les métier ligne
			return ligneDao.getList(getCriteria(pMaxResult, pFirstResult), IFamille.class);
		}

		// Liste des métier ligne de 1er niveau
		Criteria crit = getCriteria(pMaxResult, pFirstResult);
		crit.add(Restrictions.eq("niveau", new Integer(LigneHibernateDaoUtil.NIVEAU_START)));
		return getList(crit);

	}

	@Override
	public IFamille getById(Integer pId) throws BatifreeException {
		/*
		// Liste globale de tous les métier ligne de l'objet
		if (pId != null) {
			Criteria crit = getCriteriaSessionForLigneDao();
			crit.add(Restrictions.eq("id", pId));
			List<IFamille> listRet = ligneDao.getList(crit, IFamille.class);
			if (listRet != null && listRet.size() == 1) {
				// Nouvel objet
				return listRet.get(0);
			}
		}
		return null;*/
		return ligneDao.getById(pId, IFamille.class);
	}

	@Override
	public List<?> getListEJBGenericForLigneDao(Criteria pCriteria) throws BatifreeException {
		return getListEJBGeneric(pCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <ILIGNE extends ILigne<ILIGNE, ?>> Class<ILIGNE> getClassMetierImplFromEjbForLigneDao(ILigneEjb pLigneEjb) {
		return (Class<ILIGNE>) FamilleImpl.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <ILIGNE extends ILigne<ILIGNE, ?>, ILIGNEEJB extends ILigneEjb> Class<ILIGNEEJB> getClassEjbFromMetierImplForLigneDao(ILIGNE pLigneMetier) {
		return (Class<ILIGNEEJB>) Famille.class;
	}

	@Override
	public IFamille save(IFamille pMetier) throws BatifreeException {
		IFamille famille = null;
		if (pMetier != null) {
			// Récupère la liste des objets métier à partir de la liste des ejb sauvées
			List<IFamille> listFamille = ligneDao.getListFromMetierForSaveLigne(pMetier, IFamille.class);
			if (listFamille != null && listFamille.size() == 1) {
				// Nouvel objet
				famille = listFamille.get(0);
			}
		}

		return famille;
	}

	/**
	 * Supprime la famille de 1er niveau ainsi que ses sous éléments.
	 * 
	 * @param pMetier famille de 1er niveau
	 * @throws BatifreeException
	 */
	@Override
	public void delete(IFamille pMetier) throws BatifreeException {
		// Supprime la famille de 1er niveau ainsi que ses sous familles
		if (pMetier != null && pMetier.getParent() == null) {
			// Supprime tous les éléments qui lui appartiennent
			ligneDao.deleteLigneEjb(getEjbFromMetier(pMetier));
		}
	}

	@Override
	public <TEJB, IDD extends Serializable> void deleteGenericForLigneDao(IDD pId, Class<TEJB> pClazzEjb) throws BatifreeException {
		deleteGeneric(pId, pClazzEjb);
	}

	@Override
	public void saveOrUpdateEjbForLigneDao(Object pEjb) throws BatifreeException {
		saveOrUpdateEjb(pEjb);
	}

	@Override
	public Criteria getCriteriaSessionForLigneDao() throws BatifreeException {
		return getCriteriaSession(Famille.class, "fam");
	}

	@Override
	public Session getSessionForLigneDao() throws BatifreeException {
		return getSession();
	}
}