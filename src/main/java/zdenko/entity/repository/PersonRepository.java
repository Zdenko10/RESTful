package zdenko.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zdenko.constant.RoleType;
import zdenko.entity.PersonEntity;
import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    List<PersonEntity> getAllByRole(RoleType roleType);
    @Query(value = "SELECT * FROM person WHERE role=:#{#role.name()} LIMIT :limit", nativeQuery = true)
    List<PersonEntity> getAllByRole(@Param("role") RoleType role, @Param("limit") int limit);

}
