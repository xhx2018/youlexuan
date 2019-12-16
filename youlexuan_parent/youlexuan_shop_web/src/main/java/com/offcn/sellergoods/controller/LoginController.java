package com.offcn.sellergoods.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 邢会兴
 * date 2019/11/14   15:26
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/getName")
    public String getName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return  name;
    }

}
