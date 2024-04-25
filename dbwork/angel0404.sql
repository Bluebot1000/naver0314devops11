-- �ڹٿ��� ������ ������ �� ���̺� ����
create sequence seq_test nocache;

create table person (
    punm number(3) constraint pk_num primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

-- 5�� ���� ������ �߰�
insert into person values (seq_test.nextval, '�̻��', 'A', 34, '2010-05-18');
insert into person values (seq_test.nextval, '������', 'O', 38, '2012-02-14');
insert into person values (seq_test.nextval, '������', 'AB', 39, '2015-12-25');
insert into person values (seq_test.nextval, '��ȿ��', 'A', 36, '2019-11-20');
insert into person values (seq_test.nextval, '������', 'O', 44, '2020-04-20');
commit;

select * from person;

select pnum,pname,upper(pblood) pblood,page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;

alter table person rename column punm to pnum;

insert into person values (seq_test.nextval,'������','O','44',null);

select pnum,pname,page||'��' page,upper(pblood)||'��' pblood, to_char(ipsaday, 'yyyy-mm-dd HH:mi') ipsaday from person;

