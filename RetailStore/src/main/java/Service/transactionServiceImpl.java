package Service;

import java.util.List;

import Bean.Transaction_Details;
import Persistence.TransactionDetailsDaoImpl;

public class transactionServiceImpl implements transactionService {
	TransactionDetailsDaoImpl td=new TransactionDetailsDaoImpl();
	@Override
	public void generatebill(int customer_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showbill(int customer_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showalltransactionDetails() {
		td.showalltransactionDetails();
	}

	@Override
	public boolean addtransactionDetail(Transaction_Details trans_details) {
		return td.addtransactionDetail(trans_details);
	}

	@Override
	public boolean deletetransactionDetail(int id) {
		return td.deletetransactionDetail(id);
	}

	@Override
	public List<Transaction_Details> searchTransactionDetails(int transid) {
		return td.searchTransactionDetails(transid);
	}

	

}
