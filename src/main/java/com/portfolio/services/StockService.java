package com.portfolio.services;

import com.portfolio.entities.Stock;

import lombok.NonNull;

public interface StockService {
    Stock addStock(@NonNull final Stock stock);

    Stock findStockByName(String name);
}
