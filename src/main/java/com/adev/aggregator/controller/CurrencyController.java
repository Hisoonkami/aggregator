package com.adev.aggregator.controller;

import com.adev.aggregator.service.GatherFeignClient;
import com.adev.common.base.domian.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Api(value = "currencies")
@Controller
@RequestMapping(value = "/api/user/permission/manage_currency/currencies")
public class CurrencyController {

	private static final Logger LOG = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private GatherFeignClient gatherFeignClient;
	
	@ApiOperation(value = "addExchange", notes = "addExchange")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "name", value = "name",required = true, dataType = "String"),
			@ApiImplicitParam(name = "symbol", value = "symbol",required = true, dataType = "String"),
			@ApiImplicitParam(name = "issuetime", value = "issuetime", dataType = "String"),
			@ApiImplicitParam(name = "issueprice", value = "issueprice", dataType = "String"),
			@ApiImplicitParam(name = "website", value = "website", dataType = "String"),
			@ApiImplicitParam(name = "explorer", value = "explorer", dataType = "String"),
			@ApiImplicitParam(name = "whitepaper", value = "whitepaper", dataType = "String"),
			@ApiImplicitParam(name = "offcialWallet", value = "offcialWallet", dataType = "String"),
			@ApiImplicitParam(name = "algorithm", value = "algorithm", dataType = "String"),
			@ApiImplicitParam(name = "proof_type", value = "proof_type", dataType = "String"),
			@ApiImplicitParam(name = "logo", value = "logo", dataType = "String"),
			@ApiImplicitParam(name = "total_supply", value = "total_supply", dataType = "double"),
			@ApiImplicitParam(name = "max_supply", value = "max_supply", dataType = "double")
    })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseResult> addCurrency(@RequestParam(value = "name")String name,
												  @RequestParam(value = "symbol")String symbol,
												  @RequestParam(value = "issuetime",required = false)String issuetime,
												  @RequestParam(value = "issueprice",required = false)String issueprice,
												  @RequestParam(value = "website",required = false)String website,
												  @RequestParam(value = "explorer",required = false)String explorer,
												  @RequestParam(value = "whitepaper",required = false)String whitepaper,
												  @RequestParam(value = "offcialWallet",required = false)String offcialWallet,
												  @RequestParam(value = "algorithm",required = false)String algorithm,
												  @RequestParam(value = "proof_type",required = false)String proof_type,
												  @RequestParam(value = "logo",required = false)String logo,
												  @RequestParam(value = "total_supply",required = false) BigDecimal total_supply,
												  @RequestParam(value = "max_supply",required = false)BigDecimal max_supply){
		return gatherFeignClient.addCurrency(name, symbol,  issuetime,  issueprice,  website,  explorer,  whitepaper,  offcialWallet,  algorithm,  proof_type,  logo,  total_supply, max_supply);
	}

	@ApiOperation(value = "updateCurrency", notes = "updateCurrency")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
			@ApiImplicitParam(name = "id", value = "id", dataType = "long",paramType = "path"),
			@ApiImplicitParam(name = "name", value = "name", dataType = "String"),
			@ApiImplicitParam(name = "symbol", value = "symbol", dataType = "String"),
			@ApiImplicitParam(name = "issuetime", value = "issuetime", dataType = "String"),
			@ApiImplicitParam(name = "issueprice", value = "issueprice", dataType = "String"),
			@ApiImplicitParam(name = "website", value = "website", dataType = "String"),
			@ApiImplicitParam(name = "explorer", value = "explorer", dataType = "String"),
			@ApiImplicitParam(name = "whitepaper", value = "whitepaper", dataType = "String"),
			@ApiImplicitParam(name = "offcialWallet", value = "offcialWallet", dataType = "String"),
			@ApiImplicitParam(name = "algorithm", value = "algorithm", dataType = "String"),
			@ApiImplicitParam(name = "proof_type", value = "proof_type", dataType = "String"),
			@ApiImplicitParam(name = "logo", value = "logo", dataType = "String"),
			@ApiImplicitParam(name = "total_supply", value = "total_supply", dataType = "double"),
			@ApiImplicitParam(name = "max_supply", value = "max_supply", dataType = "double")
	})
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<BaseResult> updateCurrency(@PathVariable(value = "id") Long id,
													 @RequestParam(value = "name")String name,
													 @RequestParam(value = "symbol")String symbol,
													 @RequestParam(value = "issuetime",required = false)String issuetime,
													 @RequestParam(value = "issueprice",required = false)String issueprice,
													 @RequestParam(value = "website",required = false)String website,
													 @RequestParam(value = "explorer",required = false)String explorer,
													 @RequestParam(value = "whitepaper",required = false)String whitepaper,
													 @RequestParam(value = "offcialWallet",required = false)String offcialWallet,
													 @RequestParam(value = "algorithm",required = false)String algorithm,
													 @RequestParam(value = "proof_type",required = false)String proof_type,
													 @RequestParam(value = "logo",required = false)String logo,
													 @RequestParam(value = "total_supply",required = false)BigDecimal total_supply,
													 @RequestParam(value = "max_supply",required = false)BigDecimal max_supply){
		return gatherFeignClient.updateCurrency(id,name, symbol,  issuetime,  issueprice,  website,  explorer,  whitepaper,  offcialWallet,  algorithm,  proof_type,  logo,  total_supply, max_supply);
	}

	@ApiOperation(value = "findAllCurrency", notes = "findAllCurrency")
	@ApiImplicitParams({

	})
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BaseResult> findAllCurrency(){
		return gatherFeignClient.findAllCurrency();
	}
}
