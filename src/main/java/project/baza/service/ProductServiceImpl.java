package project.baza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.baza.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
