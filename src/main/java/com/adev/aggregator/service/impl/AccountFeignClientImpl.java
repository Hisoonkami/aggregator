package com.adev.aggregator.service.impl;

import com.adev.common.base.domian.BaseResult;
import com.adev.common.base.enums.ResultEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adev.aggregator.service.AccountFeignClient;

import java.math.BigDecimal;

@Service
public class AccountFeignClientImpl implements AccountFeignClient {

    @Override
    public ResponseEntity<BaseResult> register(String loginName, String password, String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> addRole(String roleName, String roleCode, String remark,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> updateRole(Long id, String roleName, String roleCode, String remark,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> deleteRole(Long id,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> findAllRole() {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> addPermissions(Long id, Long[] permissionIds,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> findRoleByUser(Long userId) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> grantAuthorization(Long userId, Long roleId) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> addPermission(String permissionName, String permissionCode, String remark,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> updatePermission(Long id, String permissionName, String permissionCode, String remark,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> deletePermission(Long id,String username) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> findAllPermission() {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> findByRole(Long roleId) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }

    @Override
    public ResponseEntity<BaseResult> orderPayment(String username, String exchange, String currencyPair, BigDecimal price, BigDecimal number) {
        return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
    }
}
