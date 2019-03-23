package com.portfolio.services.impl;

import com.portfolio.entities.Stock;
import com.portfolio.repository.StockRepository;
import com.portfolio.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "StockServiceImpl")
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock addOrUpdateStock(final Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findStockByName(String name) {
        return stockRepository.findStockByName(name);
    }

    @Override
    public void deleteStock(Stock stock) {
        stockRepository.delete(stock);
    }
}
