package com.adev.aggregator.service.impl;

import com.adev.aggregator.service.GatherFeignClient;
import com.adev.common.base.domian.BaseResult;
import com.adev.common.base.enums.ResultEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GatherFeignClientImpl implements GatherFeignClient {


	@Override
	public ResponseEntity<BaseResult> findTickerByExchangeAndPairName(String exchange, String pairName) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> addCurrencyPair(String exchange, String pairName, String currency, String counterName) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> updateCurrencyPair(Long id, String exchange, String pairName, String currency, String counterName) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> findCurrencyPairByExchange(String exchange) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> findOrderBookByExchangeAndPairName(String exchange, String pairName) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}
}
