package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== Test 1: Department findById ===");
		Department department = departmentDao.findById(5);
		System.out.println(department);
		
		System.out.println("\n=== Test 2: Department findAll ===");
		List<Department>list = departmentDao.findAll();
		
		for (Department x : list) {
			System.out.println(x);
		}
		

		System.out.println("\n=== Test 3: Department Insert ===");
		
		Department newDepartment = new Department(null, "Gastronomy");
		
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New Id: " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: Department Update ===");
		
		department = departmentDao.findById(4);
		department.setName("Frango Inácio");
		departmentDao.update(department);
		System.out.println("Updated completed");
		
		
		System.out.println("\n=== Test 5: Department Delete ===");
		
		System.out.println("Enter id for delete test: ");
		int delId = sc.nextInt();
		
		departmentDao.deleteById(delId);
		System.out.println("Delete Completed");
		
		sc.close();
	}
}
