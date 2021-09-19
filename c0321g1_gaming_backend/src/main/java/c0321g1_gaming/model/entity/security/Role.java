package c0321g1_gaming.model.entity.security;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Enumerated(EnumType.STRING)
	private ERole name;

	public Role() {

	}

	public Role(Integer roleId, ERole name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
