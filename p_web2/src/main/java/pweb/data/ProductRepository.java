package pweb.data;

import pweb.Product;

public interface ProductRepository {
	Iterable<Product> findAll();

	Product findById(String code);

	Product save(Product products);
}