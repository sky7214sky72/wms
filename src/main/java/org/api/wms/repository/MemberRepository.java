package org.api.wms.repository;

import java.util.Optional;
import org.api.wms.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByUsername(String email);
}
