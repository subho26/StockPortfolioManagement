package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

   @PostMapping(value="/create")
   public ResponseEntity<Stock> addStock(@RequestBody final Stock stock)
   {
      final Stock newStock = stockService.addStock(stock);
      return new ResponseEntity<Stock>(newStock, HttpStatus.CREATED);
   }
   
   @GetMapping(value="/{name}")
   public ResponseEntity<Stock> getStock(@PathVariable final String name)
   {
      final Stock stock = stockService.findStockByName(name);
      return new ResponseEntity<Stock>(stock, HttpStatus.CREATED);
   }
   
   //TODO: update, delete functionality
}