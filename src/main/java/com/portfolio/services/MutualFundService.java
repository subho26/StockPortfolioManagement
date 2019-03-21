package com.portfolio.services;

import com.portfolio.entities.MutualFund;

import lombok.NonNull;

public interface MutualFundService
{
   public MutualFund addMutualFund(@NonNull final MutualFund mutualFund);
}
