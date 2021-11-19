package com.sisipapa.template.api.repository;

import com.sisipapa.template.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
