package c0321g1_gaming.dto.security;

import c0321g1_gaming.dto.category.CategoryDto;
import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.dto.employee.EmployeeDto;
import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class AccountDto {
	private Long AccountId;
	private String username;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
	private Category category;
	private Customer customerDto;
	private Employee employeeDto;
	public AccountDto() {
	}

	public AccountDto(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getAccountId() {
		return AccountId;
	}

	public void setAccountId(Long accountId) {
		this.AccountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
