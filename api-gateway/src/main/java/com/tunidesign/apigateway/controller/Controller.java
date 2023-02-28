package com.tunidesign.apigateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
@RestController
public class Controller {
    static Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/user")
    public String index(Principal principal) {
        logger.info(String.valueOf(principal));
        return principal.getName();
    }
}