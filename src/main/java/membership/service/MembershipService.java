package membership.service;

import membership.domain.Membership;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembershipService {

    //membership 등록
    String regsistMembership(Membership regMembership) throws Exception;

    //membership 전체 조회
    List<Membership> searchMembership(String userid) throws Exception;

    //membership 전체 조회
    List<Membership> searchMembershipOne(String membershipid, String userid) throws Exception;

    void addMembershipPoint( int point, String membershipid, String userid) throws Exception;

    void deleteMembership(String membershipid, String userid) throws Exception;

    String checkMembershipId(String membershipid);


}
