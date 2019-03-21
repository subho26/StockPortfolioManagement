package com.portfolio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entities.Stock;
import com.portfolio.repository.StockRepository;
import com.portfolio.services.StockService;

import lombok.NonNull;

@Service(value = "StockServiceImpl")
public class StockServiceImpl implements StockService
{
   @Autowired
   private StockRepository stockRepository;

   @Override
   public Stock addStock(@NonNull final Stock stock)
   {
      return stockRepository.save(stock);
   }
}
