-- 2019.07.08

-- �μ����� 2

-- ���� �̸��� ���� �ѱݾ��� ���
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

-- �� ������ ��� �ֹ��ݾ׺��� ū �ݾ��� �ֹ� ������ ���ؼ� 
-- �ֹ���ȣ, ������ȣ, �ݾ��� ���

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

-- ���ѹα��� �����ϴ� �������� 
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

-- 3�� ������ �ֹ��� ������ �ְ� �ݾ׺��� �� ��� ������ ������ �ֹ��� 
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


-- EXISTS �����ڷ� ���ѹα��� �����ϴ� �������� �Ǹ��� ������ �� �Ǹž��� ���Ͻÿ�.

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





