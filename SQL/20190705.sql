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












