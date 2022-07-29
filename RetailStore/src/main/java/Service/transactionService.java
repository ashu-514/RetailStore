package Service;

public interface transactionService {
	
	void generatebill(int customer_id);
	void showbill(int customer_id);
	void showalltransactions();
	void addtransaction();
	void deletetransaction();

}
