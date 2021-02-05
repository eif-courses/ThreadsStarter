package service;

import domain.ProductInfo;
import domain.ProductOption;

import java.util.List;


// network call
public class ProductInfoService {
  public ProductInfo retrieveProductInfo(String id){
    List<ProductOption> productOptions = List.of(new ProductOption("https://images.macrumors.com/t/TcFHoKsAGU9PDfQ2o9sxuKAyOEE=/800x0/filters:quality(90)/article-new/2019/02/MR-Future-Products-2020-2.png?lossy",
        "Computer",
        "Personal computer", 2300.25),
        new ProductOption("https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1289&q=80",
            "Computer new one",
            "Personal computer", 2300.25),
        new ProductOption("https://images.macrumors.com/t/TcFHoKsAGU9PDfQ2o9sxuKAyOEE=/800x0/filters:quality(90)/article-new/2019/02/MR-Future-Products-2020-2.png?lossy",
            "Computer good one",
            "Personal computer", 2300.25));
    ProductInfo productInfo = new ProductInfo();
    productInfo.setId(id);
    productInfo.setList(productOptions);

    try {
      Thread.sleep(11);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    return productInfo;
  }

}
