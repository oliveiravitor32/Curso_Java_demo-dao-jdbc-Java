package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2Department {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("----- TEST 1: department findById -----");
		Department department = departmentDao.findById(4);
		System.out.println(department);
		
		
		System.out.println("\n----- TEST 2: department findAll -----");
		List<Department> departments = departmentDao.findAll();
		for(Department dep: departments) {
			System.out.println(dep);
		}
		
		
		System.out.println("\n----- TEST 3: department insert -----");
		Department newDepartment =  new Department(null, "Machines");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println("\n----- TEST 4: department update -----");
		department = departmentDao.findById(3);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println("Updated department: " + department);
		
		
		System.out.println("\n----- TEST 5: department delete -----");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department deleted!");
		sc.close();
		
	}

}
