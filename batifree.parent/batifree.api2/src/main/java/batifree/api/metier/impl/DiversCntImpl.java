/**
 * 
 */
package batifree.api.metier.impl;

import java.util.List;

import batifree.api.application.impl.ApplicationBf;
import batifree.api.metier.interfaces.IDetailCnt;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IGroupeCnt;

import common.api.exception.BatifreeException;

/**
 * Classe <DiversCntImpl>.
 * 
 */
public class DiversCntImpl extends ContactImpl implements IDiversCnt {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private List<IGroupeCnt> listGroupeCnt = null;
	private boolean islistGroupeCntUpdated = false;

	@Override
	public List<IGroupeCnt> getListGroupeContact() throws BatifreeException {
		if (islistGroupeCntUpdated) {
			return listGroupeCnt;
		}
		return ApplicationBf.getApplication().getDiversCntManager().getListGroupeContact(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws BatifreeException {
		return ApplicationBf.getApplication().getDiversCntManager().getListDetailContact(this);
	}

	@Override
	public void setListGroupeContact(List<IGroupeCnt> pListGroupeCnt) {
		islistGroupeCntUpdated = true;
		listGroupeCnt = pListGroupeCnt;
	}
}
