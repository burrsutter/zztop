package com.burrsutter.zztop;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Todo
 */
@Entity
public class Todo extends PanacheEntity{
  public String title;
  @Column(name = "ordering")
  public int order;
  public boolean completed;
}