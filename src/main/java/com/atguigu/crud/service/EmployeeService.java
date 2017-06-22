package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.EmployeeExample.Criteria;
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

	/**
	 * Ա�������ֶ�У��
	 * �����û����Ƿ����
	 * @return 0 true:����ǰ�������� false:��������
	 */
	
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		 long count = employeemapper.countByExample(example);
		return count == 0;
	}
	
	/**
	 * ����Ա��Id��ѯԱ��
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeemapper.selectByPrimaryKey(id);
		return employee;
	}
	
	/**
	 * Ա������
	 * @param employee
	 */

	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeemapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * Ա������ɾ��
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeemapper.deleteByPrimaryKey(id);
	}

	/**
	 * Ա������ɾ��
	 * @param ids
	 */
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		employeemapper.deleteByExample(example);
	}
	
}
