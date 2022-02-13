package br.com.letscode.desafio.controller;

import br.com.letscode.desafio.domain.response.access.LoginResponse;
import br.com.letscode.desafio.domain.response.access.LogoutResponse;
import br.com.letscode.desafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/access")
@RestController
public class AccessController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/login")
    public LoginResponse login() {
        return new LoginResponse(userService.getContextUsername());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/logout")
    public LogoutResponse logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new LogoutResponse(userService.getContextUsername());
    }

}
