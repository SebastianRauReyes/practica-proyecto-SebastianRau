package com.sebas.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.gestion.dao.EmployeeDAO;
import com.sebas.gestion.exception.DAOException;
import com.sebas.gestion.exception.LoginException;
import com.sebas.gestion.model.Employee;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee validate(String login, String password) throws LoginException, DAOException {

		Employee emp = employeeDAO.validate(login, password);

		return emp;
	}

}
