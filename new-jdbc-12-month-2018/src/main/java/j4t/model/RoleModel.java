package j4t.model;

import java.sql.Timestamp;

public class RoleModel extends AbstractModel<RoleModel> {

	private Long id;
	private String code;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleModel [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
