package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeemapper;
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeemapper.selectByExampleWithDept(null);
	}

	/**
	 * Ա������
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeemapper.insertSelective(employee);
	}
	
}
