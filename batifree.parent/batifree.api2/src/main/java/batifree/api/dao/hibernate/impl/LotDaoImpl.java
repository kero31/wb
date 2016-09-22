package batifree.api.dao.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import batifree.api.dao.interfaces.ILotDao;
import batifree.api.metier.ejb.TacheLot;
import batifree.api.metier.impl.LotImpl;
import batifree.api.metier.interfaces.ILot;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>LotDaoImpl</b><br/>
 *
 * @param <T> TacheLot
 * @param <TI> LotImpl
 * @param <IT> ILot
 */
public abstract class LotDaoImpl<T extends TacheLot, TI extends LotImpl, IT extends ILot> extends TacheLotDaoImpl<T, TI, IT> implements ILotDao<IT> {

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public LotDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	protected Criteria getCriteria(int pMaxResult, int pFirstResult) throws BatifreeException {
		// Pour les lot filtre sur le isLot
		Criteria crit = super.getCriteria(pMaxResult, pFirstResult);
		crit.add(Restrictions.eq("isLot", true));
		return crit;
	}

}