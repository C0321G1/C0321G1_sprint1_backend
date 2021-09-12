package c0321g1_gaming.controller.services;

import c0321g1_gaming.dto.services.ServicesDto;
import c0321g1_gaming.model.entity.services.Services;
import c0321g1_gaming.model.service.services.IServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/services")
public class ServicesRestController {
    @Autowired
    IServicesService servicesService;

    @GetMapping("/{id}")
    public ResponseEntity<Services> findServiceById(@PathVariable Long id) {
        Services services = servicesService.findById(id);
        if (services == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Void> saveServices(@Valid @RequestBody ServicesDto servicesDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        Services services = new Services();
        BeanUtils.copyProperties(servicesDto,services);
        servicesService.save(services);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Services> editServices(@Valid @RequestBody ServicesDto servicesDto, BindingResult bindingResult,
                                                 @PathVariable Long id){
        Services services = servicesService.findById(id);
        if (services == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }else {
            Services services1 = new Services();
            servicesDto.setServicesId(services.getServicesId());
            BeanUtils.copyProperties(servicesDto,services1);
            servicesService.save(services1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
