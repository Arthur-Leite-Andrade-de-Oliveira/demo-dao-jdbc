package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao  slDao = DaoFactory.createSellerDao();
		
		System.out.println(">>> Test 1: Seller findById <<<");
		Seller sl = slDao.findById(3);
		System.out.println(sl);
		
		System.out.println();
		
		System.out.println(">>> Test 2: Seller findByDepartment <<<");
		Department dp = new Department(2,null);
		List<Seller> slList = slDao.findByDepartment(dp);
		for(Seller obj:slList) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println(">>> Test 3: Seller findAll <<<");
		slList = slDao.findAll();
		for(Seller obj:slList) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println(">>> Test 4: Seller insert <<<");
		Seller newSeller = new Seller(null, "Greg","greg@gmail.com",new Date(), 4000.0,dp);
		slDao.insert(newSeller);
		System.out.println("Inserted! New id = "+newSeller.getId());
		
		System.out.println();
		
		System.out.println(">>> Test 5: Seller update<<<");
		newSeller = slDao.findById(1);
		newSeller.setName("Martha Waine");
		
		slDao.update(newSeller);
		System.out.println("Update completed");
	}

}
