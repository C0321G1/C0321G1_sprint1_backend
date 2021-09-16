package c0321g1_gaming.payload.response;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.computer.AccountComputer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;

public class JwtResponse {

	//creator: Tra
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private Long categoryId;
	private Customer customer;
	private Employee employee;
	private List<AccountComputer> accountComputer;
	private List<String> roles;

	public JwtResponse(String token, Long id, String username, Long categoryId,  Customer customer, List<String> roles) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.categoryId = categoryId;
		this.customer = customer;
		this.roles = roles;
	}

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCategory() {
		return categoryId;
	}

	public void setCategory(Long categoryId) {
		this.categoryId = categoryId;
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

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
