/**
 * 
 */
package admin.api.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.dao.interfaces.IVScriptUpdateDao;
import admin.api.metier.ejb.VScriptupdate;
import admin.api.metier.impl.VScriptUpdateImpl;
import admin.api.metier.interfaces.IVScriptUpdate;

import common.api.application.interfaces.IApplicationCommun;
import common.api.dao.hibernate.impl.HibernateViewDaoImpl;
import common.api.dao.hibernate.util.QueryHibernateUtil;
import common.api.dao.hibernate.util.UserServiceHibernateImpl;
import common.api.exception.WebbatiException;

/**
 * Classe <VScriptUpdateDaoImpl>.
 * 
 * @author Kero
 * 
 */
@Repository("ADMIN_VScriptUpdateDao")
public class VScriptUpdateDaoImpl extends HibernateViewDaoImpl<VScriptupdate, VScriptUpdateImpl, IVScriptUpdate> implements IVScriptUpdateDao {

	/**
	 * 
	 * Constructeur.
	 */
	public VScriptUpdateDaoImpl() {
		super(VScriptupdate.class, VScriptUpdateImpl.class);
	}

	@Override
	protected IApplicationCommun getApplication() throws WebbatiException {
		return ApplicationAdmin.getApplication();
	}

	@Override
	public List<IVScriptUpdate> getListByProjectId(Integer pProjectId) throws WebbatiException {
		if (pProjectId == null) {
			throw new WebbatiException("L'id du projet ne peut pas être vide.");
		}
		// Résultats
		List<IVScriptUpdate> listRet = new ArrayList<IVScriptUpdate>();

		// Crée la requête sur la vue
		String query = "select URL, DRIVER, LOGIN, PASSWORD, FILENAME, USERAPPLI_ID, PROJECTSCRIPT_ID from V_SCRIPTUPDATE " + "where PROJECT_ID="
		        + pProjectId;
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) new QueryHibernateUtil((UserServiceHibernateImpl) ApplicationAdmin.getApplication().getUserService())
		        .executeQuery(query);

		// Parcours toutes les lignes
		for (Object[] line : list) {

			// Récupère les infos de la requête
			int ind = 0;
			String url = (String) line[ind++];
			if (url == null) {
				throw new WebbatiException("url NULL");
			}
			String driver = (String) line[ind++];
			if (driver == null) {
				throw new WebbatiException("driver NULL");
			}
			String login = (String) line[ind++];
			if (login == null) {
				throw new WebbatiException("login NULL");
			}
			String password = (String) line[ind++];
			if (password == null) {
				password = "";
			}
			String filename = (String) line[ind++];
			Integer userproject_id = (Integer) line[ind++];
			if (userproject_id == null) {
				throw new WebbatiException("userproject_id NULL");
			}
			Integer projectScript_id = (Integer) line[ind++];
			if (projectScript_id == null) {
				throw new WebbatiException("projectScript_id NULL");
			}

			VScriptUpdateImpl resultat = new VScriptUpdateImpl();
			resultat.setDriver(driver);
			resultat.setLogin(login);
			resultat.setPassword(password);
			resultat.setUrl(url);
			resultat.setFilename(filename);
			resultat.setProjectscriptId(projectScript_id);
			resultat.setUserprojectId(userproject_id);
			listRet.add(resultat);

		}
		return listRet;
	}

}
