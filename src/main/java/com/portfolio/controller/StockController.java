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

    @GetMapping(value = "/{name}")
    public ResponseEntity<Stock> getStock(@PathVariable final String name) {
        final Stock stock = stockService.findStockByName(name);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PutMapping(value = "/buystock")
    public ResponseEntity<Stock> buyStock(@RequestBody final Stock stock) {
        final Stock existingStock = stockService.findStockByName(stock.getName());
        if (existingStock != null) {
            int quantity = existingStock.getQuantity() + stock.getQuantity();
            double price = (existingStock.getPrice() * existingStock.getQuantity()
                    + stock.getPrice() * stock.getQuantity()) / quantity;
            existingStock.setPrice(price);
            existingStock.setQuantity(quantity);
            stockService.addOrUpdateStock(existingStock);
            return new ResponseEntity<>(existingStock, HttpStatus.OK);
        }
        final Stock newStock = stockService.addOrUpdateStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }

    @PutMapping(value = "/sellstock")
    public ResponseEntity<Stock> sellStock(@RequestBody final Stock stock) {
        final Stock existingStock = stockService.findStockByName(stock.getName());
        if (existingStock != null && stock.getQuantity() < 0) {
            if (existingStock.getQuantity() == Math.abs(stock.getQuantity())) {
                stockService.deleteStock(existingStock);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            //TODO: add profit and loss functionality
            int quantity = existingStock.getQuantity() + stock.getQuantity();
            existingStock.setQuantity(quantity);
            stockService.addOrUpdateStock(existingStock);
            return new ResponseEntity<>(existingStock, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}