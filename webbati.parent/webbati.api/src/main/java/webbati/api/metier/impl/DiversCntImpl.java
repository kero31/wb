/**
 * 
 */
package webbati.api.metier.impl;

import java.util.List;

import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.metier.interfaces.IDetailCnt;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IGroupeCnt;

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
	public List<IGroupeCnt> getListGroupeContact() throws WebbatiException {
		if (islistGroupeCntUpdated) {
			return listGroupeCnt;
		}
		return ApplicationWb.getApplication().getDiversCntManager().getListGroupeContact(this);
	}

	@Override
	public List<IDetailCnt> getListDetailContact() throws WebbatiException {
		return ApplicationWb.getApplication().getDiversCntManager().getListDetailContact(this);
	}

	@Override
	public void setListGroupeContact(List<IGroupeCnt> pListGroupeCnt) {
		islistGroupeCntUpdated = true;
		listGroupeCnt = pListGroupeCnt;
	}
}
