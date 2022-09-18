package com.scart.productservice;

import com.scart.productservice.model.Product;
import com.scart.productservice.repository.ProductRepository;
import com.scart.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpInputMessage;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@Test
	public Product addProducts(){
		Product product= new Product(4,"vishnu","mysel","electronic",null, null,null ,8000,"nice", null);
		productService.addProducts(product);
		verify(productRepository,times(1)).save(product);

	}


}
