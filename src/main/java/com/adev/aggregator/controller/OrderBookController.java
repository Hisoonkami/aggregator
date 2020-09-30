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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "orderBooks")
@Controller
@RequestMapping(value = "/api/orderBooks")
public class OrderBookController {

	private static final Logger LOG = LoggerFactory.getLogger(OrderBookController.class);
	
	@Autowired
	private GatherFeignClient gatherFeignClient;

	@ApiOperation(value = "findByExchangeAndPairName", notes = "findByExchangeAndPairName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exchange", value = "exchange", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pairName", value = "pairName", required = true, dataType = "String")

    })
	@RequestMapping(value = {"/search/findByExchangeAndPairName"},method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BaseResult> findByExchangeAndPairName(@RequestParam(value = "exchange") String exchange,@RequestParam(value = "pairName") String pairName){
		return gatherFeignClient.findOrderBookByExchangeAndPairName(exchange,pairName);
	}
}
