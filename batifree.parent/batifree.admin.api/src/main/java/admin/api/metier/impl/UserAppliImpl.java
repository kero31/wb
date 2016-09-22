package admin.api.metier.impl;

import java.util.Date;
import java.util.List;

import admin.api.application.impl.ApplicationAdmin;
import admin.api.metier.interfaces.IRole;
import admin.api.metier.interfaces.IUserAppli;
import admin.api.metier.interfaces.IUserproject;

import common.api.exception.BatifreeException;
import common.api.metier.impl.MetierImpl;

/**
 * 
 * Classe/Interface <b>UserAppliImpl</b><br/>
 *
 */
public class UserAppliImpl extends MetierImpl<Integer> implements IUserAppli {

	/**
	 * Le champs serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String mail;
	private Date dateCreate;
	private Date dateExpired;
	private Boolean locked;
	private List<IRole> listRole;
	private Integer userappliParentId;

	@Override
	public final List<IRole> getListRole() throws BatifreeException {
		return listRole == null ? ApplicationAdmin.getApplication().getUserAppliManager().getListRole(this) : listRole;
	}

	@Override
	public void setListRole(List<IRole> pListRole) {
		listRole = pListRole;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String pUsername) {
		this.username = pUsername;
	}

	@Override
	public List<IUserproject> getListUserproject() throws BatifreeException {
		return ApplicationAdmin.getApplication().getUserAppliManager().getListUserproject(this);
	}

	@Override
	public Date getDateCreate() {
		return dateCreate;
	}

	@Override
	public void setDateCreate(Date pDateCreate) {
		this.dateCreate = pDateCreate;
	}

	@Override
	public Date getDateExpired() {
		return dateExpired;
	}

	@Override
	public void setDateExpired(Date pDateExpired) {
		this.dateExpired = pDateExpired;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String pPassword) {
		this.password = pPassword;
	}

	@Override
	public String getMail() {
		return mail;
	}

	@Override
	public void setMail(String pMail) {
		this.mail = pMail;
	}

	/**
	 * Get Locked
	 * 
	 * @return Locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	@Override
	public Boolean isLocked() {
		return getValue(locked);
	}

	@Override
	public void setLocked(Boolean pLocked) {
		this.locked = pLocked;
	}

	/**
	 * Get Userappli Parent Id
	 * 
	 * @return Userappli Parent Id
	 */
	public Integer getUserappliParentId() {
		return this.userappliParentId;
	}

	/**
	 * Set Userappli Parent Id
	 * 
	 * @param pUserappliParentId Userappli Parent Id
	 */
	public void setUserappliParentId(Integer pUserappliParentId) {
		this.userappliParentId = pUserappliParentId;
	}

	@Override
	public IUserAppli getUserappliParent() throws BatifreeException {
		return ApplicationAdmin.getApplication().getUserAppliManager().getById(userappliParentId);
	}

	@Override
	public void setUserappliParent(IUserAppli pUserappliParent) {
		if (pUserappliParent != null) {
			userappliParentId = pUserappliParent.getId();
		} else {
			userappliParentId = null;
		}
	}

}