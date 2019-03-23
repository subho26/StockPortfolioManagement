package com.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Entity
//@Data
@Getter
@Setter
@Table(name = "stock_table")
public class Stock
{
   @Id
   @SequenceGenerator(name = "stock_id_seq", sequenceName = "stock_id_seq", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_id_seq")
   @Column(name = "id", nullable = false)
   private long   id;
   @Column(name = "name", nullable = false, unique = true)
   private String name;
   @Column(name = "quantity", nullable = false)
   private int    quantity;
   @Column(name = "price", nullable = false)
   private double price;
}
