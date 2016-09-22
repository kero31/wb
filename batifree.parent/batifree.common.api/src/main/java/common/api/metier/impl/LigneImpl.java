/**
 * 
 */
package common.api.metier.impl;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import org.apache.log4j.Logger;

import common.api.exception.BatifreeException;
import common.api.metier.interfaces.ILigne;

/**
 * 
 * Classe/Interface <b>LigneImpl</b>
 *
 * @param <IT> ILigne
 * @param <ID> Serializable
 */
public abstract class LigneImpl<IT extends ILigne<IT, ID>, ID extends Serializable> extends MetierImpl<ID> implements ILigne<IT, ID> {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(LigneImpl.class);

	private Integer ordre;
	private IT parent;
	private List<IT> listLigne;

	/**
	 * 
	 * Constructeur.
	 */
	public LigneImpl() {
		super();
	}

	@Override
	public Integer getOrdre() {
		return getValue(ordre);
	}

	@Override
	public void setOrdre(Integer pOrdre) {
		ordre = pOrdre;
	}

	@Override
	public IT getParent() {
		return parent;
	}

	@Override
	public void setParent(IT pParent) {
		parent = pParent;
	}

	@Override
	public List<IT> getListLigne() {
		if (listLigne == null) {
			try {
				listLigne = getListLigneFromManager();
			} catch (BatifreeException e) {
				LOGGER.error("Erreur récup list ligne manager", e);
			}
			if (listLigne == null) {
				listLigne = new ArrayList<>();
			}
		}
		return listLigne;
	}

	/**
	 * Retourne la liste des sous éléments recherché via le manager.
	 * 
	 * @return liste des sous éléments
	 * @throws BatifreeException
	 */
	protected abstract List<IT> getListLigneFromManager() throws BatifreeException;

	@Override
	public void setListLigne(List<IT> pListLigne) {
		listLigne = pListLigne;

	}

}
