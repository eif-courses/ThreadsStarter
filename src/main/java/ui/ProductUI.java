package ui;

import domain.Product;
import domain.ProductOption;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductUI extends JFrame {

  private final Map<String, ImageIcon> imageIconMap = new HashMap<>();

  public ProductUI(Product product) throws MalformedURLException {
    List<ProductOption> productOptionList = product.getInfo().getList();
    for (ProductOption productOption : productOptionList) {
      imageIconMap.put(productOption.getTitle(), new ImageIcon(new URL(productOption.getImageURL())));
    }
    JList<Object> jList = new JList<>(imageIconMap.keySet().toArray());
    jList.setCellRenderer(new ProductListCellRenderer());
    JScrollPane scrollPane = new JScrollPane(jList);
    scrollPane.setPreferredSize(new Dimension(800,600));
    add(scrollPane);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

  }
  private class ProductListCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

      Font font = new Font("helvetica", Font.BOLD, 24);

      JLabel jLabel = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

      Image scaleImage = imageIconMap.get(value).getImage().getScaledInstance(64,64, Image.SCALE_FAST);
      ImageIcon imageIcon = new ImageIcon(scaleImage);
      jLabel.setIcon(imageIcon);


      jLabel.setHorizontalTextPosition(JLabel.RIGHT);
      jLabel.setFont(font);

      return jLabel;
    }
  }

}
