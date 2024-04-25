--시퀀스 생성
--기본1부터 1씩 증가하는 시퀀스는 생략하고 기본명령어만 주면됨
create SEQUENCE seq1;
--전체 시퀀스 조회
select * from seq;
--다음 시퀀스값 발생 : nextval
select seq1.nextval from dual; --1씩 증가된 값 발생

--10부터 5씩 증가하는 시퀀스를 생성해보자, 캐쉬가 기본 20인데 없애보자
create SEQUENCE seq2 start with 10 increment by 5 nocache;

--seq2 값으로 발생시켭
select seq2.nextval from dual;

--1부터 3씩 증가, 캐쉬 0 맥스 100
create SEQUENCE seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3 값 발생
select seq3.nextval from dual;

--시퀀스 제거
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;

--최종 테이블에서 사용할 시퀀스 생성(1부터 1씩 증가, cache0)
create SEQUENCE seq_test nocache;

--연습용 테이블 생성
create table hello(
    idx number(3) primary key,
    irum varchar2(20),
    age number(3)
);

select * from hello; -- 테이블 조회

--테이블 구조 수정하기 : alter table
--이름의 길이를 20에서 30으로 수정해보자
alter table hello modify irum varchar2(30); --수정은 modify

--addr이라는 칼럼 추가(문자열 길이 100)
alter table hello add addr varchar2(100);

--age라는 컬럼을 제거해보자
alter table hello drop column age;

--컬럼명 변경
alter table hello rename COLUMN addr to address;

alter table hello add blood varchar2(3);
alter table hello add age number(3);

--데이터 추가
insert into hello (irum) values ('lee');--에러발생,idx는 pk이므로 반드시 값을 넣어야 한다
insert into hello (idx,irum) values (seq_test.nextval, 'lee');

insert into hello (idx, blood, address) values (seq_test.nextval,'ab','화성 봉담');
--컬럼명 생략해도 가능(순서대로 모든 값을 줘야함)
insert into hello values (seq_test.nextval,'이무생', '제주', 'O', '44');

--컬럼명 수정 rename
--이무생의 혈액형을 바꿔줘
update hello set blood='b' where irum='이무생';

//idx2인 사람의 이름과 age를 수정
update hello set irum='강호동',age='35' where idx='2';

--lee가 이름인 사람 값 넣기
update hello set address='서울 강동',blood='ab',age='29' where irum='lee';

insert into hello values (seq_test.nextval, '김도완', '창릉', 'o', '27'); 

select irum 이름, address 주소, blood 혈액형 from hello where blood='ab';

--삭제(idx 1 삭제하기, 조건 꼭 넣기)
delete from hello where idx=1;
--age 35이상 삭제하기
delete from hello where age>30;

insert into hello values (seq_test.nextval, '문상민', '정릉', 'b', '24'); 

--테이블 삭제
drop table hello;

--------------------새 테이블 생성 이번에는 각종 제약조건을 추가해보자

create table student (
    num number(3) constraint pk_num primary key,
    name varchar2(20) constraint nn_name not null,
    score number(3) constraint ck_score check(score>=1 and score<=100),
    birth date
    );
    
--인서트로 데이터 추가 에러를 발생시켜보자

insert into student (num,name) values (1, '김미리'); -- 성공
insert into student (name,score) values ('이미자',45); --오류(not null 허용 안됨)
insert into student (num,name) values (1,'이미자'); --pk는 같은 값 허용 안되죵
insert into student (num,name,score) values (2,'풍자',110);--제약조건 오류

insert into student (num,name,score,birth) values (2,'풍자',90,sysdate);
insert into student values (3,'최현욱',80,'1991-04-23');
commit; --롤백이 여기로 된다.

insert into student values (4,'김똘똘',70,'1987-04-23');
insert into student values (5,'이강인',30,'1998-02-01');
commit;
update student set score='55', birth='1995-04-23' where num=5;

select * from student; --조회

rollback; --마지막 commit한 이후의 DML작업에 대한 롤백(commit을 중간에 해줘야해)

--commit과 rollback

update student set name='김우빈' where num=4;

update student set score=85 where to_char(birth,'mm')='04';

delete from student where num=4;

--
--불필요한 제약조건 제거
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--새 제약조건 추가
alter table student add constraint uq_name unique(name);

--같은 이름의 데이타를 추가해보자
insert into student (num,name) values (10, '최현욱'); --제약조건 위반

----------------------------연습 끝난 후 시퀀스랑 테이블 삭제
drop SEQUENCE seq_test;
drop table student;




/*
join용 연습용 테이블 2개 생성하기

테이블 #1 :
      food - foodnun 숫자(3)
             foodname 문자열(20)
             foodprice 숫자(7)
             foodsize 문자열(20)
             
      booking - bnum pk 숫자(3)
                bname 문자열(20) nn
                bhp 문자열(20) uq
                foodnum 숫자(3) -fk(food의 foodnum)
                bookingday date
                
      외부키로 연결된 경우 booking에 데이타가 추가된 이후 추가된 푸드넘은 삭제할 수 없다
      (예를 들어 게시판의 댓글 같은 경우 외부키로 연결되어 있어, 이때도 댓글이 달린 경우 해당 글을 삭제할 수 없는 게시판들이 있어)
      -그런데 만약 food의 데이터를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제시키고자 할 경우 
      만약 food의 데이터를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제할 경우 booking 외부키를 설정할 때 on delete cascade를 주면 된다.
      
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

--메뉴등록해보자
insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱빼기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱빼기');
insert into food values (300,'칠리새우',15000,'소');
insert into food values (301,'칠리새우',30000,'대');
insert into food values (400,'해물짬뽕',11000,'보통');

select * from food;
commit;

create sequence seq_food nocache;

--booking 테이블 생성
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum Foreign key (foodnum) references food(foodnum)
);

--예약테이블에 데이타 추가해보자

insert into booking values(seq_food.nextval,'최현욱','010-3088-5491',101,sysdate);
insert into booking values(seq_food.nextval,'이학주','010-2288-5411',101,sysdate+7);
insert into booking values(seq_food.nextval,'김도완','010-3333-2981',300,'24-04-23');
select * from booking;


--join으로 두 테이블을 조인해서 출력하시오
select bnum, bname, bhp, b.foodnum, foodname, foodprice, foodsize, to_char(bookingday, 'YYYY-mm-dd') bookingday
from food f,booking b
where f.foodnum = b.foodnum;


--아무도 예약하지 않은 food 음식은 무엇이 있을까?
select
    bnum, f.foodnum, foodname, foodprice, foodsize
from food f,booking b
where f.foodnum=b.foodnum(+)and bnum is null; --200,300메뉴는 아무도 주문안함

--food의 200번 메뉴는 삭제가 될까요?
delete from food where foodnum=200;
--food의 100번 메뉴는 삭제가 될까요?
delete from food where foodnum=101;--자식테이블에 있는 걸 지워야함

drop table food;--오류발생, 자식테이블 삭제하고 부모테이블 삭제할 수 있음

drop table booking;
drop table food;
drop sequence seq_food;
--------------------------------------------------------------------------------

--on delete cascade 예제
--이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록

create sequence seq_shop;
--shop,cart

create table shop (
    sang_no number(3) constraint shoe_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);

create table cart (
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--상품등록하자
insert into shop values (seq_shop.nextval, '옷1', 10000);
insert into shop values (seq_shop.nextval, '옷2', 11000);
insert into shop values (seq_shop.nextval, '옷3', 12000);
insert into shop values (seq_shop.nextval, '옷4', 13000);
insert into shop values (seq_shop.nextval, '옷5', 14000);

select * from shop;
commit;

--cart에 원하는 상품을 담아보자
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 1, 1, sysdate);
insert into cart values (seq_shop.nextval, 3, 5, sysdate);
insert into cart values (seq_shop.nextval, 5, 3, sysdate);

select * from cart;

--join으로 조회하기
select cart_no, s.sang_no, sang_name, sang_price, to_char(cartday, 'YYYY-mm-dd') 구매일
from cart c, shop s
where c.sang_no=s.sang_no;

--아무도 사지 않은 옷은 뭐지
select cart_no, s.sang_no, sang_name, sang_price
from cart c, shop s
where c.sang_no(+)=s.sang_no and cart_no is null;

--on delete cascade를 한 경우 cart에 추가된 상품도 삭제가 가능하다
--2번조끼 삭제하자
delete from shop where sang_no=2;
--cart에서도 사라져, 부모도 자식도 같이 사라진다.

drop table cart;
drop table shop;
drop sequence seq_shop;