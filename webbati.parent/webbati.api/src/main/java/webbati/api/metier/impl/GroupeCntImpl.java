/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

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
	public List<IDiversCnt> getListDiversContact() throws WebbatiException {
		return ApplicationWb.getApplication().getGroupeCntManager().getListDiversContact(this);
	}

}
