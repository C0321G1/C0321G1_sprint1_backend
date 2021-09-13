package c0321g1_gaming.controller.computer;

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
import org.springframework.web.bind.annotation.*;

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

    //Get all Computer
    @GetMapping("/computer")
    public ResponseEntity<Iterable<Computer>> getAllComputer() {
        List<Computer> computers = computerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    //Get all computer page
    @GetMapping("/computerPage")
    public ResponseEntity<Page<Computer>> getAllComputerPage(@PageableDefault(value = 5) Pageable pageable) {
        Page<Computer> computers = computerService.getAllComputer(pageable);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    //Get all computer manufacturer
    @GetMapping("/computerManufacturer")
    public ResponseEntity<Iterable<ComputerManufacturer>> getAllComputerManufacturer() {
        List<ComputerManufacturer> computerManufacturers = computerManufacturerService.findAll();
        if (computerManufacturers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerManufacturers, HttpStatus.OK);
    }

    //Get all computer type
    @GetMapping("/computerType")
    public ResponseEntity<Iterable<ComputerType>> getAllComputerType() {
        List<ComputerType> computerTypes = computerTypeService.findAll();
        if (computerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerTypes, HttpStatus.OK);
    }

    //Get all computer status
    @GetMapping("/computerStatus")
    public ResponseEntity<Iterable<ComputerStatus>> getAllComputerStatus() {
        List<ComputerStatus> computerStatus = computerStatusService.findAll();
        if (computerStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerStatus, HttpStatus.OK);
    }

    //Get computer by id
    @GetMapping("/computer/{id}")
    public ResponseEntity<Optional<Computer>> getComputer(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findComputerById(id);
        if (!computer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }

    //Delete computer
    @DeleteMapping("/computer/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findComputerById(id);
        if (computer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.get().setFlagDelete(1);
        computerService.saveComputer(computer.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Search computer
    @GetMapping("/computer/searchComputer")
    public ResponseEntity<Page<Computer>> searchComputer(@PageableDefault(value = 5) Pageable pageable,
                                                         @RequestParam Optional<String> computerId,
                                                         @RequestParam Optional<String> location
                                                         ){
        String computerIdSearch= computerId.orElse("");
        String locationSearch= location.orElse("");
        /*
        String startDateFromSearch= startDateFrom.orElse("");
        String startDateToSearch= startDateTo.orElse("");
        String statusSearch= status.orElse("");
        String computerTypeSearch= computerType.orElse("");*/
        Page<Computer> computerSearchPage=computerService.searchComputer(computerIdSearch, locationSearch, pageable);
        if (computerSearchPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerSearchPage,HttpStatus.OK);
    }

}
