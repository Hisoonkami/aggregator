package com.adev.aggregator.service;

import com.adev.aggregator.service.impl.AccountFeignClientImpl;
import com.adev.common.base.domian.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(value = "common-account", fallback = AccountFeignClientImpl.class)
public interface AccountFeignClient {
    @RequestMapping(value = {"/api/users"},method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<BaseResult> register(@RequestParam("loginName")String loginName,
                                        @RequestParam("password")String password,
                                        @RequestParam("username")String username);

    @RequestMapping(value = {"/api/roles"},method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<BaseResult> addRole(@RequestParam("roleName") String roleName,
                                       @RequestParam("roleCode") String roleCode,
                                       @RequestParam("remark") String remark,
                                       @RequestHeader("username") String username);

    @RequestMapping(value = {"/api/roles/{id}"},method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<BaseResult> updateRole(@PathVariable("id") Long id,
                                          @RequestParam("roleName") String roleName,
                                          @RequestParam("roleCode") String roleCode,
                                          @RequestParam("remark") String remark,
                                          @RequestHeader("username") String username);

    @RequestMapping(value = {"/api/roles/{id}"},method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<BaseResult> deleteRole(@PathVariable("id") Long id,
                                          @RequestHeader("username") String username);

    @RequestMapping(value = {"/api/roles"},method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<BaseResult> findAllRole();

    @RequestMapping(value = {"/api/roles/{id}/permissions"},method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<BaseResult> addPermissions(@PathVariable("id") Long id,
                                              @RequestHeader("permissionIds")Long[] permissionIds,
                                              @RequestHeader(value = "username",required = false) String username);

    @RequestMapping(value = {"/api/roles/search/findByUser"},method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<BaseResult> findRoleByUser(@RequestParam("userId") Long userId);

    /**
     * 授权
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping(value = {"/grantAuthorization"},method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<BaseResult> grantAuthorization(@RequestParam("userId") Long userId,
                                                  @RequestParam(value = "roleId")Long roleId);

    @RequestMapping(value = {"/api/permissions"},method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<BaseResult> addPermission(@RequestParam("permissionName") String permissionName,
                                             @RequestParam("permissionCode") String permissionCode,
                                             @RequestParam(value = "remark",required = false) String remark,
                                             @RequestHeader(value = "username",required = false) String username);

    @RequestMapping(value = {"/api/permissions/{id}"},method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<BaseResult> updatePermission(@PathVariable("id") Long id,
                                                @RequestParam(value = "permissionName",required = false) String permissionName,
                                                @RequestParam(value = "permissionCode",required = false) String permissionCode,
                                                @RequestParam(value = "remark",required = false) String remark,
                                                @RequestHeader(value = "username",required = false) String username);

    @RequestMapping(value = {"/api/permissions/{id}"},method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<BaseResult> deletePermission(@PathVariable("id") Long id,
                                                @RequestHeader(value = "username",required = false) String username);

    @RequestMapping(value = {"/api/permissions"},method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<BaseResult> findAllPermission();

    @RequestMapping(value = {"/api/permissions/search/findByRole"},method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<BaseResult> findByRole(@RequestParam("roleId") Long roleId);

    @RequestMapping(value = {"/api/accountBooks"},method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<BaseResult> orderPayment(@RequestParam("username") String username,
                                                   @RequestParam("exchange")String exchange,
                                                   @RequestParam("currencyPair")String currencyPair,
                                                   @RequestParam("price") BigDecimal price,
                                                   @RequestParam("number")BigDecimal number);
}
