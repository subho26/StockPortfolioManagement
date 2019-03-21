package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entities.Stock;
import com.portfolio.services.StockService;

@RestController
@RequestMapping("/stock")
public class StockController
{
   @Autowired
   @Qualifier("StockServiceImpl")
   private StockService stockService;

   @PostMapping
   public ResponseEntity<Stock> addMutualFund(@RequestBody final Stock stock)
   {
      stockService.addStock(stock);
      return new ResponseEntity<Stock>(HttpStatus.CREATED);
   }
}