package com.portfolio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entities.MutualFund;
import com.portfolio.repository.MutualFundRepository;
import com.portfolio.services.MutualFundService;

@Service(value = "MutualFundServiceImpl")
public class MutualFundServiceImpl implements MutualFundService
{
   @Autowired
   private MutualFundRepository mutualFundRepository;

   @Override
   public MutualFund addMutualFund(MutualFund mutualFund)
   {
      return mutualFundRepository.save(mutualFund);
   }
}
