package common.api.application.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import common.api.application.interfaces.IApplicationCommun;
import common.api.application.interfaces.IFormat;
import common.api.application.interfaces.IImpression;
import common.api.application.interfaces.IPropertiesApp;
import common.api.application.interfaces.IUserService;
import common.api.exception.BatifreeException;
import common.api.exception.BatifreeUserException;
import common.api.metier.interfaces.IUserApp;
import common.api.util.ServiceBeanFactory;

/**
 * 
 * Classe/Interface <ApplicationCommun>
 *
 */
public abstract class ApplicationCommun implements IApplicationCommun {

	/** Le code projet. */
	private final String codeProject;

	/** Permet de savoir si les Services ont été initiliasé ou non. */
	private boolean isServicesInitialized = false;

	/** Le Format service. */
	@Resource(name = "Format")
	private IFormat formatService;

	/** Le PropertiesApp service. */
	@Resource(name = "PropertiesApp")
	private IPropertiesApp propertiesAppService;

	/** Le IImpressionJasper service. */
	@Resource(name = "ImpressionJasper")
	private IImpression impressionService;

	/**
	 * Constructeur par défaut
	 * 
	 * @param pCodeProject code projet
	 */
	public ApplicationCommun(String pCodeProject) {
		this.codeProject = pCodeProject;
	}

	/**
	 * Retourne le code projet
	 * 
	 * @return code projet
	 */
	public String getCodeProject() {
		return codeProject;
	}

	/**
	 * Initialise les services s'ils n'ont pas déjà été initialisés.
	 */
	@PostConstruct
	protected void initialiseServices() {
		// Teste si l'initialisation n'a pas déjé été faite
		if (!isServicesInitialized) {
			IUserService userService;
			userService = getUserService();
			if (userService != null) {
				boolean bdPasswordEncoded;
				try {
					bdPasswordEncoded = new Boolean(getProperties().getProperty(IPropertiesApp.BD_ADMIN_PASSWORD_ENCODE, "false"));
				} catch (BatifreeException e) {
					bdPasswordEncoded = false;
				}
				userService.setBdPasswordEncoded(bdPasswordEncoded);
			}

			// Marque l'initialisation comme faite
			isServicesInitialized = true;
		}
	}

	@Override
	public void loadUserByUsernamePassword(String pUsername, String pPassword) throws BatifreeUserException {
		UserDetails user;
		try {
			user = loadUserByUsername(pUsername);
		} catch (UsernameNotFoundException e) {
			throw new BatifreeUserException(e.getMessage());
		}

		if (user == null || pPassword == null || !pPassword.equals(user.getPassword())) {
			throw new BatifreeUserException("Le mot de passe n'est pas correct");
		}
	}

	/**
	 * Méthode à recharger quand on veut récupérer le user à partir du username pour spring security <br/>
	 * Returns a populated {@link UserDetails} object. The username is first retrieved from the database and then mapped to a {@link UserDetails}
	 * object.
	 * 
	 * @param pUsername The username
	 * @return populated {@link UserDetails} object
	 */
	public UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException {
		return null;
	}

	/**
	 * Retourne le user details par rapport au userapp
	 * 
	 * @param pUserApp userapp
	 * 
	 * @return user details
	 */
	protected UserDetails getUserDetailsByUserApp(IUserApp pUserApp) throws UsernameNotFoundException {
		boolean enabled = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		try {
			// Enregistre le user dans spring
			setUserApp(pUserApp);

			// Crée l'utilisateur spring security
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(pUserApp.getUsername(),
					pUserApp.getPassword(), enabled, !pUserApp.getLocked(), credentialsNonExpired, accountNonLocked,
					getGrantedAuthorities(pUserApp.getListRole()));

			return user;
		} catch (BatifreeUserException | BatifreeException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param pRoles {@link String} of roles
	 * @return list of granted authorities
	 */
	protected List<GrantedAuthority> getGrantedAuthorities(List<String> pRoles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : pRoles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public void setUserApp(IUserApp pUser) throws BatifreeUserException, BatifreeException {
		getUserService().updateInfoUserApp(pUser);
	}

	@Override
	public void deconnection() throws BatifreeException {
		getUserService().closeSessions();
	}

	@Override
	public IFormat getFormat() {
		return formatService;
	}

	@Override
	public IPropertiesApp getProperties() {
		return propertiesAppService;
	}

	@Override
	public IImpression getImpression() {
		return impressionService;
	}

	/**
	 * Retourne le Manager correspond à la classe clazz
	 * 
	 * @param <T> classe
	 * @param pClazz classe
	 * @return Manager correspond à la classe clazz
	 * @throws BatifreeException
	 */
	protected <T> T getManager(Class<T> pClazz) throws BatifreeException {
		checkValidUser();
		return ServiceBeanFactory.getServiceBean(pClazz);
	}

	/**
	 * Valide l'utilisateur
	 * 
	 * @return TRUE si l'user a été validé, FALSE sinon
	 * @throws BatifreeException
	 */
	protected boolean checkValidUser() throws BatifreeException {
		return getUserService().checkValidUser();
	}
}
