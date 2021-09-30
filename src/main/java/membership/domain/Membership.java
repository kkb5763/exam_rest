package membership.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public final class Membership {

    @Id
    @Column(name="seq")
    private int seq;

    @Column(name = "membershipId")
    private String membershipId; // membershipId
    @Column(name = "membershipName")
    private String membershipName; // membershipName
    @Column(name = "point")
    private int    point; // point

    private String userId;
    private String startDate;

    public Membership(String membershipId, String membershipName, int point, String usreId) {
        this.membershipId = membershipId;
        this.membershipName = membershipName;
        this.point = point;
        this.seq = 1;
        this.userId = usreId;
        this.startDate = java.time.LocalDate.now().toString();
        this.membershipStatus = "Y";
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUsreId(String usreId) {
        this.userId = usreId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public Membership(String membershipId, String membershipName, int point, int seq, String usreId, String startDate, String membershipStatus) {
        this.membershipId = membershipId;
        this.membershipName = membershipName;
        this.point = point;
        this.seq = seq;
        this.userId = usreId;
        this.startDate = java.time.LocalDate.now().toString();
        this.membershipStatus = membershipStatus;
    }

    private String membershipStatus;

    public String getId() {
        return membershipId;
    }
    public String getName() { return membershipName;  }
    public int getPoint() { return point;  }

    public void setId(String id) {
        this.membershipId = id;
    }
    public void setName(String name) {this.membershipName = name;}
    public void setPoint(int point) {this.point = point;}

    public Membership() {
        this.membershipId = "empty";
        this.membershipName = "empty";
        this.point = 0;
    }

    public Membership(String id, String name, int point) {
        System.out.println(id+":"+name+":"+point);
        this.membershipId = id;
        this.membershipName = name;
        this.point = point;
    }
}