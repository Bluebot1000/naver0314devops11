--�����Լ�, �����Լ� ����
select abs(-5),abs(5) from dual; --abs : ���밪
select ceil(3.0), ceil(3.1), ceil(3.9) from dual; --ceil : �����ǿø�
select floor(3.9) from dual; --floor : ������ ����
select substr('ALLEN',1,3) from dual; -- ���� ����
select mod(7,3) from dual; -- ������
select power(2,3) from dual; --������
select round(23.456,2) from dual; -- �ݿø�

--�����Լ�
select concat('happy','day') from dual; --
select 'happy'||'day' from dual; --���� ����
select INITCAP('HAppy') from dual; -- ù���� �빮�ڷ�
select lower('HAppy') from dual;-- �� �ҹ��ڷ�
select upper('HAppy') from dual;-- �� �빮�ڷ�
select lpad(sal,10,'*') from emp; -- �������� *ä���
select Rpad(sal,10,'*') from emp; -- ���������� *ä���

select substr('happy day',-5,3) from dual;--�ڿ��� �ټ���°���� 3��°���� ���
select ename, length(ename) ���ڼ� from emp; --���ڼ�
select replace('good day','o','*') from dual;
select instr('happy', 'x') from dual; --0�� ������ ���� ��
select trim('   dual   ') from dual;--�յڰ��������� ���

--��Ÿ�Լ�
--nvl ���ϰ�� ��ü������ ���
select ename, nvl(comm,1000) from emp;

--decode �� ���� ���� �ٸ� ���� ����Ҷ�
select ename �����, deptno �μ��ڵ�,
 decode(deptno,10,'�λ��',20,'������',30,'��ȹ��') �μ��� from emp;
 
--join�� ���ؼ�
--inner join ���� ���� equi ����
select
emp.ename, emp.sal, dept.dname
from emp,dept
where emp.deptno=dept.deptno;

--�Ǵٸ����, �����̺� ���������� �ִ� �÷��� ��쿡�� �տ� ���̺���� ���̰� �������� ��������
--���̺���� �ʹ� ���� ��Ī�� ����Ҽ� �ִ�
select
 e.empno,ename,job,dname,loc
 from emp e, dept d
 where e.deptno=d.deptno;