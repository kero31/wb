/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Classe <GroupeCntImpl>.
 * 
 */
public class GroupeCntImpl extends IdLibelleImpl implements IGroupeCnt {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<IDiversCnt> getListDiversContact() throws BatifreeException {
		return ApplicationBf.getApplication().getGroupeCntManager().getListDiversContact(this);
	}

}
