package membership.service;

import membership.domain.Membership;
import membership.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService{

    private MembershipRepository membershipRepository;

    @Autowired
    public MembershipServiceImpl(final MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public String regsistMembership(Membership regMembership)  throws Exception{
        try {
            //seq 값 채번
            int seqVal = 0;
            seqVal = membershipRepository.findByuserSeqSQL(regMembership.getUserId());

            if(seqVal < 1){
                regMembership.setSeq(1);
            }else{
                regMembership.setSeq(seqVal);
            }
            System.out.println("insert Data : seq ="+seqVal);
            if(checkMembershipId(regMembership.getId()).equals("ok")){
                membershipRepository.save(regMembership);
                System.out.println("insert Data Success="+checkMembershipId(regMembership.getId()));
            }else{
                System.out.println("insert Data Fail="+checkMembershipId(regMembership.getId()));
            }

        }catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return "insert";
    }

    @Override
    public List<Membership> searchMembership(String userid)  throws Exception {
        return (List<Membership>) membershipRepository.findByuserAllSQL(userid);
    }

    @Override
    public List<Membership> searchMembershipOne(String membershipid, String userid)  throws Exception{
        return (List<Membership>) membershipRepository.findByuserIdSQL(membershipid, userid);
    }

    @Override
    public void addMembershipPoint(int amount, String membershipid, String userid) throws Exception{
        try {
            //seq 값 채번
            int seqVal = 0;
            seqVal = membershipRepository.findByuserSeqSQL(userid);
            Membership ms = new Membership(
                    membershipid, "purchase_reward", amount/100, seqVal, userid,"","");

//            public Membership(String membershipId, String membershipName, int point, int seq, String usreId, String startDate, String membershipStatus) {
            membershipRepository.save(ms);
        }catch(Exception e){
            e.printStackTrace();
        }

        //포인트 가감 가능 기능 -> 요구사항 확인 결과, 포인트 사용 개념은 미구현
        //membershipRepository.addMembershipPoint(point,membershipid,userid);
    }

    @Override
    public void deleteMembership(String membershipid, String userid) throws Exception {
        membershipRepository.deleteMembership(membershipid, userid);
    }


    @Override
    public String checkMembershipId(String membershipid){
        String msg = "ok";
        if(membershipid != null
                && ("cj".equals(membershipid)
                ||  "shinsegae".equals(membershipid)
                ||  "spc".equals(membershipid))
        ){
            msg = "ok";
        }else{
            msg = "적립불가 포인트";
        }
        return msg;
    }
}
