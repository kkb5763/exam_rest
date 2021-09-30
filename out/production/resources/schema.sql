drop table if exists membership;

create table membership (seq integer not null, membership_id varchar(255), membership_name varchar(255), membership_status varchar(255), point integer, start_date varchar(255), user_id varchar(255), primary key (seq));


--#insert into MEMBERSHIP(SEQ ,MEMBERSHIP_ID ,MEMBERSHIP_NAME ,MEMBERSHIP_STATUS ,POINT ,START_DATE ,USER_ID )
--values ((select nvl(max(SEQ)) ,0)+1 from membership) ,"cj" ,"init" ,"Y" ,10000 ,''202105 ,"test1")
insert into MEMBERSHIP(SEQ ,MEMBERSHIP_ID ,MEMBERSHIP_NAME ,MEMBERSHIP_STATUS ,POINT ,START_DATE ,USER_ID )
values (1 ,'cj' ,'init' ,'Y' ,10000 ,sysdate,'test1') ;
insert into MEMBERSHIP(SEQ ,MEMBERSHIP_ID ,MEMBERSHIP_NAME ,MEMBERSHIP_STATUS ,POINT ,START_DATE ,USER_ID )
values (2 ,'shinsegae' ,'init' ,'Y' ,10000 ,sysdate,'test1') ;
insert into MEMBERSHIP(SEQ ,MEMBERSHIP_ID ,MEMBERSHIP_NAME ,MEMBERSHIP_STATUS ,POINT ,START_DATE ,USER_ID )
values (3 ,'scp' ,'init' ,'Y' ,10000 ,sysdate,'test1') ;