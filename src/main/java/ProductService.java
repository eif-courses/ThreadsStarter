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
  public Product retrieveProductDetails(String id) throws InterruptedException {

    ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable(id);
    ProductRatingRunnable productRatingRunnable = new ProductRatingRunnable(id);

    Thread ratingThread = new Thread(productRatingRunnable);
    Thread infoThread = new Thread(productInfoRunnable);
    long start = System.currentTimeMillis();
    ratingThread.start();
    infoThread.start();

    infoThread.join();
    ratingThread.join();


    ProductInfo productInfo = productInfoRunnable.getProductInfo();
    ProductRating productRating = productRatingRunnable.getProductRating();

    long end = System.currentTimeMillis();
    System.err.println("It takes: " + (end - start) + " ms");

    return new Product(id, productInfo, productRating);
  }


  public static void main(String[] args) throws InterruptedException {
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
  private class ProductInfoRunnable implements Runnable{

    private String id;
    private ProductInfo productInfo;

    public ProductInfoRunnable(String id) {
      this.id = id;
    }

    public ProductInfo getProductInfo() {
      return productInfo;
    }

    public String getId() {
      return id;
    }

    @Override
    public void run() {
      productInfo = productInfoService.retrieveProductInfo(id);
    }
  }

  private class ProductRatingRunnable implements Runnable{

    private String id;
    private ProductRating productRating;


    public ProductRatingRunnable(String id) {
      this.id = id;
    }

    public ProductRating getProductRating() {
      return productRating;
    }

    @Override
    public void run() {
      productRating = productRatingService.retrieveProductRating(id);
    }
  }





}
