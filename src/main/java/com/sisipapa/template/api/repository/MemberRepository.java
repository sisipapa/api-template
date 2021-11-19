package com.sisipapa.template.api.repository;

import com.sisipapa.template.api.entity.MemberL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberL, Long> {
}
