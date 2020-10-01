package com.adev.aggregator.controller;

import com.adev.aggregator.service.AccountFeignClient;
import com.adev.common.base.domian.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "roles")
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @ApiOperation(value = "register", notes = "register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "loginName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
            @ApiImplicitParam(name = "username", value = "username", required = true, dataType = "String")

    })
    @RequestMapping(value = {"/register"},method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BaseResult> register(@RequestParam(value = "loginName") String loginName, @RequestParam(value = "password") String password,@RequestParam(value = "username") String username){
        return accountFeignClient.register(loginName,password,username);
    }
}
