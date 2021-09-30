package membership.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import membership.domain.Membership;
import membership.service.MembershipService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class MembershipController {
    private final MembershipService membershipService;

    @Autowired
    public MembershipController(final MembershipService multiplicationService) {
        this.membershipService = multiplicationService;
    }

    //멤버쉽 조회 restapi http://localhost:8080/api/v1/memberShip
    @GetMapping("/membership")
    HashMap<String,Object> getMemberShipAll( @RequestHeader(value="X-USER-ID") String userId) throws Exception{

        HashMap<String, Object> map = new HashMap<>();
        String errorMsg = "200";
        try {
            if(userId != null && !"".equals(userId)) {
                map.put("success", userId + "true");
                map.put("response", membershipService.searchMembership(userId));

            }else{
                map.put("success", "false");
                map.put("response", " ");
                errorMsg = "X-USER-ID 정보 누락";
            }
        }catch(Exception e){
            map.put("error","예외발생"+e.toString());
            return map;
        }finally {
            map.put("error",errorMsg);
            return map;
        }
    }

    //membership 등록, 이력 정보 겸해서 지속적으로 쌓도록
    @PostMapping(value = "/membership")
    HashMap<String,Object> regMembership(@RequestBody Map<String,String> member,
                                         @RequestHeader(value="X-USER-ID") String userId
    )  throws Exception{
        String errorMsg = "200";
        System.out.println("#######regMembership########");

        HashMap<String, Object> map = new HashMap<>();
        try {
            if(member.get("membershipId") != null){
                errorMsg = membershipService.checkMembershipId(member.get("membershipId"));
            }

            Membership membership = new Membership(member.get("membershipId"),
                    member.get("membershipName"), Integer.parseInt(member.get("point")),
                    userId
            );
            membershipService.regsistMembership(membership);
            map.put("success", "success");
            map.put("responce", member); // 해당 건 조회로 변경
        }catch(Exception e){
            map.put("success", "fail");
            map.put("error",e.toString());
            return map;
        }finally {
            map.put("error",errorMsg);
            return map;
        }
    }

    @DeleteMapping("/membership/{membershipId}")
    HashMap<String,Object> deleteMemberShip(@RequestHeader(value="X-USER-ID") String userId,
                                            @PathVariable(value = "membershipId")       String       membershipId

    )  throws Exception{
        System.out.println("GetMapping"+membershipId);
        HashMap<String, Object> map = new HashMap<>();

        try {
            membershipService.deleteMembership(membershipId, userId);
            map.put("success", userId + "true");
            map.put("responce", membershipService.searchMembershipOne(membershipId, userId));
        }catch(Exception e){
            map.put("error","오류");
            return map;
        }finally {
            map.put("error","200");
            return map;
        }
    }


    @GetMapping("/membership/{membershipId}")
    HashMap<String,Object> getMemberShipOne(@RequestHeader(value="X-USER-ID") String userId,
                                            @PathVariable(value = "membershipId")       String       membershipId

    )  throws Exception{
        System.out.println("GetMapping"+membershipId);
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("success", userId + "true");
            map.put("responce", membershipService.searchMembershipOne(membershipId, userId));
        }catch(Exception e){
            map.put("error","오류");
            return map;
        }finally {
            map.put("error","200");
            return map;
        }
    }


    //amount /100 에 해당하는 금액 추가 적립 (0.1원 대상 포인트금액 절사)
    @PutMapping("/membership/point")
    HashMap<String,Object> addMemberShipPoint(@RequestHeader(value="X-USER-ID") String userId,
                                              @RequestBody Map<String,String> point

    )  throws Exception{
        System.out.println("PutMapping"+point);
        HashMap<String, Object> map = new HashMap<>();
        try{
            membershipService.addMembershipPoint(Integer.parseInt(point.get("amount")), point.get("membershipId"), userId);
            map.put("success", userId + "true");
            map.put("responce", membershipService.searchMembershipOne(point.get("membershipId"), userId));
        }catch(Exception e){
            map.put("error","오류");
            e.printStackTrace();
            return map;
        }finally {
            map.put("error","200(성공)");
            return map;
        }
    }


}
