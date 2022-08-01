package Persistence;

import Bean.Item;

public interface AllitemDao {
void showallitem();

boolean additem(Item allItem);
//void deleteitem();
boolean searchItem(int id);
boolean deleteitem(int id);
}