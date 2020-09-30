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
@Api(value = "roles")
@RequestMapping(value = "/api/user/permissions/manage_role/roles")
public class RoleController {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @ApiOperation(value = "addRole", notes = "addRole")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "roleName", value = "roleName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "roleCode", value = "roleCode", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "remark", dataType = "String"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")

    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BaseResult> addRole(@RequestParam(value = "roleName") String roleName,
                                              @RequestParam(value = "roleCode") String roleCode,
                                              @RequestParam(value = "remark",required = false) String remark,
                                              @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.addRole(roleName,roleCode,remark,username);
    }

    @ApiOperation(value = "updateRole", notes = "updateRole")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "roleName", value = "roleName", dataType = "String"),
            @ApiImplicitParam(name = "roleCode", value = "roleCode", dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "remark", dataType = "String"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")

    })
    @RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<BaseResult> updateRole(@PathVariable(value = "id") Long id,
                                                 @RequestParam(value = "roleName",required = false) String roleName,
                                                 @RequestParam(value = "roleCode",required = false) String roleCode,
                                                 @RequestParam(value = "remark",required = false) String remark,
                                                 @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.updateRole(id,roleName,roleCode,remark,username);
    }

    @ApiOperation(value = "deleteRole", notes = "deleteRole")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")
    })
    @RequestMapping(value = {"/{id}"},method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<BaseResult> deleteRole(@PathVariable("id") Long id,
                                                 @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.deleteRole(id,username);
    }

    @ApiOperation(value = "findAllRole", notes = "findAllRole")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header")
    })
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<BaseResult> findAllRole(){
        return accountFeignClient.findAllRole();
    }

    @ApiOperation(value = "addPermissions", notes = "addPermissions")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "permissionIds", value = "permissionIds", required = true,allowMultiple = true,dataType = "long"),
            @ApiImplicitParam(name = "username", value = "username", dataType = "String",paramType = "header")

    })
    @RequestMapping(value = {"/{id}/permissions"},method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<BaseResult> addPermissions(@PathVariable("id") Long id,
                                                     @RequestHeader("permissionIds") Long[] permissionIds,
                                                     @RequestHeader(value = "username",required = false) String username){
        return accountFeignClient.addPermissions(id,permissionIds,username);
    }

    @ApiOperation(value = "findByUser", notes = "findByUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "long")

    })
    @RequestMapping(value = {"/search/findByUser"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<BaseResult> findByUser(@RequestParam("userId") Long userId){
        return accountFeignClient.findRoleByUser(userId);
    }

    @ApiOperation(value = "grantAuthorization", notes = "grantAuthorization")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "long"),
            @ApiImplicitParam(name = "roleId", value = "roleId", required = true, dataType = "long")

    })
    @RequestMapping(value = {"/grantAuthorization"},method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BaseResult> grantAuthorization(@RequestParam("userId") Long userId,
                                                         @RequestParam(value = "roleId")Long roleId){
        return accountFeignClient.grantAuthorization(userId,roleId);
    }
}
