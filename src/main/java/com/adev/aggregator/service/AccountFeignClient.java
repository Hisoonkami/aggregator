package com.adev.aggregator.service;

import com.adev.aggregator.service.impl.AccountFeignClientImpl;
import com.adev.common.base.domian.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "common-account", fallback = AccountFeignClientImpl.class)
public interface AccountFeignClient {
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
                                              @RequestHeader("username") String username);

    @RequestMapping(value = {"/api/roles/search/findByUser"},method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<BaseResult> findRoleByUser(@RequestParam("userId") Long userId);
}
