-- 2019.07.08

-- �μ����� 2

-- �� �̸��� ���� �ѱݾ��� ���
select custid, (
        select name from customer c 
        where o.custid = c.custid        
        ), sum(saleprice) as �����Ѿ�
from orders o
group by custid
;

-- JOIN ó��
select o.custid, c.name, sum(o.saleprice) as �����ѱݾ�
from orders o join customer c 
on o.custid=c.custid
group by o.custid, c.name
order by o.custid
;

-- �ζ��κ�
select * from customer where custid <=2;

select * 
from (select * from customer where custid <= 2) c, orders o
where c.custid=o.custid
;

-- row num

select rownum,empno, ename
from emp
order by ename
;
select rownum, empno, ename
from (select * from emp order by ename)
;

-- ��� �ֹ��ݾ� ������ �ֹ��� ���ؼ� 
-- �ֹ���ȣȭ �ݾ��� ���

select avg(saleprice)
from orders;

-- 11800
select orderid, saleprice 
from orders
where saleprice <= (
    select avg(saleprice)
    from orders
    )
;

-- �� ���� ��� �ֹ��ݾ׺��� ū �ݾ��� �ֹ� ������ ���ؼ� 
-- �ֹ���ȣ, ����ȣ, �ݾ��� ���

select orderid, custid, saleprice
from orders od
where saleprice > (
                    select avg(saleprice)
                    from orders so
                    where  od.custid=so.custid
)
;

select avg(saleprice)
from orders so
where  so.custid=2
;

-- ���ѹα��� �����ϴ� ������ 
-- �Ǹ��� ������ ���Ǹž��� ���Ͻÿ�.
select sum(saleprice) as ���Ǹűݾ�
from orders
where custid IN (
                    select custid
                    from customer
                    where address like '%���ѹα�%'
)
;
-- JOIN
select sum(saleprice) as ���Ǹž�
from orders o join customer c
on o.custid = c.custid
where address like '%���ѹα�%'
;

-- 3�� ���� �ֹ��� ������ �ְ� �ݾ׺��� �� ��� ������ ������ �ֹ��� 
--     �ֹ���ȣ�� �ݾ��� ���̽ÿ�.
-- �ִ� ������ ū �� ã��

select  orderid, saleprice
from orders
where saleprice > all (
                        select saleprice 
                        from orders
                        where custid=3
)
;

select  orderid, saleprice
from orders
where saleprice > (
                        select max(saleprice)
                        from orders
                        where custid=3
)
;


-- EXISTS �����ڷ� ���ѹα��� �����ϴ� ������ �Ǹ��� ������ �� �Ǹž��� ���Ͻÿ�.

select sum(Saleprice) as "�� �Ǹž�"
from orders o
where exists (
                select *
                from customer c
                where o.custid=c.custid and c.address like '%���ѹα�%'
)
;

-------------------------------------------------------------
-- DML
-------------------------------------------------------------

-- ������ �Է�
-- : INSERT INTO ���̺� �� (�÷� ����Ʈ.. )  VALUES ( �Է� ������ ����Ʈ.. )

-- ���̺� ����
drop table dept01;

-- ���̺� ����
create table dept01
as
select * from dept where 1=0
;

desc dept01;

-- ������ �Է�
insert into dept01 
(deptno, dname, loc) 
values 
(10, 'accounting', 'newyork');

select * from dept01;

desc dept01;
insert into dept01
values (20, 'research', 'dallas')
;

-- null ���� �Է�
-- �Ϲ���/�Ͻ��� ���
-- �÷��� ���� �Է�
insert into dept01
(deptno, dname)
values (30, 'sales')
;

insert into dept01
values (40, 'operations', null)
;

insert into dept01
values (50, '', null);

select * from dept01;

insert into dept01
select * from dept
;

--  �������� ���� 
-- : UPDATE ���̺� �̸� SET �÷��̸�=���浥���� , �÷��̸�=���浥����, ...
-- : WHERE �����ϰ����ϴ� ���� ã������ ����

update emp01
set deptno=30
;
update emp01
set sal = sal * 1.1
;

update emp01
set hiredate=sysdate
;
select * from emp01;
desc emp01;

drop table emp01;
create table emp01
as
select * from emp
;

-- where ���� �̿��� Ư������ ������ ����
-- �μ���ȣ�� 10���� ����� �μ���ȣ�� 30������ ����
update emp01
set deptno=30
where deptno=10
;

-- �޿��� 3000�̻��� ����� �޿��� 10% �λ�
update emp01
set sal = sal*1.1
where sal >= 3000
;


-- 1987�⿡ �Ի��� ����� �Ի����� ���÷� �����սô�. 
-- ����� �Ի����� ���÷� ������ �Ŀ� ���̺� ������ ���캾�ô�.

update emp01
set hiredate = sysdate
where substr(hiredate, 1,2)='87'
;

-- SCOTT ����� 
-- �μ���ȣ�� 20������, ������ MANAGER�� �Ѳ����� �����ϵ��� �սô�.

update emp01
set deptno=10, job='MANAGER'
where ename='SCOTT'
;

select * from emp01;

-- SCOTT ����� 
-- �Ի����ڴ� ���÷�, �޿��� 50 ���� Ŀ�̼��� 4000 ���� �����սô�.

update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;

select * from dept01;

drop table dept01;
create table dept01
as
select * from dept01
;

-- 20�� �μ��� 
-- �������� 40�� �μ��� ���������� �����ϱ� ���ؼ� ���� �������� ����� ���ô�.

update dept01
set loc=(
            select loc
            from dept01
            where deptno=40
)
where deptno=20
;

update dept01
set (dname, loc) = (
                        select dname, loc from dept where deptno=40
)
where deptno=10
;

-- ������ ���� : DELETE FROM ���̺� �̸� WHERE ����
-- ���ǿ� �ش��ϴ� ���� ����

SELECT * FROM DEPT01;
-- ��ü ���� ����
DELETE FROM DEPT01;

DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT
;

-- Ư������ ���� �Ѵ�. WHERE ������ Ư������ ã�� ������ ���
DELETE FROM DEPT01
WHERE DEPTNO=30
;



-------------------------------------------------------
-------------------------------------------------------
DESC MEMBERINFO;
-- IDX     NOT NULL NUMBER(7)    
-- MID     NOT NULL VARCHAR2(12) 
-- MPW     NOT NULL VARCHAR2(16) 
-- MNAME   NOT NULL VARCHAR2(20) 
-- MPHOTO           VARCHAR2(30) 
-- REGDATE          DATE

SELECT * FROM MEMBERINFO;

-- ȸ�� ���Խ� �����ϴ� IDX ���� ���� SEQUENCE ����
CREATE SEQUENCE MEMBERINFO_IDX_SEQ ;

-- ȸ������ INSERT
-- 1. 
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME, MPHOTO)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'COOL', '1111', 'COOLname', 'COOLPHOTO.JPG');
-- 2.
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME, MPHOTO)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'HOT', '3333', 'HOTname', NULL);
-- 3.
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'COOLINHOT123', '3333', 'CinHname');

COMMIT;
ROLLBACK;

-- ȸ�� ������ ���� : PK�� �������θ� �����Ѵ�.
-- ȸ�� �̸��� ����
UPDATE MEMBERINFO
SET mname='��'
WHERE IDX=1;
-- ��й�ȣ�� ����
UPDATE MEMBERINFO
SET mpw='9999'
WHERE IDX=2;
-- �̸��� ��й�ȣ �ѹ��� ���� 
UPDATE MEMBERINFO
SET mname='��', mpw='0000'
WHERE IDX=4
;

-- ������ ���� : PK �������� ����
DELETE FROM MEMBERINFO WHERE IDX=4;

DELETE FROM MEMBERINFO;


CREATE TABLE DEPT11
AS
SELECT * FROM DEPT
;
DROP TABLE DEPT11;


COMMIT;


------------------------------------------------------------
-- VIEW : ����ڿ��� �����ִ� ���� ���̺�
--        Ư�� �÷��� �����ϰų� ������ sql ���� ����ȭ ��Ų��.
------------------------------------------------------------


-- VIEW ���� : CREATE VIEW �� �̸� AS ��������
CREATE VIEW EMP_view30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO=30
;

SELECT EMPNO, ENAME, DEPTNO FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP_VIEW30;


-- �ζ��κ�
-- ��� �߿��� 
-- �Ի����� ���� ��� 5��(TOP-5)���� ��� ���� ���ǹ��� �ۼ��� ���ô�.

SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate;

SELECT ROWNUM, EMPNO, ENAME, HIREDATE
FROM (
        SELECT  EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate
)
WHERE ROWNUM <=5 
ORDER BY HIREDATE
;

CREATE OR REPLACE VIEW  EMP_VIEW_HD
AS
SELECT  EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate
;

SELECT ROWNUM, EMPNO, ENAME, HIREDATE
FROM EMP_VIEW_HD
WHERE ROWNUM <=5 
ORDER BY HIREDATE
;


-----------------------------------------------------------------------
-- SEQUENCE : �ڵ� ���� ����ó�����ִ� ��ü
-----------------------------------------------------------------------

CREATE SEQUENCE TEST_SEQ
START WITH 10
INCREMENT BY 10
;
DROP SEQUENCE TEST_SEQ;

SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;

DESC DEPT01;
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (TEST_SEQ.NEXTVAL, 'DESIGN', 'SEOUL');
DELETE FROM DEPT01;
