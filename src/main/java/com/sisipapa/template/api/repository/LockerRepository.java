package com.sisipapa.template.api.repository;

import com.sisipapa.template.api.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long> {
}
