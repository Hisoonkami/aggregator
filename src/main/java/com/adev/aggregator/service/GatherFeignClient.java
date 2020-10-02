package com.adev.aggregator.service;

import com.adev.aggregator.service.impl.GatherFeignClientImpl;
import com.adev.common.base.domian.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

	@RequestMapping(value = {"/api/currencyPairs/search"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> searcCurrencyPair(@RequestParam(value = "pairName",required = false)String pairName,
														@RequestParam(value = "exchangeName",required = false)String exchangeName,
														@RequestParam(value = "currencySymbol",required = false)String currencySymbol,
														@RequestParam(value = "page",required = false,defaultValue = "0")Integer page,
														@RequestParam(value = "size",required = false,defaultValue = "15")Integer size,
														@RequestParam(value = "sort",required = false)String sort);

	@RequestMapping(value = {"/api/orderBooks/search/findByExchangeAndPairName"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findOrderBookByExchangeAndPairName(@RequestParam(value = "exchange") String exchange,@RequestParam(value = "pairName") String pairName);

	@RequestMapping(value = {"/api/exchanges"},method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<BaseResult> addExchange(@RequestParam(value = "name")String name,
												  @RequestParam(value = "showName")String showName,
												  @RequestParam(value = "level",required = false)String level,
												  @RequestParam(value = "logo",required = false)String logo,
												  @RequestParam(value = "website",required = false)String website,
												  @RequestParam(value = "setupYear",required = false)String setupYear);

	@RequestMapping(value = {"/api/exchanges/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<BaseResult> updateExchange(@PathVariable(value = "id") Long id,
													 @RequestParam(value = "name",required = false)String name,
													 @RequestParam(value = "showName",required = false)String showName,
													 @RequestParam(value = "level",required = false)String level,
													 @RequestParam(value = "logo",required = false)String logo,
													 @RequestParam(value = "website",required = false)String website,
													 @RequestParam(value = "setupYear",required = false)String setupYear);

	@RequestMapping(value = {"/api/exchanges"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findAllExchange();

	@RequestMapping(value = {"/api/currencies"},method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<BaseResult> addCurrency(@RequestParam(value = "name")String name,
												  @RequestParam(value = "symbol")String symbol,
												  @RequestParam(value = "issuetime",required = false)String issuetime,
												  @RequestParam(value = "issueprice",required = false)String issueprice,
												  @RequestParam(value = "website",required = false)String website,
												  @RequestParam(value = "explorer",required = false)String explorer,
												  @RequestParam(value = "whitepaper",required = false)String whitepaper,
												  @RequestParam(value = "offcialWallet",required = false)String offcialWallet,
												  @RequestParam(value = "algorithm",required = false)String algorithm,
												  @RequestParam(value = "proof_type",required = false)String proof_type,
												  @RequestParam(value = "logo",required = false)String logo,
												  @RequestParam(value = "total_supply",required = false) BigDecimal total_supply,
												  @RequestParam(value = "max_supply",required = false)BigDecimal max_supply);

	@RequestMapping(value = {"/api/currencies/{id}"},method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<BaseResult> updateCurrency(@PathVariable(value = "id") Long id,
													 @RequestParam(value = "name")String name,
													 @RequestParam(value = "symbol")String symbol,
													 @RequestParam(value = "issuetime",required = false)String issuetime,
													 @RequestParam(value = "issueprice",required = false)String issueprice,
													 @RequestParam(value = "website",required = false)String website,
													 @RequestParam(value = "explorer",required = false)String explorer,
													 @RequestParam(value = "whitepaper",required = false)String whitepaper,
													 @RequestParam(value = "offcialWallet",required = false)String offcialWallet,
													 @RequestParam(value = "algorithm",required = false)String algorithm,
													 @RequestParam(value = "proof_type",required = false)String proof_type,
													 @RequestParam(value = "logo",required = false)String logo,
													 @RequestParam(value = "total_supply",required = false)BigDecimal total_supply,
													 @RequestParam(value = "max_supply",required = false)BigDecimal max_supply);

	@RequestMapping(value = {"/api/currencies"},method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<BaseResult> findAllCurrency();
}
