package com.example.myproject.model;

import org.springframework.stereotype.Service;

import com.example.myproject.common.CommonOutputLogging;

@Service
public class ProductServiceImpl implements ProductService {
  // 공통 로그 컴포넌트를 사용하기 위해 객체 생성한다.
  private CommonOutputLogging logger = new CommonOutputLogging();
  @Override
  public void updateProduct() {
    System.out.println(getClass().getName()+" core concern updateProduct");
  }
  @Override
  public void findProductById() {
    logger.log(getClass().getName(), "findProductById");
    System.out.println(getClass().getName()+" core concern findProductById");
  }
  @Override
  public void findProductByName() {
    logger.log(getClass().getName(), "findProductByName");
    System.out.println(getClass().getName()+" core concern findProductByName");
  }
  @Override
  public void findProductByMaker() {
    logger.log(getClass().getName(), "findProductByMaker");
    System.out.println(getClass().getName()+" core concern findProductByMaker");
  }
}
