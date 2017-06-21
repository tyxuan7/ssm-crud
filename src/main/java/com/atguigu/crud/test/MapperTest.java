package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.DepartmentExample;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;


/**
 * ����dao��Ĺ���
 *�Ƽ�spring����Ŀ�Ϳ���ʹ��spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 *1.maven����springtestģ��
 *2.@ContextConfigurationָ��spring�����ļ���λ��
 *3.ֱ��@Autowired Ҫʹ�õ��������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * ����DepartmentMapper
	 */
	@Test
	public void testCURD(){
	/*	//1.����SpringIOC����
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�������л�ȡmapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		
		//1.���뼸������
		//departmentMapper.insertSelective(new Department(1, "����"));
		//departmentMapper.insertSelective(new Department(2, "�ⲿ"));
		//ɾ������
		//departmentMapper.deleteByPrimaryKey(1);
		
		//2.����Ա�����ݣ�����Ա������
		employeeMapper.insertSelective(new Employee(null, "halo", "M", "tom@qq.com", 1));
		//3.����������Ա��;������ʹ�ÿ���ִ������������sqlSession
		
		/*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		for(int i =0;i<1000;i++){
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M",	uid + "@qq.com", 1));
		}
		System.out.println("�������");*/
	}
}
