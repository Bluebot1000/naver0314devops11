-- 자바연동 연습용 시퀀스 및 테이블 생성
create sequence seq_test nocache;

create table person (
    punm number(3) constraint pk_num primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

-- 5개 정도 데이터 추가
insert into person values (seq_test.nextval, '이상순', 'A', 34, '2010-05-18');
insert into person values (seq_test.nextval, '정재형', 'O', 38, '2012-02-14');
insert into person values (seq_test.nextval, '정재일', 'AB', 39, '2015-12-25');
insert into person values (seq_test.nextval, '박효신', 'A', 36, '2019-11-20');
insert into person values (seq_test.nextval, '박정현', 'O', 44, '2020-04-20');
commit;

select * from person;

select pnum,pname,upper(pblood) pblood,page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;

alter table person rename column punm to pnum;

insert into person values (seq_test.nextval,'아이유','O','44',null);

select pnum,pname,page||'세' page,upper(pblood)||'형' pblood, to_char(ipsaday, 'yyyy-mm-dd HH:mi') ipsaday from person;

