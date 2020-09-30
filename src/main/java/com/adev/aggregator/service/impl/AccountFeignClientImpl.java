package com.adev.aggregator.service.impl;

import com.adev.common.base.domian.BaseResult;
import com.adev.common.base.enums.ResultEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adev.aggregator.service.AccountFeignClient;

import java.util.List;

@Service
public class AccountFeignClientImpl implements AccountFeignClient {

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
}
