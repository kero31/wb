package common.api.metier.application;

import common.api.application.impl.UserAppImpl;

/**
 * 
 * Classe/Interface <b>Role</b><br/>
 *
 */
public class Role {

	private int id;
	private UserAppImpl user;
	private int role;

	/**
	 * 
	 * Constructeur.
	 */
	public Role() {
		super();
	}

	/**
	 * Retourne l'id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param pId id
	 */
	public void setId(int pId) {
		this.id = pId;
	}

	/**
	 * Retourne l'user
	 * 
	 * @return user
	 */
	public UserAppImpl getUser() {
		return user;
	}

	/**
	 * Set user
	 * 
	 * @param pUser user
	 */
	public void setUser(UserAppImpl pUser) {
		this.user = pUser;
	}

	/**
	 * Retourne le role
	 * 
	 * @return role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * Set role
	 * 
	 * @param pRole role
	 */
	public void setRole(int pRole) {
		this.role = pRole;
	}

}
