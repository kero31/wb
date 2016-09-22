package batifree.api.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IEtudeDao;
import batifree.api.manager.interfaces.IEtudeManager;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IBibEltEtude;
import batifree.api.metier.interfaces.IBibliotheque;
import batifree.api.metier.interfaces.IEtude;

import common.api.dao.interfaces.IDao;
import common.api.exception.BatifreeException;

/**
 * Classe <EtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_EtudeManager")
public class EtudeManagerImpl extends BfGenericManagerImpl<IEtude, Integer> implements IEtudeManager {

	@Resource(name = "BF_EtudeDao")
	private IEtudeDao etudeDao;

	@Override
	protected IDao<IEtude, Integer> getMainDao() {
		return etudeDao;
	}

	@Override
	public List<IBibEltEtude> getListBibliotheque(IEtude pEtude) throws BatifreeException {
		return getListDaoFromObject(pEtude, etudeDao.getListBibliotheque(pEtude));
	}

	@Override
	public IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest, IAffaire pAffaire) throws BatifreeException {
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
	public IEtude getClone(IEtude pEtudeOrigin, IEtude pNewEtudeDest) throws BatifreeException {
		if (pEtudeOrigin != null) {
			return getClone(pEtudeOrigin, pNewEtudeDest, pEtudeOrigin.getAffaire());
		}
		return pNewEtudeDest;
	}
}