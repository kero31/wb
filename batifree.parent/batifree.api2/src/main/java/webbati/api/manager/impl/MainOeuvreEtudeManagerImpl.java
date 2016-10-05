package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMainOeuvreEtudeDao;
import webbati.api.manager.interfaces.IMainOeuvreEtudeManager;
import webbati.api.metier.interfaces.IMainOeuvreEtude;

/**
 * Classe <MainOeuvreEtudeManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_MainOeuvreEtudeManager")
public class MainOeuvreEtudeManagerImpl extends MainOeuvreManagerImpl<IMainOeuvreEtude> implements IMainOeuvreEtudeManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_MainOeuvreEtudeDao")
	private IMainOeuvreEtudeDao mainOeuvreEtudeDao;

	@Override
	protected IDao<IMainOeuvreEtude, Integer> getMainDao() {
		return mainOeuvreEtudeDao;
	}
}