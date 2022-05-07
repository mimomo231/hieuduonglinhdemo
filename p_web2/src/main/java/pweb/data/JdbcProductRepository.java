package pweb.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pweb.Product;

@Repository
public class JdbcProductRepository implements ProductRepository {
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcProductRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Product> findAll() {
		return jdbc.query("select code, des, type, price from product", this::mapRowToProduct);
	}

	@Override
	public Product findById(String code) {
		return jdbc.queryForObject("select code, des, type, price from product where code=?", this::mapRowToProduct, code);
	}

	private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
		return new Product(rs.getString("code"), rs.getString("des"), rs.getFloat("price"), Product.Type.valueOf(rs.getString("type")));
	}

	@Override
	public Product save(Product product) {
		jdbc.update("insert into product (code, des, type, price) values (?, ?, ?, ?)", 
				product.getCode(), product.getDes(), product.getType().toString(), product.getPrice());
		return product;
	}
}
