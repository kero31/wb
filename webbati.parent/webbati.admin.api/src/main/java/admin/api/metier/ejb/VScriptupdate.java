package admin.api.metier.ejb;

// Generated 9 ao�t 2013 22:29:28 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VScriptupdate generated by hbm2java
 */
@Entity
@Table(name = "V_SCRIPTUPDATE")
@SuppressWarnings("serial")
public class VScriptupdate implements java.io.Serializable {

	private VScriptupdateId id;

	public VScriptupdate() {
	}

	public VScriptupdate(VScriptupdateId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "url", column = @Column(name = "URL", length = 16777215)),
		@AttributeOverride(name = "driver", column = @Column(name = "DRIVER", length = 65535)),
		@AttributeOverride(name = "login", column = @Column(name = "LOGIN", length = 65535)),
		@AttributeOverride(name = "password", column = @Column(name = "PASSWORD", length = 65535)),
		@AttributeOverride(name = "filename", column = @Column(name = "FILENAME", length = 65535)),
		@AttributeOverride(name = "id", column = @Column(name = "PROJECT_ID", nullable = false)),
		@AttributeOverride(name = "id_1", column = @Column(name = "USERPROJECT_ID", nullable = false)),
		@AttributeOverride(name = "id_2", column = @Column(name = "PROJECTSCRIPT_ID", nullable = false)) })
	public VScriptupdateId getId() {
		return this.id;
	}

	public void setId(VScriptupdateId id) {
		this.id = id;
	}

}
