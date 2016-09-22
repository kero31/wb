package batifree.api.dao.hibernate.impl;

import batifree.api.metier.ejb.TacheLot;
import batifree.api.metier.impl.BibliothequeImpl;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.ILot;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>TacheLotDaoImpl</b><br/>
 *
 * @param <T> TacheLot
 * @param <TI> BibliothequeImpl
 * @param <IT> IBibliotheque
 */
public abstract class TacheLotDaoImpl<T extends TacheLot, TI extends BibliothequeImpl, IT extends IBibliotheque> extends
        BibliothequeDaoImpl<T, TI, IT> {

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public TacheLotDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	protected T getEjbUpdatedFromMetier(IT pMetier) throws BatifreeException {
		T tacheLot = super.getEjbUpdatedFromMetier(pMetier);

		// Met à jour le statut de isLot de TacheLot en fonction de l'interface métier
		tacheLot.setIsLot(pMetier instanceof ILot);

		return tacheLot;
	}
}