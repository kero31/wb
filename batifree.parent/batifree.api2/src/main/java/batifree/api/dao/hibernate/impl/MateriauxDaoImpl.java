package batifree.api.dao.hibernate.impl;

import java.util.List;

import javax.annotation.Resource;

import batifree.api.dao.interfaces.IFournisseurMateriauxDao;
import batifree.api.dao.interfaces.IMateriauxDao;
import batifree.api.metier.ejb.Materiaux;
import batifree.api.metier.impl.FournisseurMateriauxImpl;
import batifree.api.metier.impl.MateriauxImpl;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IMateriaux;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>MateriauxDaoImpl</b><br/>
 *
 * @param <T> Materiaux
 * @param <TI> MateriauxImpl
 * @param <IT> IMateriaux
 */
public abstract class MateriauxDaoImpl<T extends Materiaux, TI extends MateriauxImpl, IT extends IMateriaux> extends BibliothequeDaoImpl<T, TI, IT>
        implements IMateriauxDao<IT> {

	@Resource(name = "BF_FournisseurMateriauxDao")
	private IFournisseurMateriauxDao fournisseurMateriauxDao;

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public MateriauxDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	public List<IFournisseurMateriaux> getListFournisseurMateriaux(IMateriaux pMateriaux) throws BatifreeException {
		Materiaux obj = getEjbFromMetier(pMateriaux);
		if (obj != null) {
			return getListMetierFromListEjb(obj.getFournisseurMateriauxes(), FournisseurMateriauxImpl.class, IFournisseurMateriaux.class);
		}
		return null;
	}

	@Override
	protected <BIB extends IBibliotheque> void saveLigneElement(IT pMetierOld, BIB pMetierNew) throws BatifreeException {
		// Ne prend en compte que les materiaux qui sont à la racine (pas de parent)
		if (pMetierNew instanceof IMateriaux && pMetierOld != null && pMetierNew.getParent() == null) {
			IMateriaux metierNew = (IMateriaux) pMetierNew;
			// Récupère la nouvelle liste
			List<IFournisseurMateriaux> listFrnMxNew = pMetierOld.getListFournisseurMateriaux();

			// Récupère l'ancienne liste
			List<IFournisseurMateriaux> listFrnMxActual = metierNew.getListFournisseurMateriaux();

			// Supprime les éléments qui ne sont plus utilisés
			deleteMetierFromNewListMetier(listFrnMxActual, listFrnMxNew, fournisseurMateriauxDao);

			// Enregistre la nouvelle liste
			if (listFrnMxNew != null) {
				for (IFournisseurMateriaux iFournisseurMateriaux : listFrnMxNew) {
					iFournisseurMateriaux.setMateriaux(metierNew);
					fournisseurMateriauxDao.save(iFournisseurMateriaux);
				}
			}
		}
	}
}