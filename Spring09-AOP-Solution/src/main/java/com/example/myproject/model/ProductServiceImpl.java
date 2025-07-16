package com.example.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  // 공통 로그 컴포넌트를 사용하기 위해 객체 생성한다.
  @Override
  public void updateProduct() {
    System.out.println(getClass().getName()+" core concern updateProduct");
  }
  @Override
  public void findProductById() {
    System.out.println(getClass().getName()+" core concern findProductById");
  }
  @Override
  public void findProductByName() {
    System.out.println(getClass().getName()+" core concern findProductByName");
  }
  @Override
  public void findProductByMaker() {
    System.out.println(getClass().getName()+" core concern findProductByMaker");
  }
}
