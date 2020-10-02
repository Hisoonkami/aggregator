package com.adev.aggregator.service.impl;

import com.adev.aggregator.service.GatherFeignClient;
import com.adev.common.base.domian.BaseResult;
import com.adev.common.base.enums.ResultEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


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
	public ResponseEntity<BaseResult> searcCurrencyPair(String pairName, String exchangeName, String currencySymbol, Integer page, Integer size, String sort) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> findOrderBookByExchangeAndPairName(String exchange, String pairName) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> addExchange(String name, String showName, String level, String logo, String website, String setupYear) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> updateExchange(Long id, String name, String showName, String level, String logo, String website, String setupYear) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> findAllExchange() {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> addCurrency(String name, String symbol, String issuetime, String issueprice, String website, String explorer, String whitepaper, String offcialWallet, String algorithm, String proof_type, String logo, BigDecimal total_supply, BigDecimal max_supply) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> updateCurrency(Long id, String name, String symbol, String issuetime, String issueprice, String website, String explorer, String whitepaper, String offcialWallet, String algorithm, String proof_type, String logo, BigDecimal total_supply, BigDecimal max_supply) {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}

	@Override
	public ResponseEntity<BaseResult> findAllCurrency() {
		return ResponseEntity.ok(BaseResult.failure(ResultEnum.INTERFACE_EXCEED_LOAD));
	}
}
