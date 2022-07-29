package Persistence;

import Service.allitemServiceImpl;

public class main {
		public static void main(String args[])
		{
			TransactionDetailsDaoImpl t=new TransactionDetailsDaoImpl();
			t.showalltransactionDetails();
			CustomerDaoImp c=new CustomerDaoImp();
			c.showCustomer();
			transactionDaoImpl t1=new transactionDaoImpl();
			t1.showalltransactions();
			Allitemdaoimpl it = new Allitemdaoimpl();
			it.showallitem();
		}

	}



