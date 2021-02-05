package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductInfo {
  private String id;
  private List<ProductOption> list;
}
