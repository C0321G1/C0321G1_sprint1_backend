package c0321g1_gaming.model.service.user_detail_service_impl;

import c0321g1_gaming.model.entity.computer.AccountComputer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    //creator: Tra

    private static final long serialVersionUID = 1L;

    private Long accountId;
    private String username;
    private Long categoryId;
    private Customer customer;
    private Employee employee;
    private List<AccountComputer> accountComputer;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long accountId, String username, Long categoryId, Customer customer,
                           Employee employee, List<AccountComputer> accountComputer, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.username = username;
        this.categoryId = categoryId;
        this.customer = customer;
        this.employee = employee;
        this.accountComputer = accountComputer;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        if (account.getCategory() == null) {
            return new UserDetailsImpl(
                    account.getAccountId(),
                    account.getUsername(),
                    null,
                    account.getCustomer(),
                    account.getEmployee(),
                    account.getAccountComputer(),
                    account.getPassword(),
                    authorities);
        }

        return new UserDetailsImpl(
                account.getAccountId(),
                account.getUsername(),
                account.getCategory().getCategoryId(),
                account.getCustomer(),
                account.getEmployee(),
                account.getAccountComputer(),
                account.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<AccountComputer> getAccountComputer() {
        return accountComputer;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(accountId, user.accountId);
    }
}
