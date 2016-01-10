package com.esadvisory.ws.dao;

import java.util.List;

import javax.naming.Name;
import javax.naming.ldap.LdapName;
import javax.resource.spi.AuthenticationMechanism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;

import com.esadvisory.ws.domain.User;

public class UserDaoImpl implements UserDao {
	
	
	private LdapTemplate ldapTemplate;

	@Override
	public void create(User user) {

		Name dn = buildDn(user);
		DirContextAdapter context = new DirContextAdapter(dn);
		mapToContext(user, context);
		ldapTemplate.bind(dn, context, null);

	}

	private void mapToContext(User user, DirContextAdapter context) {
		// TODO Auto-generated method stub
		
	}

	private Name buildDn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAllUserNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public User findByPrimaryKey(String employeeID) {
		LdapName dn = buildDn(employeeID);
	//	System.out.println("Here is the dn : "+ dn.toString());
		return ldapTemplate.lookup(dn, USER_CONTEXT_MAPPER ) ; 
	}
	
	
	
	
	private LdapName buildDn(String employeeID) {
	
		return LdapNameBuilder.newInstance()
				.add("cn", "Users")
				.add("ou","Employees")
				.add("ou", "CORPT")
				.add("ou", "Active Users")
                .add("cn", employeeID).build() ;
	
	}




	private final static ContextMapper<User> USER_CONTEXT_MAPPER = new AbstractContextMapper<User>() {
		
		
		@Override
		public User doMapFromContext(DirContextOperations context) {
			User user = new User();

            LdapName dn = LdapUtils.newLdapName(context.getDn());
			//user.setCountry(LdapUtils.getStringValue(dn, 0));
			user.setCompany(LdapUtils.getStringValue(dn, 1));
			user.setEmployeeID(context.getStringAttribute("cn")) ;
			user.setLastName(context.getStringAttribute("sn"));
			//user.setDescription(context.getStringAttribute("description"));
			user.setPhone(context.getStringAttribute("telephoneNumber"));

			return user;
		}
	};

	
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

}
