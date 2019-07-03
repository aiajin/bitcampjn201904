-- 2019.07.03

-- LIKE : ���� ���ϰ˻� ������ Ű���� 
-- �÷��� LIKE ����
-- ���� : % _

-- % ������ �̿�
-- ������̺��� 'S' �� �����ϴ� ����� �̸��� �˻�����
select ename
from emp
where ename LIKE 'S%'
;
-- 'S' �� ������ �̸��� ���� ��� �˻�
SELECT ename
from emp
where ename like '%S'
;
-- ����� �̸��� 'S' �� �����ϴ� �̸��� ���� ��� �˻�
select * 
from emp
where ename like '%S%'
;

-- _ �����ڴ� ������ �ڸ�(��ġ) ������ �ǹ�  : �ش� �ڸ����� ��� ���� �͵� �������.
-- _A    ���ڸ� ���ڴ� ��� ���ڿ��� ����, �ι�° ���ڴ� �ݵ�� A�� ����
-- _A_
-- ����� �̸��߿� �ι�° ���ڿ� 'A'��  �����ϴ� �̸��� ���
select *
from emp
where ename like '__A%'
;

-- ����� �̸��� 'A' �� �������� �ʴ� ������� �˻�
select *
from emp
where ename not like '%A%'
;

-- �÷��� ������ ���� null �� ���θ� Ȯ��
-- is null -> ���� null �϶� true
-- is not null -> ���� null�� �ƴҶ� true

-- Ŀ�̼��� ���� �ʴ� ���
select *
from emp
where comm is null or comm = 0
;

-- Ŀ�̼��� �޴� ���
select *
from emp
where not ( comm is null or comm = 0 )
;
select *
from emp
where comm is not null and comm > 0
;

-- ��� ���̺��� �ο�(��) ����
-- order by �÷��� [asc]/desc, Ŀ���� [asc]/desc

-- �޿��� ���� ������� �޿��� ���� ��� ������ ����
select * 
from emp
order by sal --asc
;

-- �޿��� ���� ������� �޿��� ���� ��� ������ ����
select *
from emp
order by sal desc
;
-- �ֱ� �Ի��� ��� ������ ����� ����Ʈ ���
select *
from emp
order by hiredate desc
;

-- ����� �޿��������� �޿��� ���� ��� ������ ����, �޿��� ���� ����� ��� �̸� ������ ����
select ename, sal, hiredate
from emp
order by sal desc, hiredate asc
;


select  count(DISTINCT deptno)
from emp
;

----------------------------------------------------
-- �Լ�
----------------------------------------------------

-- TO_CHAR
-- DATE -> STR
select sysdate as ��¥, TO_CHAR(sysdate, 'YYYY.MM.DD. HH24:MI:SS') as ��ȯ��¥
from dual
;

select hiredate, TO_CHAR(hiredate,'YYYY.MM.DD') as "date"
from emp
;

-- NUMBER -> STR : TO_CHAR(����Ÿ��, '����')
select TO_CHAR(10000,'L999,999')
from dual
;
select sal, TO_CHAR(sal, 'L999,999') as "�� �޿�", 

    TO_CHAR(sal*12+nvl(comm,0),'L999,999') as "����"

from emp
;

-- TO_DATE(����, 'YYYYMMDD') -> DATE
select ename, hiredate, TO_DATE('19810220', 'YYYYMMDD')
from emp
where hiredate = TO_DATE('1981-02-20', 'YYYY-MM-DD')
;

select sysdate, TO_DATE('2012/05/17', 'YYYY/MM/DD'), 

    trunc(sysdate-TO_DATE('2012/05/17', 'YYYY/MM/DD'))
    
from dual
;


-- DECODE �Լ� : switch case ���� �� ����
select ename, deptno, 
        DECODE(deptno,
                    10, 'ACCOUNTING',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATION'
                    ) AS DNAME
from emp
;

select ename, job, sal,
        DECODE(job,
                'ANALYST', sal*1.05,
                'SALESMAN', sal*1.1,
                'MANAGER', sal*1.15,
                'CLERK', sal*1.2
        ) as upSal
from emp
;

select DISTINCT job from emp;


select ename, deptno,

        case 
            when deptno=10 then 'ACCOUNTING'
            when deptno=20 then 'RESEARCH'
            when deptno=30 then 'SALSE'
            when deptno=40 then 'OPERATIOINS'
            else 'no Name'
        end as DNAME


from emp
;















