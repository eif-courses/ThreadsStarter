package service;

import domain.ProductRating;

public class ProductRatingService {
  public ProductRating retrieveProductRating(String id){
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new ProductRating(4, 3.8);
  }
}
