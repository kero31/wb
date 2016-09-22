package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IMainOeuvreEtudeDao;
import batifree.api.manager.interfaces.IMainOeuvreEtudeManager;
import batifree.api.metier.interfaces.IMainOeuvreEtude;

import common.api.dao.interfaces.IDao;

/**
 * Classe <MainOeuvreEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_MainOeuvreEtudeManager")
public class MainOeuvreEtudeManagerImpl extends MainOeuvreManagerImpl<IMainOeuvreEtude> implements IMainOeuvreEtudeManager {

	@Resource(name = "BF_MainOeuvreEtudeDao")
	private IMainOeuvreEtudeDao mainOeuvreEtudeDao;

	@Override
	protected IDao<IMainOeuvreEtude, Integer> getMainDao() {
		return mainOeuvreEtudeDao;
	}
}