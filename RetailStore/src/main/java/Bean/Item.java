package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
	int itemID;
	String itemName;
	String itemcategory;
	int itemQuantity;
	double itemPrice;	

}
