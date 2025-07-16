package com.example.spring07.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * final field로 ItemDao선언
 * Constructor Injection DI
 * 
 * 
 */
@Service
public class ItemService {
  private final ItemDao itemDao;
  
  // 생성자를 통한 DI
  // @Autowired // 생략 가능
  public ItemService(ItemDao itemDao) {
    super();
    this.itemDao = itemDao;
  }
  
  //  public String findItemById(String id) throws SQLException {}
  public String findItemById(String id) throws SQLException {
    return itemDao.findItemById(id);
  }
}
