package com.tasarim.tasarimprojesi.controller;


import com.tasarim.tasarimprojesi.dto.DegreeRequest;
import com.tasarim.tasarimprojesi.security.JwtUtils;
import com.tasarim.tasarimprojesi.service.RoboticArmService;
import com.tasarim.tasarimprojesi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final RoboticArmService roboticArmService;

    @PostMapping("/degrees")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void productList(@RequestBody DegreeRequest degreeRequest) throws InterruptedException {
        roboticArmService.setDegree(degreeRequest);

    }

}
