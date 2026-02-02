package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao  dpDao = DaoFactory.createDepartmentDao();
		
		System.out.println(">>> Test 1: Department findById <<<");
		Department dp = dpDao.findById(3);
		System.out.println(dp);
		
		System.out.println();
		
		System.out.println(">>> Test 2: Department findAll <<<");
		List<Department> dpList = dpDao.findAll();
		for(Department obj:dpList) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println(">>> Test 3: Department insert <<<");
		Department newDepartment = new Department(null, "Toys");
		dpDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+newDepartment.getId());
		
		System.out.println();
		
		System.out.println(">>> Test 4: Department update<<<");
		newDepartment = dpDao.findById(4);
		newDepartment.setName("Magazines");
		
		dpDao.update(newDepartment);
		System.out.println("Update completed");
		
		System.out.println();
		
		System.out.println(">>> Test 5: Department delete<<<");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		dpDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();

	}

}
