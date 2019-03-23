package com.portfolio.controller;

import com.portfolio.entities.Stock;
import com.portfolio.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    @Qualifier("StockServiceImpl")
    private StockService stockService;

    @PostMapping(value = "/create")
    public ResponseEntity<Stock> addStock(@RequestBody final Stock stock) {
        final Stock newStock = stockService.addStock(stock);
        return new ResponseEntity<Stock>(newStock, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Stock> getStock(@PathVariable final String name) {
        final Stock stock = stockService.findStockByName(name);
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }

    @PutMapping(value = "/createOrUpdate")
    public ResponseEntity<Stock> addOrUpdateStock(@RequestBody final Stock stock) {
        final Stock existingStock = stockService.findStockByName(stock.getName());
        if (existingStock != null) {
            int quantity = existingStock.getQuantity() + stock.getQuantity();
            double price = (existingStock.getPrice() * existingStock.getQuantity() + stock.getPrice() * stock.getQuantity()) / quantity;
            existingStock.setPrice(price);
            existingStock.setQuantity(quantity);
            stockService.addStock(existingStock);
            return new ResponseEntity<>(existingStock, HttpStatus.OK);
        }
        final Stock newStock = stockService.addStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }
    // TODO: update, delete functionality
}