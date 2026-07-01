package org.northernarc.ecommerce.service;

import org.northernarc.ecommerce.DTO.ProductRequestDTO;
import org.northernarc.ecommerce.DTO.ProductResponseDTO;
import org.northernarc.ecommerce.DTO.ProductUpdateDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO saveProduct(ProductRequestDTO productDTO);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Integer id);

    ProductResponseDTO updateProduct(Integer id,
                                     ProductUpdateDTO productDTO);

    void deleteProduct(Integer id);

    List<ProductResponseDTO> getProductsByCategory(String category);

    List<ProductResponseDTO> getProductsByBrand(String brand);

    List<ProductResponseDTO> getProductsByName(String name);
}