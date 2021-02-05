package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private String id;
  private ProductInfo info;
  private ProductRating rating;
}
