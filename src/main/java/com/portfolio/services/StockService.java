package com.portfolio.services;

import com.portfolio.entities.Stock;

import lombok.NonNull;

public interface StockService
{
   public Stock addStock(@NonNull final Stock stock);

   public Stock findStockByName(String name);
}
