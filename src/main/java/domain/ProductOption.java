package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductOption {
  private String imageURL;
  private String title;
  private String description;
  private double price;
}
