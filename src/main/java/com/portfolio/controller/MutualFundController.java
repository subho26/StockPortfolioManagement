package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.entities.MutualFund;
import com.portfolio.services.MutualFundService;

public class MutualFundController
{
   @Autowired
   @Qualifier("MutualFundServiceImpl")
   private MutualFundService mutualFundService;

   @PostMapping
   public ResponseEntity<MutualFund> addMutualFund(@RequestBody final MutualFund mutualFund)
   {
      mutualFundService.addMutualFund(mutualFund);
      return new ResponseEntity<MutualFund>(HttpStatus.CREATED);
   }
}