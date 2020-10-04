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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Api(value = "accountBooks")
@Controller
@RequestMapping(value = "/api/user/accountBooks")
public class AccountBookController {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @ApiOperation(value = "addExchange", notes = "addExchange")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "exchange", value = "exchange",required = true, dataType = "String"),
            @ApiImplicitParam(name = "currencyPair", value = "currencyPair",required = true, dataType = "String"),
            @ApiImplicitParam(name = "price", value = "price",required = true, dataType = "double"),
            @ApiImplicitParam(name = "number", value = "number",required = true, dataType = "double")
    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BaseResult> orderPayment(@RequestHeader("username") String username,
                                                   @RequestParam("exchange")String exchange,
                                                   @RequestParam("currencyPair")String currencyPair,
                                                   @RequestParam("price")BigDecimal price,
                                                   @RequestParam("number")BigDecimal number){
        return accountFeignClient.orderPayment(username,exchange,currencyPair,price,number);
    }
}
