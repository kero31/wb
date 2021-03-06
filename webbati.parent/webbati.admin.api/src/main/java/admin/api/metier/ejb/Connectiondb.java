package admin.api.metier.ejb;

// Generated 9 ao�t 2013 22:29:28 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Connectiondb generated by hbm2java
 */
@Entity
@Table(name = "CONNECTIONDB")
@SuppressWarnings("serial")
public class Connectiondb implements java.io.Serializable {

	private Integer id;
	private String driver;
	private String url;
	private String dialect;
	private Integer limitUserAlert;
	private String rootLogin;
	private String rootPassword;
	private String rootDbname;
	private Boolean enabled;
	private Set<Userproject> userprojects = new HashSet<Userproject>(0);

	public Connectiondb() {
	}

	public Connectiondb(String driver, String url, String dialect, Integer limitUserAlert, String rootLogin, String rootPassword, String rootDbname,
	        Boolean enabled, Set<Userproject> userprojects) {
		this.driver = driver;
		this.url = url;
		this.dialect = dialect;
		this.limitUserAlert = limitUserAlert;
		this.rootLogin = rootLogin;
		this.rootPassword = rootPassword;
		this.rootDbname = rootDbname;
		this.enabled = enabled;
		this.userprojects = userprojects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CON_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "CON_DRIVER", length = 65535)
	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	@Column(name = "CON_URL", length = 65535)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "CON_DIALECT", length = 65535)
	public String getDialect() {
		return this.dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	@Column(name = "CON_LIMIT_USER_ALERT")
	public Integer getLimitUserAlert() {
		return this.limitUserAlert;
	}

	public void setLimitUserAlert(Integer limitUserAlert) {
		this.limitUserAlert = limitUserAlert;
	}

	@Column(name = "CON_ROOT_LOGIN", length = 65535)
	public String getRootLogin() {
		return this.rootLogin;
	}

	public void setRootLogin(String rootLogin) {
		this.rootLogin = rootLogin;
	}

	@Column(name = "CON_ROOT_PASSWORD", length = 65535)
	public String getRootPassword() {
		return this.rootPassword;
	}

	public void setRootPassword(String rootPassword) {
		this.rootPassword = rootPassword;
	}

	@Column(name = "CON_ROOT_DBNAME", length = 65535)
	public String getRootDbname() {
		return this.rootDbname;
	}

	public void setRootDbname(String rootDbname) {
		this.rootDbname = rootDbname;
	}

	@Column(name = "CON_ENABLED")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "connectiondb")
	public Set<Userproject> getUserprojects() {
		return this.userprojects;
	}

	public void setUserprojects(Set<Userproject> userprojects) {
		this.userprojects = userprojects;
	}
}
