package membership.service;

import membership.domain.Membership;
import membership.repository.MembershipRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class MembershipServiceImplTest {
    @Mock
    private MembershipRepository membershipRepository;
    private MembershipServiceImpl membershipServiceImpl;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        membershipServiceImpl = new MembershipServiceImpl(membershipRepository);
    }

    @Test
    public void create신규포인트등록테스트() throws Exception {
        //HashMap<String,Object> map = new HashMap<>();
        //public Membership(String membershipId, String membershipName, int point, int seq,
        // String usreId, String startDate, String membershipStatus) {
        Membership ms = new Membership("cj", "amount_reward10", 10000, 1,
        "test99", java.time.LocalDate.now().toString(), "Y");
        String Result = membershipServiceImpl.regsistMembership(ms);

        ms = new Membership("shinsegae", "amount_reward10", 10000, 1,
                "test99", java.time.LocalDate.now().toString(), "Y");
        Result = membershipServiceImpl.regsistMembership(ms);


        ms = new Membership("scp", "amount_reward10", 10000, 1,
                "test99", java.time.LocalDate.now().toString(), "Y");
        Result = membershipServiceImpl.regsistMembership(ms);


        ms = new Membership("cj222", "amount_reward10", 10000, 1,
                "test99", java.time.LocalDate.now().toString(), "Y");
        Result = membershipServiceImpl.regsistMembership(ms);


    }

}
