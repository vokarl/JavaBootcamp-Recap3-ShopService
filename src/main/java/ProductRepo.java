import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("1", "Apfel"));
        products.add(new Product("1", "Apfel"));
        products.add(new Product("1", "Apfel"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product addProduct(Product newProduct) {
        products.add(newProduct);
        return newProduct;
    }

    public void removeProduct(String id) {
        for (Product product : products) {
           if (product.id().equals(id)) {
               products.remove(product);
               return;
           }
        }
    }
}
