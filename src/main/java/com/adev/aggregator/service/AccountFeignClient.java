package com.adev.aggregator.service;

import com.adev.aggregator.service.impl.AccountFeignClientImpl;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "common-account", fallback = AccountFeignClientImpl.class)
public interface AccountFeignClient {

}
