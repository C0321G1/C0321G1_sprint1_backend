package c0321g1_gaming.controller.computer;

import c0321g1_gaming.dto.computer.ComputerDto;
import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.entity.computer.ComputerType;
import c0321g1_gaming.model.service.computer.ComputerManufacturerService;
import c0321g1_gaming.model.service.computer.ComputerService;
import c0321g1_gaming.model.service.computer.ComputerStatusService;
import c0321g1_gaming.model.service.computer.ComputerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComputerRestController {
    @Autowired
    ComputerService computerService;

    @Autowired
    ComputerTypeService computerTypeService;

    @Autowired
    ComputerManufacturerService computerManufacturerService;

    @Autowired
    ComputerStatusService computerStatusService;

    /*Long-Computer*/
    @PostMapping("/create-computer")
    public ResponseEntity<Void> createComputer(@Valid @RequestBody ComputerDto computerDto, BindingResult bindingResult) {
        Computer computer = computerService.searchComputerCode(computerDto.getComputerCode());
        new ComputerDto().validate(computerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (computer == null) {
            Long manufacturerId = computerManufacturerService.
                    findByName(computerDto.getComputerManufacturer().getName()).
                    getComputerManufacturerId();
            Long computerTypeId = computerTypeService.findByName(computerDto.getComputerType()
                    .getName()).getComputerTypeId();
            Long computerStatusId = computerStatusService.findByName(computerDto.getComputerStatus()
                    .getName()).getComputerStatusId();
            computerService.createComputer(computerDto.getComputerCode(), computerDto.getLocation(),
                    computerDto.getStartUsedDate(), computerDto.getConfiguration(),
                    computerDto.getWarrantyPeriod(), computerDto.getFlagDelete(),
                    computerTypeId,
                    manufacturerId,
                    computerStatusId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*Long-Computer*/
    @PatchMapping("/update-computer/{id}")
    public ResponseEntity<Void> updateComputer(@Valid @RequestBody ComputerDto computerDto, BindingResult bindingResult,
                                               @PathVariable Long id) {
        Optional<Computer> computer = computerService.findComputerById(id);
        new ComputerDto().validate(computerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (computerDto.getComputerStatus().getName().equals("Đang sử dụng")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!computer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Long manufacturerId = computerManufacturerService.
                findByName(computerDto.getComputerManufacturer().getName()).
                getComputerManufacturerId();
        Long computerTypeId = computerTypeService.findByName(computerDto.getComputerType()
                .getName()).getComputerTypeId();
        Long computerStatusId = computerStatusService.findByName(computerDto.getComputerStatus()
                .getName()).getComputerStatusId();
        computerService.updateComputer(computerDto.getComputerCode(), computerDto.getLocation(),
                computerDto.getStartUsedDate(), computerDto.getConfiguration(),
                computerDto.getWarrantyPeriod(), computerTypeId,
                manufacturerId,
                computerStatusId, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //NguyenNHN - Get all Computer List
    @GetMapping("/computer")
    public ResponseEntity<Iterable<Computer>> getAllComputer() {
        List<Computer> computers = computerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    //NguyenNHN - Get all computer page
    @GetMapping("/computerPage")
    public ResponseEntity<Page<Computer>> getAllComputerPage(@PageableDefault(value = 5) Pageable pageable) {
        Page<Computer> computers = computerService.getAllComputer(pageable);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    //NguyenNHN - Get all computer manufacturer
    @GetMapping("/computerManufacturer")
    public ResponseEntity<Iterable<ComputerManufacturer>> getAllComputerManufacturer() {
        List<ComputerManufacturer> computerManufacturers = computerManufacturerService.findAll();
        if (computerManufacturers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerManufacturers, HttpStatus.OK);
    }
    //NguyenNHN - Get all computer type
    @GetMapping("/computerType")
    public ResponseEntity<Iterable<ComputerType>> getAllComputerType() {
        List<ComputerType> computerTypes = computerTypeService.findAll();
        if (computerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerTypes, HttpStatus.OK);
    }
    //NguyenNHN - Get all computer status
    @GetMapping("/computerStatus")
    public ResponseEntity<Iterable<ComputerStatus>> getAllComputerStatus() {
        List<ComputerStatus> computerStatus = computerStatusService.findAll();
        if (computerStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerStatus, HttpStatus.OK);
    }
    //NguyenNHN - Get computer by id
    @GetMapping("/computer/{id}")
    public ResponseEntity<Optional<Computer>> getComputer(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<Computer> computer = computerService.findComputerById(id);
        if (!computer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }
    //NguyenNHN - Delete computer
    @DeleteMapping("/computer/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<Computer> computer = computerService.findComputerById(id);
        if (!computer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (computer.get().getComputerStatus().getComputerStatusId() == 1) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        computer.get().setFlagDelete(1);
        computerService.saveComputer(computer.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //NguyenNHN - Search computer
    @GetMapping("/computer/searchComputer")
    public ResponseEntity<Page<Computer>> searchComputer(@PageableDefault(value = 5) Pageable pageable,
                                                         @RequestParam Optional<String> computerId,
                                                         @RequestParam Optional<String> location,
                                                         @RequestParam Optional<String> computerType,
                                                         @RequestParam Optional<String> computerStatus,
                                                         @RequestParam Optional<String> startDateFrom,
                                                         @RequestParam Optional<String> startDateTo
    ) {
        Page<Computer> computerSearchPage;
        String computerIdSearch = computerId.orElse("");
        String locationSearch = location.orElse("");
        String statusSearch = computerStatus.orElse("");
        String computerTypeSearch = computerType.orElse("");
        String startDateFromSearch = startDateFrom.orElse("");
        String startDateToSearch = startDateTo.orElse("");
        if(startDateToSearch.equals("") && !startDateFromSearch.equals("")){
            startDateToSearch = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
            computerSearchPage = computerService.searchComputer(computerIdSearch, locationSearch, computerTypeSearch,
                    statusSearch, startDateFromSearch, startDateToSearch, pageable);
            if (computerSearchPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(computerSearchPage, HttpStatus.OK);
        }

        if (startDateFromSearch.equals("") && startDateToSearch.equals("")) {
            computerSearchPage = computerService.searchComputer(computerIdSearch, locationSearch, computerTypeSearch,
                    statusSearch, pageable);
            if (computerSearchPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(computerSearchPage, HttpStatus.OK);
        } else {
            computerSearchPage = computerService.searchComputer(computerIdSearch, locationSearch, computerTypeSearch,
                    statusSearch, startDateFromSearch, startDateToSearch, pageable);
            if (computerSearchPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(computerSearchPage, HttpStatus.OK);
        }
    }
}



