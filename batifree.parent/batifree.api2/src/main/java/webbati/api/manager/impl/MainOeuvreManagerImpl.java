package webbati.api.manager.impl;

import org.springframework.stereotype.Service;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.manager.interfaces.IMainOeuvreManager;
import webbati.api.metier.interfaces.IMainOeuvre;

/**
 * 
 * Classe/Interface <b>MainOeuvreManagerImpl</b><br/>
 *
 * @param <IT> IMainOeuvre
 */
@Service(ApplicationWb.CODE_PROJECT + "_MainOeuvreManager")
public abstract class MainOeuvreManagerImpl<IT extends IMainOeuvre> extends BibliothequeElementManagerImpl<IT> implements IMainOeuvreManager<IT> {

}