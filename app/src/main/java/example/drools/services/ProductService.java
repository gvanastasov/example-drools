package example.drools.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.drools.models.Product;

@Service
public class ProductService {

    private static List<Product> Products = new ArrayList<>();

    static {
        Products.add(new Product("Product B", false));
        Products.add(new Product("Product C", false));
    }

    private final KieSession kieSession;

    @Autowired
    public ProductService(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public void addProduct(Product product) {
        kieSession.insert(product);
        kieSession.fireAllRules();

        Products.add(product);
    }

    public List<Product> getAll() {
        return Products;
    }
}
