package Service;

import Bean.Transaction;
import Bean.Transaction_Details;
import Persistence.transactionDaoImpl;

public class transactionDetailsServiceImpl implements transactionDetailsService {

	transactionDaoImpl td=new transactionDaoImpl();
	@Override
	public void showalltransactions() {
		td.showalltransactions();
		
	}

	@Override
	public boolean addtransaction(Transaction transaction) {
		return td.addtransaction(transaction);
	}

	@Override
	public boolean deletetransaction(int id) {
		return td.deletetransaction(id);
	}

	@Override
	public Transaction_Details searchTransaction(int transid) {
		return td.searchTransaction(transid);
	}

	
}
