package com.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entities.MutualFund;

@Repository
public interface MutualFundRepository extends CrudRepository<MutualFund, String>
{

}
