--������ ����
--�⺻1���� 1�� �����ϴ� �������� �����ϰ� �⺻��ɾ �ָ��
create SEQUENCE seq1;
--��ü ������ ��ȸ
select * from seq;
--���� �������� �߻� : nextval
select seq1.nextval from dual; --1�� ������ �� �߻�

--10���� 5�� �����ϴ� �������� �����غ���, ĳ���� �⺻ 20�ε� ���ֺ���
create SEQUENCE seq2 start with 10 increment by 5 nocache;

--seq2 ������ �߻�����
select seq2.nextval from dual;

--1���� 3�� ����, ĳ�� 0 �ƽ� 100
create SEQUENCE seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3 �� �߻�
select seq3.nextval from dual;

--������ ����
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;

--���� ���̺��� ����� ������ ����(1���� 1�� ����, cache0)
create SEQUENCE seq_test nocache;

--������ ���̺� ����
create table hello(
    idx number(3) primary key,
    irum varchar2(20),
    age number(3)
);

select * from hello; -- ���̺� ��ȸ

--���̺� ���� �����ϱ� : alter table
--�̸��� ���̸� 20���� 30���� �����غ���
alter table hello modify irum varchar2(30); --������ modify

--addr�̶�� Į�� �߰�(���ڿ� ���� 100)
alter table hello add addr varchar2(100);

--age��� �÷��� �����غ���
alter table hello drop column age;

--�÷��� ����
alter table hello rename COLUMN addr to address;

alter table hello add blood varchar2(3);
alter table hello add age number(3);

--������ �߰�
insert into hello (irum) values ('lee');--�����߻�,idx�� pk�̹Ƿ� �ݵ�� ���� �־�� �Ѵ�
insert into hello (idx,irum) values (seq_test.nextval, 'lee');

insert into hello (idx, blood, address) values (seq_test.nextval,'ab','ȭ�� ����');
--�÷��� �����ص� ����(������� ��� ���� �����)
insert into hello values (seq_test.nextval,'�̹���', '����', 'O', '44');

--�÷��� ���� rename
--�̹����� �������� �ٲ���
update hello set blood='b' where irum='�̹���';

//idx2�� ����� �̸��� age�� ����
update hello set irum='��ȣ��',age='35' where idx='2';

--lee�� �̸��� ��� �� �ֱ�
update hello set address='���� ����',blood='ab',age='29' where irum='lee';

insert into hello values (seq_test.nextval, '�赵��', 'â��', 'o', '27'); 

select irum �̸�, address �ּ�, blood ������ from hello where blood='ab';

--����(idx 1 �����ϱ�, ���� �� �ֱ�)
delete from hello where idx=1;
--age 35�̻� �����ϱ�
delete from hello where age>30;

insert into hello values (seq_test.nextval, '�����', '����', 'b', '24'); 

--���̺� ����
drop table hello;

--------------------�� ���̺� ���� �̹����� ���� ���������� �߰��غ���

create table student (
    num number(3) constraint pk_num primary key,
    name varchar2(20) constraint nn_name not null,
    score number(3) constraint ck_score check(score>=1 and score<=100),
    birth date
    );
    
--�μ�Ʈ�� ������ �߰� ������ �߻����Ѻ���

insert into student (num,name) values (1, '��̸�'); -- ����
insert into student (name,score) values ('�̹���',45); --����(not null ��� �ȵ�)
insert into student (num,name) values (1,'�̹���'); --pk�� ���� �� ��� �ȵ���
insert into student (num,name,score) values (2,'ǳ��',110);--�������� ����

insert into student (num,name,score,birth) values (2,'ǳ��',90,sysdate);
insert into student values (3,'������',80,'1991-04-23');
commit; --�ѹ��� ����� �ȴ�.

insert into student values (4,'��ʶ�',70,'1987-04-23');
insert into student values (5,'�̰���',30,'1998-02-01');
commit;
update student set score='55', birth='1995-04-23' where num=5;

select * from student; --��ȸ

rollback; --������ commit�� ������ DML�۾��� ���� �ѹ�(commit�� �߰��� �������)

--commit�� rollback

update student set name='����' where num=4;

update student set score=85 where to_char(birth,'mm')='04';

delete from student where num=4;

--
--���ʿ��� �������� ����
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--�� �������� �߰�
alter table student add constraint uq_name unique(name);

--���� �̸��� ����Ÿ�� �߰��غ���
insert into student (num,name) values (10, '������'); --�������� ����

----------------------------���� ���� �� �������� ���̺� ����
drop SEQUENCE seq_test;
drop table student;




/*
join�� ������ ���̺� 2�� �����ϱ�

���̺� #1 :
      food - foodnun ����(3)
             foodname ���ڿ�(20)
             foodprice ����(7)
             foodsize ���ڿ�(20)
             
      booking - bnum pk ����(3)
                bname ���ڿ�(20) nn
                bhp ���ڿ�(20) uq
                foodnum ����(3) -fk(food�� foodnum)
                bookingday date
                
      �ܺ�Ű�� ����� ��� booking�� ����Ÿ�� �߰��� ���� �߰��� Ǫ����� ������ �� ����
      (���� ��� �Խ����� ��� ���� ��� �ܺ�Ű�� ����Ǿ� �־�, �̶��� ����� �޸� ��� �ش� ���� ������ �� ���� �Խ��ǵ��� �־�)
      -�׷��� ���� food�� �����͸� �����ϸ� �� �޴��� �߰��� ���� �����͵� �ڵ����� ������Ű���� �� ��� 
      ���� food�� �����͸� �����ϸ� �� �޴��� �߰��� ���� �����͵� �ڵ����� ������ ��� booking �ܺ�Ű�� ������ �� on delete cascade�� �ָ� �ȴ�.
      
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

--�޴�����غ���
insert into food values (100,'¥���',9000,'����');
insert into food values (101,'¥���',11000,'������');
insert into food values (200,'������',15000,'����');
insert into food values (201,'������',20000,'������');
insert into food values (300,'ĥ������',15000,'��');
insert into food values (301,'ĥ������',30000,'��');
insert into food values (400,'�ع�«��',11000,'����');

select * from food;
commit;

create sequence seq_food nocache;

--booking ���̺� ����
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum Foreign key (foodnum) references food(foodnum)
);

--�������̺� ����Ÿ �߰��غ���

insert into booking values(seq_food.nextval,'������','010-3088-5491',101,sysdate);
insert into booking values(seq_food.nextval,'������','010-2288-5411',101,sysdate+7);
insert into booking values(seq_food.nextval,'�赵��','010-3333-2981',300,'24-04-23');
select * from booking;


--join���� �� ���̺��� �����ؼ� ����Ͻÿ�
select bnum, bname, bhp, b.foodnum, foodname, foodprice, foodsize, to_char(bookingday, 'YYYY-mm-dd') bookingday
from food f,booking b
where f.foodnum = b.foodnum;


--�ƹ��� �������� ���� food ������ ������ ������?
select
    bnum, f.foodnum, foodname, foodprice, foodsize
from food f,booking b
where f.foodnum=b.foodnum(+)and bnum is null; --200,300�޴��� �ƹ��� �ֹ�����

--food�� 200�� �޴��� ������ �ɱ��?
delete from food where foodnum=200;
--food�� 100�� �޴��� ������ �ɱ��?
delete from food where foodnum=101;--�ڽ����̺� �ִ� �� ��������

drop table food;--�����߻�, �ڽ����̺� �����ϰ� �θ����̺� ������ �� ����

drop table booking;
drop table food;
drop sequence seq_food;
--------------------------------------------------------------------------------

--on delete cascade ����
--�̹����� �θ����̺��� ������ ������ �������̺��� �����͵� �ڵ����� �����ǵ���

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

--��ǰ�������
insert into shop values (seq_shop.nextval, '��1', 10000);
insert into shop values (seq_shop.nextval, '��2', 11000);
insert into shop values (seq_shop.nextval, '��3', 12000);
insert into shop values (seq_shop.nextval, '��4', 13000);
insert into shop values (seq_shop.nextval, '��5', 14000);

select * from shop;
commit;

--cart�� ���ϴ� ��ǰ�� ��ƺ���
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 1, 1, sysdate);
insert into cart values (seq_shop.nextval, 3, 5, sysdate);
insert into cart values (seq_shop.nextval, 5, 3, sysdate);

select * from cart;

--join���� ��ȸ�ϱ�
select cart_no, s.sang_no, sang_name, sang_price, to_char(cartday, 'YYYY-mm-dd') ������
from cart c, shop s
where c.sang_no=s.sang_no;

--�ƹ��� ���� ���� ���� ����
select cart_no, s.sang_no, sang_name, sang_price
from cart c, shop s
where c.sang_no(+)=s.sang_no and cart_no is null;

--on delete cascade�� �� ��� cart�� �߰��� ��ǰ�� ������ �����ϴ�
--2������ ��������
delete from shop where sang_no=2;
--cart������ �����, �θ� �ڽĵ� ���� �������.

drop table cart;
drop table shop;
drop sequence seq_shop;