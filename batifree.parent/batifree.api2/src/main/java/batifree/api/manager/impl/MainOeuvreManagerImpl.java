package batifree.api.manager.impl;

import org.springframework.stereotype.Service;

import batifree.api.manager.interfaces.IMainOeuvreManager;
import batifree.api.metier.interfaces.IMainOeuvre;

/**
 * 
 * Classe/Interface <b>MainOeuvreManagerImpl</b><br/>
 *
 * @param <IT> IMainOeuvre
 */
@Service("BF_MainOeuvreManager")
public abstract class MainOeuvreManagerImpl<IT extends IMainOeuvre> extends BibliothequeElementManagerImpl<IT> implements IMainOeuvreManager<IT> {

}