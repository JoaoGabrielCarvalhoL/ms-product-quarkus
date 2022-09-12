package br.com.carv.service;

import br.com.carv.dto.ProductDTO;
import br.com.carv.entity.ProductEntity;
import br.com.carv.exception.ProductNotFoundException;
import br.com.carv.repository.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    private ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProducts() {

        PanacheQuery<ProductEntity> query = productRepository.findAll();
        List<ProductDTO> result = query.stream().map(entity -> new ProductDTO(entity)).collect(Collectors.toList());
        return result;
    }

    public void saveProduct(ProductDTO productDTO) {
        productRepository.persist(new ProductEntity(productDTO));
    }

    public void updateProduct(Long id, ProductDTO dto) {
        ProductEntity product = productRepository.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product Not Found! Id: " + id);
        }

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setModel(dto.getModel());
        product.setPrice(dto.getPrice());
        productRepository.persist(product);
    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product Not Found! Id: " + id);
        }

        productRepository.delete(product);
    }

    public ProductDTO findById(Long id) {
        ProductEntity product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product Not Found! Id: " + id);
        }
        return new ProductDTO(product);
    }
}
