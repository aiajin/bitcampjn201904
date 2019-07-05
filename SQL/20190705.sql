-- 2019.07.05

-- ��������

-- SCOTT ����� �Ҽӵ�  -> ��������
-- �μ� �̸��� ��� -> ���� ����

select *
from dept
where deptno = (
                select deptno
                from emp
                where ename='SCOTT'
                )
;
select deptno
from emp
where ename='SCOTT'
;

-- ������� ��� �޿����� ���� �޿��� �޴� ����� �̸��� �޿��� ����غ���.

select *
from emp
where sal > (
                select avg(sal)
                from emp
                )
;

select avg(sal)
from emp
;

-- �޿��� 3000 �̻��� ����� �Ҽ� �μ�
-- �ش� �μ��� �ٹ��ϴ� ����� ����Ʈ

select ename
from emp
where deptno in ( -- 20, 10, 20
                    select deptno
                    from emp
                    where sal >= 3000
                )
;

select deptno
from emp
where sal >= 3000
;

select sal
from emp
where deptno=30
;

select ename, sal
from emp
where sal > all(
                select sal
                from emp
                where deptno=30
)
;

select ename, sal
from emp
where sal > any(
                select sal
                from emp
                where deptno=30
)
;

-- �ζ��� �� : from �� �ڿ� ���������� ��ġ
select empno, ename, sal
from (
    select empno, ename, job, hiredate
    from emp
)
;

select empno, ename, job, hiredate
from emp
;


select ename, deptno, (

        select dname
        from dept
        where dept.deptno=emp.deptno

)
from emp
;


---------------------------------------------------------
-- DDL
---------------------------------------------------------

-- CREATE TABLE : ���̺� ���� ( ������ ���� ��Ģ�� ���� )
-- Ŀ�� �̸�, ���� �������� Ÿ��, ���� ������ ������, ��������
-- null ����
-- �ߺ� ����
-- �⺻��
-- üũ
-- �⺻Ű
-- �ܷ�Ű


-- CREATE TABLE : �÷��� ���� ����
create table emp01 (   -- ���̺� �̸��� emp01 �� �����.
    empno number(4), -- �÷��̸��� empno �� ��������� �����. ���� Ÿ��, 4�ڸ�
    ename varchar2(20), -- �÷� �̸��� ename, ��������Ÿ��, 20�ڸ�
    sal number(7,2) -- �÷��̸� sal, ����Ÿ��, 7�ڸ�, 7�ڸ��� �� 2�ڸ��� �Ҽ� ǥ��
    
);

-- CREATE TABLE : ���� ������ �̿��ϴ� ���
create table emp02
AS
select * from emp
;

desc emp02;


create table emp03
as
select empno, ename, job, hiredate from emp
;

desc emp03;


create table emp04
as
select * from emp where deptno=20
;
select * from emp04;

create table emp05
as
select * from emp where 1=2
;
select * from emp05;


-- ���̺��� ������ �����ϴ� ��� : ALTER TABLE
-- �÷��� �߰�, �÷��� ����, �÷��� ����

desc emp01;

-- alter table ���̺��̸� add �÷��̸�
alter table emp01
add (job VARCHAR2(9));

-- alter table ���̺��̸� modify (�÷�����)
alter table emp01 modify (job VARCHAR2(30));

-- alter table ���̺��̸� DROP COLUMN �÷��̸�;
alter table emp01 drop COLUMN job;

select * from emp02;
TRUNCATE table emp02;

rename emp02 to test;
desc emp02;
select * from emp02;
desc test;



-- ���� ���� ����

create table emp06 (
    empno number(4) not null,
    ename varchar2(20),
    sal number(7,2)
)
;
desc emp06;
-- INSERT INTO ���̺� �̸� (�÷�����Ʈ) VALUES (��, ��, ��..)
insert into emp06 (empno, ename) values (null, null);
insert into emp06 (empno, ename) values (2011, null);
select * from emp06;

insert into emp06 (empno, ename) values (2011, 'king');
insert into emp06 (empno, ename) values (2012, 'king');
insert into emp06 (empno, ename, sal) values (2012, 'king', 4000);

drop table emp06;
create table emp06 (
    empno number(4) primary key,
    ename varchar2(20) not null ,
    sal number(7,2) default 1000,
    grade number(1) CHECK ( grade between 1 and 5 ),
    gender char(1) check (gender in ('M', 'W')),
    deptno number(2) REFERENCES dept(deptno)
    --FOREIGN key (deptno) REFERENCES dept(deptno)
)
;
desc emp06;
insert into emp06 values (1000, 'king', null, 5, 'M', 40);
insert into emp06 values (1001, 'king', null, 3, 'M', 30);
select * from emp06;


create table emp07 (
    empno number(4) constraint emp07_empno_nn not null,
    ename varchar2(10) constraint emp07_ename_nn not null,
    job varchar2(9),
    deptno number(2),
    constraint emp07_empno_pk PRIMARY KEY (empno),
    constraint emp07_job_uk UNIQUE (job),
    constraint emp07_deptno_fk FOREIGN KEY (deptno) REFERENCES dept(deptno)
);




-- MEMBERINFO ���̺� ����
-- �븮Ű : idx                       - �⺻Ű
-- ���̵� : 6~12 �ڸ� ���ڿ�            - not null, unique
-- ��й�ȣ : 8~16�ڸ� ���ڿ�            - not null
-- �̸� : 10�ڸ� ���ڿ�                - not null
-- �������(�����̸�) : 30�ڸ� ���ڿ�
-- ���Գ�¥ : ��¥Ÿ��                  - default sysdate

drop table memberinfo;

create table memberinfo (
    idx number(7),
    mId varchar2(12) constraint memberinfo_mId_nn not null,
    mPw varchar2(16) constraint memberinfo_mPw_nn not null,
    mName  varchar2(20) constraint memberinfo_mName_nn not null,
    mPhoto  varchar2(30),
    regDate date default sysdate,
    constraint memberinfo_idx_pk PRIMARY KEY (idx),
    constraint memberinfo_mId_uk UNIQUE (mId)
);



