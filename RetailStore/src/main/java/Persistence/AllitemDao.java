package Persistence;

import Bean.Item;

public interface AllitemDao {
void showallitem();
boolean additem(Item item);
boolean searchItem(int id);
void deleteitem();
}
