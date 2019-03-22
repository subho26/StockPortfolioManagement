/**
 * 
 */
package com.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, String>
{

   Stock findStockByName(String name);
}
