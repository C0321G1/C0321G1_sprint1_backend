package c0321g1_gaming.model.entity.address;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @ManyToOne
    @JoinColumn(name = "provinceId", referencedColumnName = "provinceId")
    private Province province;
    @ManyToOne
    @JoinColumn(name = "districtId", referencedColumnName = "districtId")
    private District district;
    @ManyToOne
    @JoinColumn(name = "communeId", referencedColumnName = "communeId")
    private Commune commune;
    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    @JsonBackReference(value = "address-customer")
    private List<Customer> customerList;

<<<<<<< HEAD
    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    @JsonBackReference(value = "address-employee")
=======
   @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
   @JsonBackReference
>>>>>>> origin
    private List<Employee> employeeList;

    public Address() {
    }

    public Address(Long addressId, Province province, District district, Commune commune, List<Customer> customerList, List<Employee> employeeList) {
        this.addressId = addressId;
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.customerList = customerList;
        this.employeeList = employeeList;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}


