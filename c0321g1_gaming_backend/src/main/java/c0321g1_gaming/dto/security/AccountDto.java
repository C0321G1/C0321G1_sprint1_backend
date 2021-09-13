package c0321g1_gaming.dto.security;
import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.computer.AccountComputer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Role;


import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AccountDto {
	private Long AccountId;
	private String username;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
	private Category category;
	private Customer customer;
	private Employee employee;
	private List<AccountComputer> accountComputer;
	public AccountDto() {
	}

	public AccountDto(Long accountId, String username, String email, String password, Set<Role> roles, Category category, Customer customer, Employee employee, List<AccountComputer> accountComputer) {
		AccountId = accountId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.category = category;
		this.customer = customer;
		this.employee = employee;
		this.accountComputer = accountComputer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<AccountComputer> getAccountComputer() {
		return accountComputer;
	}

	public void setAccountComputer(List<AccountComputer> accountComputer) {
		this.accountComputer = accountComputer;
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
