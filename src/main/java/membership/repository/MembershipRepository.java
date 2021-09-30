package membership.repository;

import membership.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository  extends JpaRepository<Membership, Integer> {

    @Query("select t from Membership t where user_id=:user_id")
    List<Membership> findByuserAllSQL( @Param("user_id") String user_id);

    @Query("select t from Membership t where membershipId = :membershipId and user_id=:user_id")
    List<Membership> findByuserIdSQL(@Param("membershipId") String membershipId, @Param("user_id") String user_id);

    @Transactional
    @Modifying
    @Query("UPDATE Membership t set t.point = t.point + :point where membershipId = :membershipId and user_id=:user_id")
    void addMembershipPoint(@Param("point") int point, @Param("membershipId") String membershipId, @Param("user_id") String user_id);

    @Transactional
    @Modifying
    @Query("UPDATE Membership t set t.membershipStatus = 'N' where membershipId = :membershipId and user_id=:user_id")
    void deleteMembership(@Param("membershipId") String membershipId, @Param("user_id") String user_id);

    //seq값 채번
    @Query("select nvl(max(seq),0)+1 from Membership t")
    int findByuserSeqSQL( @Param("user_id") String user_id);
}
