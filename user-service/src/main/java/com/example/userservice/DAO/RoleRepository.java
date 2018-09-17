package com.example.userservice.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.models.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@SuppressWarnings("unchecked")
//	public List<Role> findAll(){
//		Session session = this.sessionFactory.getCurrentSession();
//		List<Role> roles = (List<Role>) session.createQuery("from Role").list();
//		return roles;
//	}
//	
//	public String findRoleById(int role_id) {
//		return null;
//	}

}
