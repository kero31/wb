package batifree.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IEnginEtudeDao;
import batifree.api.dao.interfaces.IEtudeDao;
import batifree.api.dao.interfaces.ILotEtudeDao;
import batifree.api.dao.interfaces.IMainOeuvreEtudeDao;
import batifree.api.dao.interfaces.IMateriauxEtudeDao;
import batifree.api.dao.interfaces.ISousTraitantEtudeDao;
import batifree.api.dao.interfaces.ITacheEtudeDao;
import batifree.api.metier.ejb.Bibliotheque;
import batifree.api.metier.ejb.Etude;
import batifree.api.metier.impl.EtudeImpl;
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IEtude;

import common.api.dao.hibernate.util.LigneHibernateDaoUtil;
import common.api.dao.interfaces.ILigneHibernateDaoContainer;
import common.api.exception.BatifreeException;
import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;

/**
 * Classe <EtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_EtudeDao")
public class EtudeDaoImpl extends BfGenericHibernateDaoImpl<Etude, EtudeImpl, IEtude, Integer> implements IEtudeDao, ILigneHibernateDaoContainer {

	@Resource(name = "BF_EnginEtudeDao")
	private IEnginEtudeDao enginEtudeDao;

	@Resource(name = "BF_MateriauxEtudeDao")
	private IMateriauxEtudeDao materiauxEtudeDao;

	@Resource(name = "BF_MainOeuvreEtudeDao")
	private IMainOeuvreEtudeDao mainOeuvreEtudeDao;

	@Resource(name = "BF_SousTraitantEtudeDao")
	private ISousTraitantEtudeDao sousTraitantEtudeDao;

	@Resource(name = "BF_LotEtudeDao")
	private ILotEtudeDao lotEtudeDao;

	@Resource(name = "BF_TacheEtudeDao")
	private ITacheEtudeDao tacheEtudeDao;

	private final LigneHibernateDaoUtil ligneDao;

	/**
	 * Constructeur.
	 * 
	 */
	public EtudeDaoImpl() {
		super(Etude.class, EtudeImpl.class);
		ligneDao = new LigneHibernateDaoUtil(this);
	}

	@Override
	public List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws BatifreeException {
		Etude etude = getEjbFromMetier(pEtude);

		if (etude != null) {
			// Récup de la liste avec ses enfants
			return ligneDao.getListFromListLigneEjb(etude.getBibliotheques(), IBibEltEtude.class);
		}
		return null;
	}

	@Override
	public IEtude save(IEtude pEtude) throws BatifreeException {
		IEtude newEtude = null;
		if (pEtude != null) {
			newEtude = super.save(pEtude);

			// Récupère la liste des EJB à partir de l'objet étude
			List<IBibEltEtude> listBibEtudeMetier = pEtude.getListBibliotheque();
			List<IBibliotheque> listBibMetier = new ArrayList<>();
			for (IBibEltEtude iBibEtude : listBibEtudeMetier) {
				listBibMetier.add((IBibliotheque) iBibEtude);
			}

			// Supprime les bibs rattaché à l'étude
			deleteListLigneFromEtude(pEtude);

			// Récupère la liste des EJB à partir de l'objet métier
			List<Bibliotheque> listEjb = ligneDao.getListEjbFromListMetier(listBibMetier);
			if (listEjb != null) {
				// Sauve la liste des EJB
				for (Bibliotheque ejb : listEjb) {
					ejb.setEtudeId(newEtude.getId());
					saveOrUpdateEjb(ejb);
				}

				// Récupère la liste des objets métier à partir de la liste des ejb sauvées
				List<IBibEltEtude> listBib = ligneDao.getListFromListLigneEjb(listEjb, IBibEltEtude.class);
				newEtude.setListBibliotheque(listBib);
			}
		}

		return newEtude;
	}

	/**
	 * Supprime tous les bib qui sont rattaché à l'étude.
	 * 
	 * @param <ILIGNEEJB> ligne ejb
	 * @param <BIB> Bibliotheque
	 * @param pEtude étude
	 * @throws BatifreeException
	 */
	protected <BIB extends IBibliotheque, ILIGNEEJB extends Bibliotheque> void deleteListLigneFromEtude(IEtude pEtude) throws BatifreeException {
		// Supprime tous les bib rattaché à l'étude
		if (pEtude != null) {
			// Recherche tous les éléments bib
			Criteria crit = getCriteriaSession(Bibliotheque.class, "bib").createAlias("bib.etude", "etude", JoinType.INNER_JOIN).add(
			        Restrictions.eq("etude.id", pEtude.getId()));
			List<?> list = getListEJBGeneric(crit);

			// Pour chaque bib, supprime l'objet
			for (Object ejb : list) {
				if (ejb instanceof Bibliotheque) {
					Bibliotheque bibEjb = (Bibliotheque) ejb;
					deleteGeneric(bibEjb.getId(), bibEjb.getClass());
				}
			}
		}
	}

	@Override
	public void delete(IEtude pMetier) throws BatifreeException {
		// Supprime toutes les lignes rattachées
		deleteListLigneFromEtude(pMetier);

		// Supprime l'étude
		super.delete(pMetier);
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
}