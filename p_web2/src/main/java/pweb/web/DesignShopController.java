package pweb.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import pweb.Shop;
import pweb.data.ProductRepository;
import pweb.Product.Type;
import pweb.Product;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignShopController {
	private final ProductRepository productRepo;

	@Autowired
	public DesignShopController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	@ModelAttribute
	public void addProductsToModel(Model model) {
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
		
		Type[] types = Product.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(products, type));
		}
	}

	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("shop", new Shop());
		return "design";
	}

	private List<Product> filterByType(List<Product> products, Type type) {
		List<Product> prodList = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getType().equals(type))
				prodList.add(product);
		}
		return prodList;
	}

	@PostMapping
	public String processDesign(Shop shop) {
		// Save the taco design...
		// We'll do this later
		log.info("Processing design: " + shop);
		return "redirect:/orders/current";
	}
}