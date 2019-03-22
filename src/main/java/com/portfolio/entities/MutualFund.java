package com.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mutual_fund_table")
public class MutualFund
{
   @Id
   @SequenceGenerator(name = "mutual_fund_id_seq", sequenceName = "mutual_fund_id_seq", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mutual_fund_id_seq")
   @Column(name = "id", nullable = false)
   private long   id;
   @Column(name = "name", nullable = false, unique = true)
   private String name;
   @Column(name = "units", nullable = false)
   private int    units;
   @Column(name = "unit_price", nullable = false)
   private double unitPrice;
}
