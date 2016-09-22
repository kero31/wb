/***********************************************************************
 * Module: IUserprojectDao.java Author: Kero Purpose: Defines the Interface IUserprojectDao
 ***********************************************************************/

package admin.api.dao.interfaces;

import admin.api.metier.id.UserprojectId;
import admin.api.metier.interfaces.IUserproject;

import common.api.dao.interfaces.IDao;

/**
 * Interface <b>IUserprojectDao</b><br/>
 */
public interface IUserprojectDao extends IDao<IUserproject, UserprojectId> {
}