package batifree.api.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import batifree.api.dao.interfaces.IImageDao;
import batifree.api.manager.interfaces.IImageManager;
import batifree.api.metier.interfaces.IImage;

import common.api.dao.interfaces.IDao;

/**
 * Classe <ImageManagerImpl>.
 * 
 * 
 * 
 */
@Service("BF_ImageManager")
public class ImageManagerImpl extends BfGenericManagerImpl<IImage, Integer> implements IImageManager {

	@Resource(name = "BF_ImageDao")
	private IImageDao imageDao;

	@Override
	protected IDao<IImage, Integer> getMainDao() {
		return imageDao;
	}
}