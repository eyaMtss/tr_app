package com.tunidesign.utilisateurmicroservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tunidesign.utilisateurmicroservice.model.entity.User;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByCompanyId(Long companyId);
	List<User> findByAgencyId(Long companyId);
	List<User> findByInsuranceCompanyId(Long companyId);
	
	List<User> findByRole(Role role);
	
	@Query(value = "SELECT u FROM Users u WHERE u.companyId = :companyId AND u.role = :role", nativeQuery = true)
	List<User> findCompanyEmployeesByRole(@Param("companyId") Long companyId, @Param("role") Role role);
	
	@Query(value = "SELECT u FROM Users u WHERE u.agencyId = :agencyId AND u.role = :role", nativeQuery = true)
	List<User> findAgencyEmployeesByRole(@Param("agencyId") Long agencyId, @Param("role") Role role);
	
	@Query(value = "SELECT u FROM Users u WHERE u.insuranceId = :insuranceId AND u.role = :role", nativeQuery = true)
	List<User> findInsuranceEmployeesByRole(@Param("insuranceId") Long insuranceId, @Param("role") Role role);

	//Authentication
	User findByUsername(String login);
	User findByEmail(String email);
	
	User findByUsernameOrEmail(String login, String email);
}
