package webbati.api.dao.hibernate.impl;

import common.api.exception.WebbatiException;
import webbati.api.metier.ejb.TacheLot;
import webbati.api.metier.impl.BibliothequeImpl;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.ILot;

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
	protected T getEjbUpdatedFromMetier(IT pMetier) throws WebbatiException {
		T tacheLot = super.getEjbUpdatedFromMetier(pMetier);

		// Met à jour le statut de isLot de TacheLot en fonction de l'interface métier
		tacheLot.setIsLot(pMetier instanceof ILot);

		return tacheLot;
	}
}