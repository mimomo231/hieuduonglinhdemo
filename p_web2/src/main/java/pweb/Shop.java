package pweb;

import java.util.List;
import lombok.Data;

@Data
public class Shop {
	private String name;
	private List<String> products;
}