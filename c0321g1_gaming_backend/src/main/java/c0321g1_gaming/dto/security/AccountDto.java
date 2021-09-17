package c0321g1_gaming.dto.security;
import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Role;


import java.util.HashSet;


import java.util.Set;


public class AccountDto {

    private Long AccountId;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private Category category;
    private Customer customerDto;
    private Employee employeeDto;

    public AccountDto() {
    }

	public AccountDto(Long accountId, String username, String password, Set<Role> roles, Category category,
					  Customer customerDto, Employee employeeDto) {
		AccountId = accountId;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.category = category;
		this.customerDto = customerDto;
		this.employeeDto = employeeDto;
	}

	public Long getAccountId() {
		return AccountId;
	}

	public void setAccountId(Long accountId) {
		AccountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Customer getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(Customer customerDto) {
		this.customerDto = customerDto;
	}

	public Employee getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(Employee employeeDto) {
		this.employeeDto = employeeDto;
	}
}
