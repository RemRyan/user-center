package com.ljh.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -8130739277588879204L;

    private String userAccount;

    private String userPassword;
}
