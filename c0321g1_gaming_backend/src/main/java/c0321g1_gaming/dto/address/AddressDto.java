package c0321g1_gaming.dto.address;

import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;

public class AddressDto {
    private Long addressId;
    private Province province;
    private District district;
    private Commune commune;
    private List<Customer> customerList;
    private List<Employee> employeeList;
    public AddressDto() {
    }


    public AddressDto(Long addressId, Province province, District district, Commune commune, List<Customer> customerList, List<Employee> employeeList) {

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
