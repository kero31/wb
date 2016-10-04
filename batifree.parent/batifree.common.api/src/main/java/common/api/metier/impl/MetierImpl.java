/**
 * 
 */
package common.api.metier.impl;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * 
 * Classe <MetierImpl>.
 * 
 * @param <ID> Type Id de l'objet Metier
 */
public abstract class MetierImpl<ID extends Serializable> implements IMetier<ID> {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** Champs Id. */
	private ID id;

	/**
	 * Constructeur.
	 */
	public MetierImpl() {

	}

	@Override
	public ID getId() {
		return this.id;
	}

	/**
	 * Met à jour le champ id.
	 * 
	 * @param pId le id à mettre à jour
	 */
	public void setId(ID pId) {
		id = pId;
	}

	/**
	 * Retourne la value formattée.
	 * 
	 * @param pValue value à formatter
	 * @return value formattée
	 */
	public static Long getValue(Long pValue) {
		return pValue != null ? pValue : 0;
	}

	/**
	 * Retourne la value formattée.
	 * 
	 * @param pValue value à formatter
	 * @return value formattée
	 */
	public static Short getValue(Short pValue) {
		return pValue != null ? pValue : 0;
	}

	/**
	 * Retourne la value formattée.
	 * 
	 * @param pValue value à formatter
	 * @return value formattée
	 */
	public static Float getValue(Float pValue) {
		return pValue != null ? pValue : 0;
	}

	/**
	 * Retourne la value formattée.
	 * 
	 * @param pValue value à formatter
	 * @return value formattée
	 */
	public static Integer getValue(Integer pValue) {
		return pValue != null ? pValue : 0;
	}

	/**
	 * Retourne la value formattée.
	 * 
	 * @param pValue value à formatter
	 * @return value formattée
	 */
	public static Boolean getValue(Boolean pValue) {
		return pValue != null ? pValue : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <METIER extends IMetier<ID>> METIER getNewInstance() throws WebbatiException {
		try {
			return (METIER) getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new WebbatiException(e);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object pArg0) {
		ID currentId = getId();
		if (currentId != null && pArg0 instanceof IMetier<?>) {
			IMetier<?> arg = (IMetier<?>) pArg0;
			return currentId.equals(arg.getId());
		}

		return super.equals(pArg0);
	}

	/**
	 * Retourne une liste formattée à partir de l'objet métier et d'une liste retournée du dao.
	 * 
	 * @param pList liste retournée du dao
	 * @param <IT> IMetier
	 * @return liste formattée
	 */
	protected <IT extends IMetier<?>> List<IT> getListFormatted(List<IT> pList) {
		if (pList != null) {
			return pList;
		}
		return new ArrayList<>();
	}

}
