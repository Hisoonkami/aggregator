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

@Api(value = "exchanges")
@Controller
@RequestMapping(value = "/api/user/permission/manage_exchang/exchanges")
public class ExchangeController {

	private static final Logger LOG = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private GatherFeignClient gatherFeignClient;
	
	@ApiOperation(value = "addExchange", notes = "addExchange")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "name", value = "name",required = true, dataType = "String"),
			@ApiImplicitParam(name = "showName", value = "showName",required = true, dataType = "String"),
			@ApiImplicitParam(name = "level", value = "level", dataType = "String"),
			@ApiImplicitParam(name = "website", value = "website", dataType = "String"),
			@ApiImplicitParam(name = "setupYear", value = "setupYear", dataType = "String")
    })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseResult> addExchange(@RequestParam(value = "name")String name,
												  @RequestParam(value = "showName")String showName,
												  @RequestParam(value = "level",required = false)String level,
												  @RequestParam(value = "logo",required = false)String logo,
												  @RequestParam(value = "website",required = false)String website,
												  @RequestParam(value = "setupYear",required = false)String setupYear){
		return gatherFeignClient.addExchange(name,showName,level,logo,website,setupYear);
	}

	@ApiOperation(value = "updateExchange", notes = "updateExchange")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization", dataType = "String",paramType = "header"),
			@ApiImplicitParam(name = "id", value = "id",required = true, dataType = "long",paramType = "path"),
			@ApiImplicitParam(name = "name", value = "name",required = true, dataType = "String"),
			@ApiImplicitParam(name = "showName", value = "showName",required = true, dataType = "String"),
			@ApiImplicitParam(name = "level", value = "level", dataType = "String"),
			@ApiImplicitParam(name = "website", value = "website", dataType = "String"),
			@ApiImplicitParam(name = "setupYear", value = "setupYear", dataType = "String")
	})
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<BaseResult> updateExchange(@PathVariable(value = "id") Long id,
													 @RequestParam(value = "name",required = false)String name,
													 @RequestParam(value = "showName",required = false)String showName,
													 @RequestParam(value = "level",required = false)String level,
													 @RequestParam(value = "logo",required = false)String logo,
													 @RequestParam(value = "website",required = false)String website,
													 @RequestParam(value = "setupYear",required = false)String setupYear){
		return gatherFeignClient.updateExchange(id,name,showName,level,logo,website,setupYear);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BaseResult> findAllExchange(){
		return gatherFeignClient.findAllExchange();
	}
}
