package Service;

import Bean.Item;

public interface allitemService {
	
	void showallitem();
	boolean additem(Item allItem);
	boolean searchItem(int id);
	boolean deleteitem(int id);
}
