package net.codesree.dao;

import java.io.Serializable;

public interface IDao<T> extends Serializable {
  T find(int id);
  T create(T obj);
  T update(T obj);
  void delete(T obj);
}
