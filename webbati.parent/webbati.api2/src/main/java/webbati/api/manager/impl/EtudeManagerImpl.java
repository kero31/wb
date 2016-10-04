package webbati.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import common.api.exception.WebbatiException;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IEtudeDao;
import webbati.api.manager.interfaces.IEtudeManager;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IBibEltEtude;
import webbati.api.metier.interfaces.IBibliotheque;
import webbati.api.metier.interfaces.IEtude;

/**
 * Classe <EtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_EtudeManager")
public class EtudeManagerImpl extends BfGenericManagerImpl<IEtude, Integer> implements IEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_EtudeDao")
	private IEtudeDao etudeDao;

	@Override
	protected IDao<IEtude, Integer> getMainDao() {
		return etudeDao;
	}

	@Override
	public List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws WebbatiException {
		return getListDaoFromObject(pEtude, etudeDao.getListBibliotheque(pEtude));
	}

	@Override
	public IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest, IAffaire pAffaire) throws WebbatiException {
		if (pEtudeOrigin != null && pNewEtudeDest != null) {
			List<IBibEltEtude> listLigneEtudeOrigin = pEtudeOrigin.getListBibliotheque();
			List<IBibEltEtude> listLigneEtudeDest = new ArrayList<>();

			for (IBibEltEtude ligneOri : listLigneEtudeOrigin) {
				IBibliotheque bibOri = (IBibliotheque) ligneOri;
				IBibliotheque bibDest = bibOri.getClone();
				IBibEltEtude ligneDest = (IBibEltEtude) bibDest;
				ligneDest.setEtude(pNewEtudeDest);

				listLigneEtudeDest.add(ligneDest);
			}

			pNewEtudeDest.setAffaire(pAffaire);
			pNewEtudeDest.setListBibliotheque(listLigneEtudeDest);
		}
		return pNewEtudeDest;
	}

	@Override
	public IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest) throws WebbatiException {
		if (pEtudeOrigin != null) {
			return getClone(pEtudeOrigin, pNewEtudeDest, pEtudeOrigin.getAffaire());
		}
		return pNewEtudeDest;
	}
}