import domain.Product;
import domain.ProductInfo;
import domain.ProductRating;
import service.ProductInfoService;
import service.ProductRatingService;
import ui.ProductUI;

import javax.swing.*;
import java.net.MalformedURLException;

public class ProductService {

  ProductInfoService productInfoService;
  ProductRatingService productRatingService;

  public ProductService(ProductInfoService productInfoService, ProductRatingService productRatingService) {
    this.productInfoService = productInfoService;
    this.productRatingService = productRatingService;
  }
  public Product retrieveProductDetails(String id){

    ProductRating productRating = productRatingService.retrieveProductRating(id);
    ProductInfo productInfo = productInfoService.retrieveProductInfo(id);

    return new Product(id, productInfo, productRating);
  }


  public static void main(String[] args) {
    ProductInfoService infoService = new ProductInfoService();
    ProductRatingService ratingService = new ProductRatingService();
    ProductService productService = new ProductService(infoService, ratingService);

    String id = "EIF";

    Product product = productService.retrieveProductDetails(id);

    System.out.println(product.getInfo().getList());


    SwingUtilities.invokeLater(()->{
      try {
        new ProductUI(product);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    });





  }
}
