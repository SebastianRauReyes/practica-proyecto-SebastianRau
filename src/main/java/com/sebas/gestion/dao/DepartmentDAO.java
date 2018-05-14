package com.sebas.gestion.dao;

import java.util.List;

import com.sebas.gestion.exception.DAOException;
import com.sebas.gestion.exception.EmptyResultException;
import com.sebas.gestion.model.Department;

public interface DepartmentDAO {
	
	Department findDepartment(int id) throws DAOException, EmptyResultException;

	void create(String name, String description, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String description, String city) throws DAOException;

	List<Department> findAllDepartments() throws DAOException, EmptyResultException;
	
	Department findDepartmentByName(String name) throws DAOException, EmptyResultException;

	
}
