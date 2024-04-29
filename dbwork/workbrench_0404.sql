-- 2024-04-04 mysql 공부
-- 현재 날짜를 구하는 함수들
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜함수들
select year(now()) 연도 from dual;
select month(now()) 월 from dual;
select monthname(now()) 월 from dual;
select dayname(now()) 요일 from dual;
select dayofmonth(now()) from dual;
select date_format(now(),'%Y-%m-%d') from dual;

-- test 01 테이블 만들기
create table test01 (num tinyint auto_increment primary key,
      name varchar(20), age smallint,
     height decimal(5,1), birthday datetime, ipsaday date);
     
-- insert : 일부만 추가할 경우 컬럼명 기재, 전체 다 줄 경우 컬럼명 생략
insert into test01 (name,age,height) values ('lee',23,178.9);
insert into test01 (name,birthday,ipsaday) values ('seoj','2011-04-22 10:00','2018-01-01');
insert into test01 values (null,'kim',29,191.9,now(),now()); -- 컬럼생략시 다 넣어줘야함, autonum은 null을 준다
insert into test01 values (null,'son',31,178.989,now(),now());
insert into test01 values (null,'park',43,165,now(),now());

select * from test01; -- 조회하기
select * from test01 where name='son';
select * from test01 where name like 'S%';
select * from test01 where name like '_a%';
select upper(name)이름,height 키 from test01; -- ucase로 써도됨
select lcase(name)이름 from test01;

-- 오라클의 mvl이 mysql에서는 ifnull:null 일때 대체값 지정

select name,ifnull(age, 10)나이,ifnull(height,150)키 from test01;

-- 테이블 구조 수정
-- 컬럼 추가
alter table test01 add hp varchar(20);

-- 컬럼 추가하는데 기본값 지정
alter table test01 add blood varchar(4) default 'b';

desc test01; -- 구조 확인

-- name의 길이를 20에서 30으로 변경
alter table test01 modify name varchar(30);
-- age컬럼을 제거
alter table test01 drop column age;
-- 컬럼명 변경(mysql 5에서는 change, 이제 rename)

alter table test01 rename column hp to phone;

-- 삭제
delete from test01 where num=5;

-- 수정
update test01 set birthday='1990-01-01' where num=1;

-- 부분조회
select * from test01 limit 1,3; -- 첫데이터가 0번부터 3개 조회
select * from test01 limit 3,2; -- 첫데이터가 0번:3번부터2개 조회

create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자')));
        
-- 제약조건 확인
select * from information_schema.table_constraints where table_name='sawon';
-- 구조 확인
desc sawon;

select * from sawon; -- 전체 데이터 조회

-- check에 안맞는 값을 insert할 경우 오류메시지 확인
-- 그룹 바이 연습해야 하니까 데이터 10개 추가
insert into sawon values (null, '김상욱',100,'남자','연구개발부');
insert into sawon values (null, '나영석',70,'남자','기획부');
insert into sawon values (null, '유현준',90,'남자','연구개발부');
insert into sawon values (null, '정재승',85,'남자','연구개발부');
insert into sawon values (null, '김순덕',50,'여자','홍보부');
insert into sawon values (null, '유시민',90,'남자','보건복지부');
insert into sawon values (null, '황정아',70,'여자','연구개발부');
insert into sawon values (null, '최재천',30,'남자','비서실');
insert into sawon values (null, '주우재',90,'남자','인사부');
insert into sawon values (null, '김영하',78,'남자','사보제작부');

-- group함수
select count(*) from sawon; -- 총인원수alter
select sum(score),round(avg(score),1) from sawon; -- 총점, 평균

-- 성별: 인원수 최고점수 최저점수 평균점수를 구해보자
select gender 성별,count(*) 인원,max(score) 최고점,min(score) 최저점,round(avg(score),1) 평균점수
from sawon
group by gender;

-- 부서별 인원수, 최고점수
select buseo 부서, count(*) 인원, max(score) 최고점수
from sawon
group by buseo;

-- 오라클의 decode와 비슷한 if문
select name,score,if(score>=90,'통과','재시험') 평가
from sawon;

-- sawon 테이블 제거
drop table sawon;

-- 함수들
select concat('happy',' day') from dual; /*문자열더함*/
select concat('apple','kiwi','mango') from dual;
select replace('have a nice day','a','*') from dual;
select instr('happy','p') from dual;
select instr('happy','x') from dual;
select left('have a nice day',4) from dual;
select right('have a nice day',5) from dual;
select mid('have a nice day',8,4) from dual;
select substring('have a nice day',8,4) from dual;
select left('가나다라마바사',3) from dual; /*한글도3글자 나옴*/
select substring('가나다라마바사',4,2) from dual;
select concat(ltrim('   abc    '),'*') from dual;
select concat(rtrim('   abc    '),'*') from dual;
select concat(trim('   abc    '),'*') from dual;
select lcase('Happy'),lower('Happy') from dual;
select ucase('Happy'),upper('Happy') from dual;
select reverse('Happy') from dual;
select abs(-10) from dual;/*무조건 양수값 반환*/
select ceiling(2.1) from dual; /*무조건올림  3 */
select floor(2.9) from dual; /*무조건내림  2 */
select truncate(2.345,2) from dual; /*소숫점2자리까지 출력되고 3자리에서 내림*/
select mod(5,3) from dual;/*5를 3으로 나눈나머지=2*/
select greatest(12,23,34,11,4) from dual;/*가장 큰숫자*/
select least(12,23,34,11,4) from dual;/*가장 작은숫자*/
-- max(12,34,54,13) from dual; -- 오류남, max함수의 변수는 배열만 가능함


create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

select * from bitclass;
select * from stu;

insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

select * from bitclass bc,stu where bc.idx=stu.idx; -- 조인1
select name,class,price,gigan,sugangday,bc.idx from bitclass bc,stu
  where bc.idx=stu.idx; -- 조인2
select name,class,price,gigan,sugangday from bitclass bc 
	inner join stu on bc.idx=stu.idx; -- 조인3 / 아예 다르게 inner join on을 썼다
    
-- 연습용 테이블 삭제
drop table stu;
drop table bitclass;
drop table test01;

-- join 연습용 테이블 2개 생성 : on delete cacade
create table shop(
	shopnum smallint auto_increment primary key,
    sangpum varchar(30),
    price int,
    color varchar(20) default 'black'
);

create table cart(
	cartnum smallint auto_increment primary key,
    username varchar(20),
    shopnum smallint,
    guipday datetime,
    constraint fk_shopnum foreign key(shopnum) references shop(shopnum) on delete cascade
);

-- shop에 5개 상품을 등록해보자
insert into shop (sangpum,price) values ('블라우스', 12000);
insert into shop values (null,'면바지', 22000, 'beige');
insert into shop values (null,'청바지', 42000, 'blue');
insert into shop values (null,'티셔츠', 12000, 'white');
insert into shop values (null,'모자', 26000, 'black');
select * from shop;

insert into cart values (null,'최현욱', null, now());
insert into cart values (null,'송혜교', null, now());
insert into cart values (null,'정진욱', null, now());
insert into cart values (null,'전종서', null, now());
insert into cart values (null,'이효리', null, now());
select * from cart;

-- join 1
select * from shop,cart where shop.shopnum=cart.shopnum;

-- join 2
select cartnum, username, c.shopnum, price, color
from shop s, cart c where s.shopnum=c.shopnum;

-- join 3sawon
select cartnum, username, price, color
from shop
inner join cart
on shop.shopnum=cart.shopnum;

-- shop에서 블라우스 1번 제거해보자
delete from shop where shopnum=1;

-- 문제　：　아래의　결과를　자바　파일로　실행해서　출력되도록　하세요
select buseo, count(*) inwon,max(score) maxscore, ceiling(avg(score)) avgscore
from sawon
group by buseo;