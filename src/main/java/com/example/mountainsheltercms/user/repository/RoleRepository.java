package com.example.mountainsheltercms.user.repository;


import com.example.mountainsheltercms.user.role.ERole;
import com.example.mountainsheltercms.user.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
