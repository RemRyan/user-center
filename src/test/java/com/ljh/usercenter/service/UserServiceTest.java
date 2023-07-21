package com.ljh.usercenter.service;
import java.util.Date;

import com.ljh.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {


    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user=new User();
        user.setUsername("beidang");
        user.setUserAccount("123");
        user.setAvatarUrl("https://n.sinaimg.cn/sinakd20201023s/244/w640h404/20201023/4a64-kavypmq5171256.jpg");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "beidan";
        String userPassword = "";
        String checkPassword = "123456";
        String checkCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        userAccount = "be";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        userAccount = "beidan";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        userAccount = "bei dang";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        userAccount = "beidang";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
        userAccount = "beidangne";
        result = userService.userRegister(userAccount, userPassword, checkPassword,checkCode);
        Assertions.assertEquals(-1,result);
    }
}