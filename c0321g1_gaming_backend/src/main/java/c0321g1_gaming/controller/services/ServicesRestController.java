package c0321g1_gaming.controller.services;

import c0321g1_gaming.dto.services.ServicesDto;
import c0321g1_gaming.model.entity.services.Services;
import c0321g1_gaming.model.entity.services.Unit;
import c0321g1_gaming.model.service.services.IServicesService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "services")
public class ServicesRestController {
    @Autowired
    private IServicesService servicesService;
    //    khanh
    @GetMapping("/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable Long id) {
        try {
            Services services = servicesService.findById(id);
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else if (id == 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else if (services == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //khanh
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    //    khanh
    @PostMapping(value = "/create")
    public ResponseEntity<Void> saveServices(@Valid @RequestBody ServicesDto servicesDto) {
        try {
            Services services = new Services();
            System.out.println(servicesDto);
            BeanUtils.copyProperties(servicesDto, services);
            Unit unit = new Unit();
            unit.setUnitId(servicesDto.getUnit().getUnitId());
            services.setFlag(1);
            services.setUnit(unit);
            servicesService.save(services);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //khanh
    @PatchMapping("{id}")
    public ResponseEntity<Services> editServices(@Valid @RequestBody ServicesDto servicesDto,
                                                 @PathVariable Long id) {
        try {

            Services services = servicesService.findById(id);
            if (services == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }  else {
                Services services1 = new Services();
                servicesDto.setServicesId(services.getServicesId());
                BeanUtils.copyProperties(servicesDto, services1);
                Unit unit = new Unit();
                unit.setUnitId(servicesDto.getUnit().getUnitId());
                services1.setUnit(unit);
                services1.setFlag(1);
                servicesService.update(services1);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // phap
    @GetMapping("")
    public ResponseEntity<Page<Services>> pageServicesAll(@PageableDefault(value = 5) Pageable pageable, Optional<String> name) {
        String keyword = "";
        try {
            if (name.isPresent()) {
                keyword = name.get();
            }
            Page<Services> servicesPage = servicesService.pageServicesAll(keyword, pageable);
            if (servicesPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(servicesPage, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    phap
    @GetMapping("/searchNameCodePrices")
    public ResponseEntity<Page<Services>> pageServicesCodeNamePrices(@PageableDefault(value = 5) Pageable pageable, Optional<String> code,
                                                                     Optional<String> name, Optional<String> prices) {
        try {
            String keywordCode = code.orElse("");
            String keywordName = name.orElse("");
            String keywordPrices = prices.orElse("");
            Page<Services> servicesPage = servicesService.pageServicesCodeNamePrices(keywordCode, keywordName, keywordPrices, pageable);
            return new ResponseEntity<>(servicesPage, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    phap
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Services> deleteServices(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Services services = servicesService.findById(id);
            if (services == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                services.setFlag(0);
                servicesService.update(services);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
