package Service;
import Bean.Item;
import Persistence.Allitemdaoimpl;

public class allitemServiceImpl implements allitemService {

	Allitemdaoimpl aa=new Allitemdaoimpl();
	@Override
	public void showallitem() {
		aa.showallitem();
	}

	@Override
	public boolean additem(Item allItem) {
		return aa.additem(allItem);
	}

	@Override
	public boolean searchItem(int id) {
		return aa.searchItem(id);
	}

	@Override
	public boolean deleteitem(int id) {
		return aa.deleteitem(id);
	}

	

}
