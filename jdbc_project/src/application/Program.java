package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("\n=== Test 1: Seller findById ===");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);

		System.out.println("\n=== Test 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== Test 3: Seller findAll ===");
		list = sellerDao.findAll();
		
		for (Seller x : list) {
			System.out.println(x);
		}
		

		System.out.println("\n=== Test 4: Seller Insert ===");
		
		Seller newSeller = new Seller(null, "Relâmpago Maquin","relampago@gmail.com", new Date(), 4000.00, department);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted. New Id: " + newSeller.getId());
		
		System.out.println("\n=== Test 5: Seller Update ===");
		
		seller = sellerDao.findById(4);
		seller.setName("Frango Inácio");
		sellerDao.update(seller);
		System.out.println("Updated completed");
		
		
		System.out.println("\n=== Test 6: Seller Delete ===");
		
		System.out.println("Enter id fo4 delete test: ");
		int delId = sc.nextInt();
		
		sellerDao.deleteById(delId);
		System.out.println("Delete Completed");
		
		sc.close();
	}
}
