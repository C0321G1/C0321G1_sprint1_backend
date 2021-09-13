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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/computer")
    public ResponseEntity<Iterable<Computer>> getAllComputer() {
        List<Computer> computers = computerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/computerPage")
    public ResponseEntity<Page<Computer>> getAllComputerPage(@PageableDefault(value = 5) Pageable pageable) {
        Page<Computer> computers = computerService.getAllComputer(pageable);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/computerManufacturer")
    public ResponseEntity<Iterable<ComputerManufacturer>> getAllComputerManufacturer() {
        List<ComputerManufacturer> computerManufacturers = computerManufacturerService.findAll();
        if (computerManufacturers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerManufacturers, HttpStatus.OK);
    }

    @GetMapping("/computerType")
    public ResponseEntity<Iterable<ComputerType>> getAllComputerType() {
        List<ComputerType> computerTypes = computerTypeService.findAll();
        if (computerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerTypes, HttpStatus.OK);
    }

    @GetMapping("/computerStatus")
    public ResponseEntity<Iterable<ComputerStatus>> getAllComputerStatus() {
        List<ComputerStatus> computerStatus = computerStatusService.findAll();
        if (computerStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerStatus, HttpStatus.OK);
    }

    @GetMapping("/computer/{id}")
    public ResponseEntity<Optional<Computer>> getComputer(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findComputerById(id);
        if (!computer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }

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

    /*Long-Computer*/
    @PostMapping("/create-computer")
    public ResponseEntity<Void> createComputer(@RequestBody ComputerDto computerDto) {
        Computer computer = computerService.searchComputerCode(computerDto.getComputerCode());
        if (computer == null){
            computerService.createComputer(computerDto.getComputerCode(),computerDto.getLocation(),
                    computerDto.getStartUsedDate(),computerDto.getConfiguration(),
                    computerDto.getWarrantyPeriod(),computerDto.getFlagDelete(),
                    computerDto.getComputerType().getComputerTypeId(),
                    computerDto.getComputerManufacturer().getComputerManufacturerId(),
                    computerDto.getComputerStatus().getComputerStatusId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*Long-Computer*/
    @PutMapping("/update-computer/{id}")
    public ResponseEntity<Void> updateComputer(@Valid @RequestBody ComputerDto computerDto,
                                               BindingResult bindingResult,
                                               @PathVariable Long id) {
        Computer computer = computerService.findComputerById(id).get();
        if (computer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.updateComputer(computerDto.getComputerCode(),computerDto.getLocation(),
                computerDto.getStartUsedDate(),computerDto.getConfiguration(),
                computerDto.getWarrantyPeriod(),computerDto.getComputerType().getComputerTypeId(),
                computerDto.getComputerManufacturer().getComputerManufacturerId(),
                computerDto.getComputerStatus().getComputerStatusId(),id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
