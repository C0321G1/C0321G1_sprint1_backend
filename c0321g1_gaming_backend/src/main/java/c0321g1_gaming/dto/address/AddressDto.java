package c0321g1_gaming.dto.address;

import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.dto.employee.EmployeeDto;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;

public class AddressDto {
    private Long addressId;
    private ProvinceDto provinceDto;
    private DistrictDto districtDto;
    private CommuneDto communeDto;
    private List<Customer> customerDtoList;
    private List<Employee> employeeDtoList;
    public AddressDto() {
    }

    public AddressDto(Long addressId, ProvinceDto provinceDto, DistrictDto districtDto, CommuneDto communeDto, List<Customer> customerDtoList, List<Employee> employeeDtoList) {
        this.addressId = addressId;
        this.provinceDto = provinceDto;
        this.districtDto = districtDto;
        this.communeDto = communeDto;
        this.customerDtoList = customerDtoList;
        this.employeeDtoList = employeeDtoList;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public ProvinceDto getProvinceDto() {
        return provinceDto;
    }

    public void setProvinceDto(ProvinceDto provinceDto) {
        this.provinceDto = provinceDto;
    }

    public DistrictDto getDistrictDto() {
        return districtDto;
    }

    public void setDistrictDto(DistrictDto districtDto) {
        this.districtDto = districtDto;
    }

    public CommuneDto getCommuneDto() {
        return communeDto;
    }

    public void setCommuneDto(CommuneDto communeDto) {
        this.communeDto = communeDto;
    }

    public List<Customer> getCustomerDtoList() {
        return customerDtoList;
    }

    public void setCustomerDtoList(List<Customer> customerDtoList) {
        this.customerDtoList = customerDtoList;
    }

    public List<Employee> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<Employee> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

}
