package com.gslab.akshay.dao;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gslab.akshay.pojo.Employee;

@Repository
public class EmployeeDao {

	private DirContext context;

	public void createConnection() throws NamingException {
		Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.PROVIDER_URL, "ldap://localhost:389");
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		ldapEnv.put(Context.SECURITY_CREDENTIALS, "secret");
		context = new InitialDirContext(ldapEnv);
	}

	public String registerEmployee(Employee emp) throws NamingException {
		createConnection();
		Attributes att = new BasicAttributes();
		Attribute att2 = new BasicAttribute("objectClass");
		att2.add("inetOrgPerson");
		att.put(att2);
		Attribute sn = new BasicAttribute("sn");
		sn.add(emp.getSname());
		Attribute cn = new BasicAttribute("cn");
		cn.add(emp.getFname());
		att.put(cn);
		att.put(sn);
		att.put("telephoneNumber", "1234567890");
		att.put("employeeNumber", emp.getEmpNo());
		System.out.println("adding the employee");
		context.createSubcontext("employeeNumber=" + emp.getEmpNo() + ",ou=engineer,ou=People,dc=maxcrc,dc=com", att);

		return "employee added with emp Id" + emp.getEmpNo();
	}

	public Employee getEmployee(String fName) throws NamingException {
		createConnection();
		Employee e= new Employee();
		Attributes att=context.getAttributes("cn="+fName+",ou=engineer,ou=People,dc=maxcrc,dc=com");
		Attribute firstName= att.get("cn");
		e.setFname((String) firstName.get());
		Attribute lastName= att.get("sn");
		e.setSname((String) lastName.get());
		Attribute empNo= att.get("employeeNumber");
		e.setEmpNo((String)empNo.get());
		System.out.println("name:"+e.getFname()+"lastName:"+e.getSname()+"emp:"+e.getEmpNo());
		return e;
	}

	public String deleteEmployee(String fname) throws NamingException {
		createConnection();
		context.destroySubcontext("cn="+fname+",ou=engineer,ou=People,dc=maxcrc,dc=com");
		return "deleted Successfully";
	}

	public String updateEmployee(Employee emp) throws NamingException {
		createConnection();
		Attributes att = new BasicAttributes();
		Attribute att2 = new BasicAttribute("objectClass");
		att2.add("inetOrgPerson");
		att.put(att2);
		Attribute sn = new BasicAttribute("sn");
		sn.add(emp.getSname());
		Attribute cn = new BasicAttribute("cn");
		cn.add(emp.getFname());
		att.put(cn);
		att.put(sn);
		att.put("telephoneNumber", "1234567890");
		att.put("employeeNumber", emp.getEmpNo());
		context.modifyAttributes("employeeNumber="+emp.getEmpNo()+",ou=engineer,ou=People,dc=maxcrc,dc=com",context.REPLACE_ATTRIBUTE,att );
		return "emp modified successfully";
	}

}
