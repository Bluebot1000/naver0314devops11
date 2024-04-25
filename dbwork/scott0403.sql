--숫자함수, 문자함수 연습
select abs(-5),abs(5) from dual; --abs : 절대값
select ceil(3.0), ceil(3.1), ceil(3.9) from dual; --ceil : 무조건올림
select floor(3.9) from dual; --floor : 무조건 내림
select substr('ALLEN',1,3) from dual; -- 문자 추출
select mod(7,3) from dual; -- 나머지
select power(2,3) from dual; --지수승
select round(23.456,2) from dual; -- 반올림

--문자함수
select concat('happy','day') from dual; --
select 'happy'||'day' from dual; --위와 같다
select INITCAP('HAppy') from dual; -- 첫글자 대문자로
select lower('HAppy') from dual;-- 다 소문자로
select upper('HAppy') from dual;-- 다 대문자로
select lpad(sal,10,'*') from emp; -- 왼쪽으로 *채우기
select Rpad(sal,10,'*') from emp; -- 오른쪽으로 *채우기

select substr('happy day',-5,3) from dual;--뒤에서 다섯번째에서 3번째까지 출력
select ename, length(ename) 글자수 from emp; --글자수
select replace('good day','o','*') from dual;
select instr('happy', 'x') from dual; --0이 나오면 없는 것
select trim('   dual   ') from dual;--앞뒤공백제거후 출력

--기타함수
--nvl 널일경우 대체값으로 출력
select ename, nvl(comm,1000) from emp;

--decode ㅣ 값에 따라 다른 값을 출력할때
select ename 사원명, deptno 부서코드,
 decode(deptno,10,'인사부',20,'교육부',30,'기획부') 부서명 from emp;
 
--join에 대해서
--inner join 내부 조인 equi 조인
select
emp.ename, emp.sal, dept.dname
from emp,dept
where emp.deptno=dept.deptno;

--또다른방법, 두테이블에 공통적으로 있는 컬럼일 경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
--테이블명이 너무 길경우 별칭을 사용할수 있다
select
 e.empno,ename,job,dname,loc
 from emp e, dept d
 where e.deptno=d.deptno;