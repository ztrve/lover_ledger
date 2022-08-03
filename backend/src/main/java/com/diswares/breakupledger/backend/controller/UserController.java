package com.diswares.breakupledger.backend.controller;

import com.diswares.breakupledger.backend.qo.user.UserLoginQo;
import com.diswares.breakupledger.backend.qo.user.UserRegisterQo;
import com.diswares.breakupledger.backend.service.user.UserService;
import com.diswares.breakupledger.backend.vo.user.UserLoginVo;
import com.diswares.breakupledger.backend.vo.user.UserRegisterVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: z_true
 * @date: 2022/7/26 14:41
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterVo register(@RequestBody UserRegisterQo userRegisterQo) {
        return userService.register(userRegisterQo);
    }

    @PostMapping("/login")
    public UserLoginVo loginVo(@RequestBody UserLoginQo loginQo) {
        return userService.login(loginQo);
    }
}
