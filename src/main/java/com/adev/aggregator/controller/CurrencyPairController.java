package com.adev.aggregator.controller;

import com.adev.aggregator.service.GatherFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adev.common.base.domian.BaseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "currencyPairs")
@Controller
@RequestMapping(value = "/api/currencyPairs")
public class CurrencyPairController {

	private static final Logger LOG = LoggerFactory.getLogger(CurrencyPairController.class);
	
	@Autowired
	private GatherFeignClient gatherFeignClient;
	
	@ApiOperation(value = "addCurrencyPair", notes = "addCurrencyPair")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "exchange", value = "exchange",required = true, dataType = "String"),
			@ApiImplicitParam(name = "pairName", value = "pairName",required = true, dataType = "String"),
			@ApiImplicitParam(name = "currency", value = "currency",required = true, dataType = "String"),
			@ApiImplicitParam(name = "counterName", value = "counterName",required = true, dataType = "String")
    })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseResult> addCurrencyPair(@RequestParam(value = "exchange") String exchange,
													  @RequestParam(value = "pairName") String pairName,
													  @RequestParam(value = "currency") String currency,
													  @RequestParam(value = "counterName")String counterName){
		return gatherFeignClient.addCurrencyPair(exchange,pairName,currency,counterName);
	}
	
	@ApiOperation(value = "updateCurrencyPair", notes = "updateCurrencyPair")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
			@ApiImplicitParam(name = "id", value = "id",required = true, dataType = "long",paramType = "path"),
			@ApiImplicitParam(name = "exchange", value = "exchange",dataType = "String"),
			@ApiImplicitParam(name = "pairName", value = "pairName",dataType = "String"),
			@ApiImplicitParam(name = "currency", value = "currency", dataType = "String"),
			@ApiImplicitParam(name = "counterName", value = "counterName",dataType = "String")
    })
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<BaseResult> updateCurrencyPair(@PathVariable(value = "id") Long id,
												  @RequestParam(value = "exchange",required = false) String exchange,
												  @RequestParam(value = "pairName",required = false) String pairName,
												  @RequestParam(value = "currency",required = false) String currency,
												  @RequestParam(value = "counterName",required = false)String counterName){
		return gatherFeignClient.updateCurrencyPair(id,exchange, pairName, currency,counterName);
	}
	
	@ApiOperation(value = "findByExchange", notes = "findByExchange")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "exchange", value = "exchange", dataType = "String"),

    })
	@RequestMapping(value = {"/search/findByExchange"},method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BaseResult> findByExchange(@RequestParam(value = "exchange") String exchange){
		return gatherFeignClient.findCurrencyPairByExchange(exchange);
	}
}
