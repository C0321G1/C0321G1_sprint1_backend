package c0321g1_gaming.model.entity.security;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.computer.AccountComputer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "accountId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Employee employee;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<AccountComputer> accountComputer;

    public Account() {
    }




}
