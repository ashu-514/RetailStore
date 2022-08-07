package Service;

import Bean.Item;

public interface allitemService {
	
	void showallitem();
	boolean additem(Item allItem);
	Item searchItem(int id);
	boolean deleteitem(int id);
}
