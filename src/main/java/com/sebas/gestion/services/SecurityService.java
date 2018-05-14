package com.sebas.gestion.services;

import com.sebas.gestion.exception.DAOException;
import com.sebas.gestion.exception.LoginException;
import com.sebas.gestion.model.Employee;

public interface SecurityService {

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
