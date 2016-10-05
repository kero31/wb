package webbati.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.api.dao.interfaces.IDao;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IImageDao;
import webbati.api.manager.interfaces.IImageManager;
import webbati.api.metier.interfaces.IImage;

/**
 * Classe <ImageManagerImpl>.
 * 
 * 
 * 
 */
@Service(ApplicationWb.CODE_PROJECT + "_ImageManager")
public class ImageManagerImpl extends BfGenericManagerImpl<IImage, Integer> implements IImageManager {

	@Resource(name = ApplicationWb.CODE_PROJECT + "_ImageDao")
	private IImageDao imageDao;

	@Override
	protected IDao<IImage, Integer> getMainDao() {
		return imageDao;
	}
}