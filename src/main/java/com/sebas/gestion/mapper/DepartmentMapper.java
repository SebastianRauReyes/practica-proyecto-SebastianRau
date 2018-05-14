package com.sebas.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sebas.gestion.model.Department;


public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department department = new Department();
		department.setDepartment_id(rs.getInt("department_id"));
		department.setName(rs.getString("name"));
		department.setDescription(rs.getString("description"));
		department.setCity(rs.getString("city"));
		return department;
	}

}
