package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @@ -24,4 +26,16 @@
            return authService.authenticate(login);
}

//    put - update data
// @PreAuthorize("hasRole('ADMIN')")
@PutMapping("/{id}")
public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails emp){
    return authService.updateEmployee(id,emp);
}

//getbyroles
@GetMapping("/roles/{roles}")
public List<RegisterDetails> getEmployeeByRole(@PathVariable String roles){
    return authService.getAllEmployeesByRoleSer(roles);
}
}