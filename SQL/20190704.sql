-- 2019.07.04

-- �׷��Լ�

-- SUM(�÷�) : �׷��� ���� ��ȯ

-- ��� ���̺��� ����� �� �޿�(sal)�� ������ ���غ���.
select sum(sal) as "�� �ѱ޿�"
from emp
;

-- 10�� �μ� �Ҽ� �������� �� �޿� �Ѿ��� ���غ���
select sum(sal)
from emp
where deptno=10
;

-- sum �Լ����� null �� ó����� : null ���� �����Ѵ�.
select sum(comm)
from emp
;
select comm from emp;

-- avg(�÷�) : �׷쿡 ���Ե� ������ ��հ��� ��ȯ
select avg(sal) as "��ü����� ��� ���޿�"
from emp
;
-- �׷��Լ��� ����� �������� �ϳ��� �÷�
select trunc(avg(sal)) as "��ü����� ��� ���޿�"
from emp
;
select trunc(avg(sal)) as "��ü����� ��� ���޿�"
from emp
where job='MANAGER'
;

-- avg �Լ��� �÷��� ���� null �϶� �����ϰ� ó��.
select avg(comm)
from emp
;

-- MAX(�ɷ�) : �ִ밪 ��ȯ. MIN(�÷�) : �ּҰ� ��ȯ
select MAX(sal) as "�ִ� �޿�", MIN(sal) as "�ּ� �޿�"
from emp
;

--count(�÷�) : row �� ������ ��ȯ

-- ȸ�翡 �Ҽӵ� ����� ��
select count(*) as "��ü ����� ��"
from emp
;
-- 10�μ��� �Ҽӵ� ���� ��
select count(*)
from emp
where deptno=10
;

-- Ŀ�̼��� �޴� ���� ��
select count(comm)
from emp
;

-- �μ��� ���� ������.
select count(*)
from dept
;

-- ������� �Ҽӵ� �μ��� ��
select deptno
from emp
;
select distinct deptno
from emp
;

SELECT count(distinct deptno)
from emp
;

select job
from emp
;

select *
from emp
order by deptno
;


-- group by �÷��̸� : row�� �׷��� �ؼ� ó��, �����Լ�(sum, avg, count..)
-- �÷��̸� -> �׷����� ����
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
;

-- �μ��� ��� �޿��� 2000 �̻��� �μ��� ���
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having avg(sal) >= 2000
;

-- �μ��� �ִ� �޿� 2900 �̻��� �μ��� ���
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
;


-- ������ ��ǥ�� ��� �غ���.
select job, count(*) as "������ ��", TO_CHAR(sum(sal), '999,999') as "�޿��� ����"
            , round(avg(sal)) as "�޿��� ���", Max(sal), min(sal)
from emp
group by job
;

------------------------------------------------------------




------------------------------------------------------------
-- JOIN : 2�� �̻��� ���̺�  ������ ���δ�. -> ǥ���ϴ� �÷��� �þ��.
------------------------------------------------------------

-- ���̺��� ���δ�. CROSS JOIN 
select *
from emp, dept
where emp.deptno = dept.deptno
;

select *
from emp e, dept d
where e.deptno = d.deptno
;

-- �̸��� 'SCOTT'��  ����� �̸��� �μ��̸��� �������.

select ename, dname, emp.deptno, dept.deptno
from emp, dept
where emp.deptno = dept.deptno and ename='SCOTT'
;

-- �ֹ����̺��� ȸ���� �̸��� �ֹ� ������ ����غ���. ������ ��
-- orders, customer
select o.orderid, c.name
from orders o, customer c
where o.custid = c.custid and c.name='������'
;

-- customer , book, orders
select *
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
;


-- ������ ���� �ֹ��� å�� �̸��� ���.
select b.bookname, b.publisher
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
    and c.name='������'
;




