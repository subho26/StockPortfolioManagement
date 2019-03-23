package com.portfolio.services;

import com.portfolio.entities.Stock;
import lombok.NonNull;

public interface StockService {
    Stock addOrUpdateStock(@NonNull final Stock stock);

    Stock findStockByName(@NonNull final String name);

    void deleteStock(@NonNull final Stock stock);
}
