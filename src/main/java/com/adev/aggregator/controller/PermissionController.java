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

@Controller
@Api(value = "permissions")
@RequestMapping(value = "/api/user/permissions/manage_permission/permissions")
public class PermissionController {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @ApiOperation(value = "addPermission", notes = "andPermission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "permissionName", value = "permissionName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "permissionCode", value = "permissionCode", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "remark", dataType = "String"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")

    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BaseResult> addPermission(@RequestParam(value = "permissionName") String permissionName,
                                                    @RequestParam(value = "permissionCode") String permissionCode,
                                                    @RequestParam(value = "remark",required = false) String remark,
                                                    @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.addPermission(permissionName,permissionCode,remark,username);
    }

    @ApiOperation(value = "updatePermission", notes = "updatePermission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "permissionName", value = "permissionName", dataType = "String"),
            @ApiImplicitParam(name = "permissionCode", value = "permissionCode", dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "remark", dataType = "String"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")

    })
    @RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<BaseResult> updatePermission(@PathVariable(value = "id") Long id,
                                                       @RequestParam(value = "permissionName",required = false) String permissionName,
                                                       @RequestParam(value = "permissionCode",required = false) String permissionCode,
                                                       @RequestParam(value = "remark",required = false) String remark,
                                                       @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.updatePermission(id,permissionName,permissionCode,remark,username);
    }

    @ApiOperation(value = "deletePermission", notes = "deletePermission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")
    })
    @RequestMapping(value = {"/{id}"},method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<BaseResult> deletePermission(@PathVariable("id") Long id,
                                                       @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.deletePermission(id,username);
    }

    @ApiOperation(value = "findAllPermission", notes = "findAllPermission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header")
    })
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<BaseResult> findAllPermission(){
        return accountFeignClient.findAllPermission();
    }

    @ApiOperation(value = "findByUser", notes = "findByUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "roleId", value = "roleId", required = true, dataType = "long")

    })
    @RequestMapping(value = {"/search/findByRole"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<BaseResult> findByRole(@RequestParam("roleId") Long roleId){
        return accountFeignClient.findByRole(roleId);
    }
}
