package webbati.api.dao.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import common.api.exception.WebbatiException;
import webbati.api.dao.interfaces.ITacheDao;
import webbati.api.metier.ejb.TacheLot;
import webbati.api.metier.impl.TacheImpl;
import webbati.api.metier.interfaces.ITache;

/**
 * 
 * Classe/Interface <b>TacheDaoImpl</b><br/>
 *
 * @param <T> TacheLot
 * @param <TI> TacheImpl
 * @param <IT> ITache
 */
public abstract class TacheDaoImpl<T extends TacheLot, TI extends TacheImpl, IT extends ITache> extends TacheLotDaoImpl<T, TI, IT> implements
        ITacheDao<IT> {

	/**
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public TacheDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	protected Criteria getCriteria(int pMaxResult, int pFirstResult) throws WebbatiException {
		// Pour les lot filtre sur le isLot
		Criteria crit = super.getCriteria(pMaxResult, pFirstResult);
		crit.add(Restrictions.eq("isLot", false));
		return crit;
	}
}