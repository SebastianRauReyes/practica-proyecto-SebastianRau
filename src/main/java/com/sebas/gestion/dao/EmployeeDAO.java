package com.sebas.gestion.dao;

import java.util.List;

import com.sebas.gestion.exception.DAOException;
import com.sebas.gestion.exception.EmptyResultException;
import com.sebas.gestion.exception.LoginException;
import com.sebas.gestion.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	void delete(String login) throws DAOException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;

	List<Employee> findAllEmployees() throws DAOException, EmptyResultException;

	List<Employee> findEmployeesByName(String name) throws DAOException, EmptyResultException;

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
