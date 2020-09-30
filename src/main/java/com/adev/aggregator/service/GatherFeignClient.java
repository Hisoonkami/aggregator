package com.adev.aggregator.service;

import com.adev.aggregator.service.impl.GatherFeignClientImpl;
import com.adev.common.base.domian.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "gather",fallback = GatherFeignClientImpl.class)
public interface GatherFeignClient {

	@RequestMapping(value = {"/api/tickers/search/findByExchangeAndPairName"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findTickerByExchangeAndPairName(@RequestParam(value = "exchange") String exchange,@RequestParam(value = "pairName") String pairName);

	@RequestMapping(value = {"/api/currencyPairs"},method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<BaseResult> addCurrencyPair(@RequestParam(value = "exchange") String exchange,
											   @RequestParam(value = "pairName") String pairName,
											   @RequestParam(value = "currency") String currency,
											   @RequestParam(value = "counterName")String counterName);

	@RequestMapping(value = {"/api/currencyPairs/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<BaseResult> updateCurrencyPair(@PathVariable(value = "id") Long id,
												  @RequestParam(value = "exchange",required = false) String exchange,
												  @RequestParam(value = "pairName",required = false) String pairName,
												  @RequestParam(value = "currency",required = false) String currency,
												  @RequestParam(value = "counterName",required = false)String counterName);

	@RequestMapping(value = {"/api/currencyPairs/search/findByExchange"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findCurrencyPairByExchange(@RequestParam(value = "exchange") String exchange);

	@RequestMapping(value = {"/api/orderBooks/search/findByExchangeAndPairName"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findOrderBookByExchangeAndPairName(@RequestParam(value = "exchange") String exchange,@RequestParam(value = "pairName") String pairName);
	
}
