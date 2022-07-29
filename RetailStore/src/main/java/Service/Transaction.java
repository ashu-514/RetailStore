package Service;

public interface Transaction {
   double generateBill(int transactionID, String customerName, int noofBooks, int noofCd, int noofCosmetics);
   double showBill(int transactionID);
   void fun();
}
