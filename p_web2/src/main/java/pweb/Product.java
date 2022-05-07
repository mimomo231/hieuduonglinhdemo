package pweb;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Product {
	private final String code;
	private final String des;
	private final float price;
	private final Type type;
	
	public static enum Type {
		MUSIC
	}
}