package admin.api.metier.ejb;

// Generated 3 mars 2014 23:09:58 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "ROLE")
@SuppressWarnings("serial")
public class Role implements java.io.Serializable {

	private Integer id;
	private Project project;
	private Integer projectId;
	private String code;
	private Set<Userappli> userapplis = new HashSet<Userappli>(0);

	public Role() {
	}

	public Role(Project project, String code, Set<Userappli> userapplis) {
		this.project = project;
		this.code = code;
		this.userapplis = userapplis;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROL_ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRO_ID", insertable = false, updatable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "PRO_ID")
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer pProjectId) {
		projectId = pProjectId;
	}

	@Column(name = "ROL_CODE", length = 65535)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<Userappli> getUserapplis() {
		return this.userapplis;
	}

	public void setUserapplis(Set<Userappli> userapplis) {
		this.userapplis = userapplis;
	}
}
