package com.sebas.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.sebas.gestion.exception.DAOException;
import com.sebas.gestion.exception.EmptyResultException;
import com.sebas.gestion.model.Department;
import com.sebas.gestion.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DepartmentDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOTest.class);

	@Autowired
	private DepartmentDAO departmentDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void testFindDepartmentbyId() {

		try {
			//
			Department department = departmentDAO.findDepartment(47);

			Assert.assertNotNull(department);

			Assert.assertEquals("gomez", department.getName());
			Assert.assertEquals("profesor", department.getDescription());
			Assert.assertEquals("santa anita", department.getCity());
			
			logger.info(department.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void testFindAllEmployees() {

		try {
			//
			List<Department> departments = departmentDAO.findAllDepartments();

			logger.info(departments.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
		
	}
	//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void testCreateEmployee() {

		logger.info("--");
		
		String name = "Sebas" + (int) (Math.random() * 100);;
		String description = "Alumno";
		String city = "Ciudad de Lima";


		try {
			//
			departmentDAO.create(name, description, city);

			//
			Department department = departmentDAO.findDepartmentByName(name);
	
			Assert.assertEquals(name, department.getName());
			Assert.assertEquals(description, department.getDescription());
			Assert.assertEquals(city, department.getCity());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void testUpdateEmployee() {

		String name = "Sebas" + (int) (Math.random() * 100);;
		String description = "Alumno";
		String city = "Ciudad de Lima";
		
		
		String UP_description = "Egresado";
		String UP_city = "Ciudad de Ica";
		

		
		try {
			//
			departmentDAO.create(name, description, city);
					
			departmentDAO.update(name, UP_description, UP_city);
			
			Department department= departmentDAO.findDepartmentByName(name);
					
			Assert.assertEquals(UP_description, department.getDescription());
			Assert.assertEquals(UP_city, department.getCity());
	
			
		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void testDeleteEmployee() {

		String name = "Sebas" + (int) (Math.random() * 100);;
		String description = "Alumno";
		String city = "Ciudad de Lima";

		try {
			//
			departmentDAO.create(name, description, city);
	

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {
			
			departmentDAO.delete(name);
			
			departmentDAO.findDepartmentByName(name);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}
	//--------------------------------------------------------------------------------------------------------------------
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
	
	

}
