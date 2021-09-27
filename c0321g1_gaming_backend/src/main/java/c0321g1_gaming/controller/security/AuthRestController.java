package c0321g1_gaming.controller.security;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.service.category.CategoryService;
import c0321g1_gaming.model.service.computer.ComputerService;
import c0321g1_gaming.model.service.user_detail_service_impl.UserDetailsImpl;
import c0321g1_gaming.payload.request.LoginRequest;
import c0321g1_gaming.payload.response.JwtResponse;
import c0321g1_gaming.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    ComputerService computerService;

    Computer computerValues;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CategoryService categoryService;

    //creator: Tra
    @PostMapping("signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Optional<Category> categoryOptional = categoryService.finById(userDetails.getCategoryId());
        if (categoryOptional.isPresent()) {
            if(categoryOptional.get().getFee() != null && Integer.parseInt(categoryOptional.get().getFee()) > 0) {
                //thời gian bắt đầu sử dụng
                String startTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date(System.currentTimeMillis()));
                categoryOptional.get().setStartTime(startTime);

                Calendar calendar = Calendar.getInstance();

                //thời gian tối đa có thể sử dụng
                double timeDouble = Double.parseDouble(categoryOptional.get().getFee()) / 20000 * 60 * 60;
                int timeInt = (int) timeDouble;

                //thời gian sẽ kết thúc
                calendar.add(Calendar.SECOND, timeInt);
                Date end = calendar.getTime();
                String endTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(end);
                categoryOptional.get().setEndTime(endTime);
                categoryService.saveCategory(categoryOptional.get());

                List<Computer> computerList = computerService.findAll();

                for (Computer computer : computerList) {
                    if (computer.getComputerStatus().getComputerStatusId() == 2) {
                        computerValues = computer;

                        computerService.setComputerStatusOnline(Math.toIntExact(computerValues.getComputerId()));
                        break;
                    }
                }
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }


        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountId(),
                userDetails.getUsername(),
                userDetails.getCategoryId(),
                userDetails.getCustomer(),
                roles));
    }
    @PatchMapping("singout")
    public ResponseEntity<Void> logout() {
        computerService.setComputerStatusOffline(Math.toIntExact(computerValues.getComputerId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

