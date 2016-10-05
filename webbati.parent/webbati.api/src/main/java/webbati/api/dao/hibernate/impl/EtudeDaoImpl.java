package webbati.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import common.api.dao.hibernate.util.LigneHibernateDaoUtil;
import common.api.dao.interfaces.ILigneHibernateDaoContainer;
import common.api.exception.WebbatiException;
import common.api.metier.ejb.ILigneEjb;
import common.api.metier.interfaces.ILigne;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEnginEtudeDao;
import webbati.api.dao.interfaces.IEtudeDao;
import webbati.api.dao.interfaces.ILotEtudeDao;
import webbati.api.dao.interfaces.IMainOeuvreEtudeDao;
import webbati.api.dao.interfaces.IMateriauxEtudeDao;
import webbati.api.dao.interfaces.ISousTraitantEtudeDao;
import webbati.api.dao.interfaces.ITacheEtudeDao;
import webbati.api.metier.ejb.Bibliotheque;
import webbati.api.metier.ejb.Etude;
import webbati.api.metier.impl.EtudeImpl;
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IEtude;

/**
 * Classe <EtudeDaoImpl>.
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_EtudeDao")
public class EtudeDaoImpl extends BfGenericHibernateDaoImpl<Etude, EtudeImpl, IEtude, Integer> implements IEtudeDao, ILigneHibernateDaoContainer {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EnginEtudeDao")
	private IEnginEtudeDao enginEtudeDao;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MateriauxEtudeDao")
	private IMateriauxEtudeDao materiauxEtudeDao;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MainOeuvreEtudeDao")
	private IMainOeuvreEtudeDao mainOeuvreEtudeDao;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_SousTraitantEtudeDao")
	private ISousTraitantEtudeDao sousTraitantEtudeDao;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_LotEtudeDao")
	private ILotEtudeDao lotEtudeDao;

	@Resource(name = ApplicationWb.CODE_PROJECT + "_TacheEtudeDao")
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
	public List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws WebbatiException {
		Etude etude = getEjbFromMetier(pEtude);

		if (etude != null) {
			// Récup de la liste avec ses enfants
			return ligneDao.getListFromListLigneEjb(etude.getBibliotheques(), IBibEltEtude.class);
		}
		return null;
	}

	@Override
	public IEtude save(IEtude pEtude) throws WebbatiException {
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
	 * @throws WebbatiException
	 */
	protected <BIB extends IBibliotheque, ILIGNEEJB extends Bibliotheque> void deleteListLigneFromEtude(IEtude pEtude) throws WebbatiException {
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
	public void delete(IEtude pMetier) throws WebbatiException {
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