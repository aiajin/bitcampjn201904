-- [����] ������ �Լ�, �����Լ� ���� ( ���� �߰� )

-- 16. SUBSTR �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ����Ͻÿ�.
-- substr(���ڿ�, �ڸ���ġ, �����ǰ���)
select substr(hiredate, 1,5) as "�Ի�����"
from emp
;



-- 17. SUBSTR �Լ��� ����Ͽ� 4���� �Ի��� ����� ����Ͻÿ�.
-- �Ի��� ���� ���� = '04' --> 80/04/01
select *
from emp
where substr(hiredate, 4, 2) = '04'
;




-- 18. MOD �Լ��� ����Ͽ� �����ȣ�� ¦���� ����� ����Ͻÿ�.
-- mod(�÷�, ���) -> ������ ��
select *
from emp
where mod(empno, 2)= 0
;





-- 19. �Ի����� �⵵�� 2�ڸ�(YY), ���� ����(MON)�� ǥ���ϰ� ������ ��� (DY)�� �����Ͽ� ����Ͻÿ�.
select  to_char(hiredate, 'YY MON DY')
from emp
;


-- 20. ���� �� ĥ�� �������� ����Ͻÿ�.
--     ���糯¥���� ���� 1�� 1���� �� ����� ����ϰ� TO_DATE �Լ��� ����Ͽ� ������ ���� ��ġ ��Ű�ÿ�.
-- date - date
select  trunc(sysdate - to_date('2019/01/01', 'YYYY/MM/DD'))
from dual
;



-- 21. ������� ��� ����� ����ϵ� 
--     ����� ���� ����� ���ؼ��� NULL �� ��� 0���� ����Ͻÿ�.
select empno, ename, nvl(mgr, 0)
from emp
;



-- 22. DECODE �Լ��� ���޿� ���� �޿��� �λ��ϵ��� �Ͻÿ�. 
--     ������ ��ANALYST���� ����� 200, 
--     ��SALESMAN���� ����� 180, 
--     ��MANAGER���� ����� 150, 
--     ��CLERK���� ����� 100�� �λ��Ͻÿ�.

select empno, ename, job, sal,
        decode(job,
            'ANALYST', sal+200,
            'SALESMAN', sal+180,
            'MANAGER', sal+150,
            'CLERK', sal+100        
        ) as UPSAL
from emp
;




-- 23. ��� ����� 
--     �޿� �ְ��, ������, �Ѿ� �� ��� �޿��� ����Ͻÿ�. 
--     ��տ� ���ؼ��� ������ �ݿø��Ͻÿ�.
select max(sal), min(sal), sum(sal), round(avg(sal)), avg(sal)
from emp
;




-- 24. �� ��� ���� ��������
--     �޿� �ְ��, ������, �Ѿ� �� ��� ���� ����Ͻÿ�.
--     ��տ� ���ؼ��� ������ �ݿø� �Ͻÿ�.
select job, max(sal), min(sal), sum(sal), round(avg(sal)), avg(sal)
from emp
group by job
;



-- 25. COUNT(*) �Լ��� �̿��Ͽ� �������� ������ ��� ���� ����Ͻÿ�.

select job, count(*)
from emp
group by job
;




-- 26. ������ ���� �����Ͻÿ�.
-- ���� �Լ��� ��� null ���ܽ�Ű�� ó��

select count(distinct mgr)
from emp
;




-- 27. �޿� �ְ��, �޿� �������� ������ ����Ͻÿ�.

select max(sal), min(sal), max(sal)-min(sal)
from emp
;



-- 28. ���޺� 
--     ����� ���� �޿��� ����Ͻÿ�. 
--     �����ڸ� �� �� ���� ����� ���� �޿��� 2000 �̸��� �׷��� ���ܽ�Ű�� ����� 
--     �޿��� ���� ������������ �����Ͽ� ����Ͻÿ�.

select job, min(sal) as minsal
from emp
where mgr is not null
group by job
HAVING min(sal) >= 2000
order by minsal desc
;



-- 29. �� �μ��� ����
--     �μ���ȣ, ��� ��, �μ� ���� ��� ����� ��� �޿��� ����Ͻÿ�. 
--     ��� �޿��� �Ҽ��� ��° �ڸ��� �ݿø� �Ͻÿ�.
--     round(�÷�, �ڸ���)
select deptno, count(*), round(avg(sal),2)
from emp
group by deptno
;




-- 30. �� �μ��� ���� --> e.deptno, d.deptno, dname
--     �μ���ȣ �̸�, ���� ��, ��� ��, �μ����� ��� ����� ��� �޿��� ����Ͻÿ�. 
--     ��� �޿��� ������ �ݿø� �Ͻÿ�. DECODE ���.
select e.deptno, d.dname, d.loc, count(*), round(avg(sal))
from emp e, dept d
where e.deptno=d.deptno
group by e.deptno, d.dname, d.loc
;




-- 31. ������ ǥ���� ���� 
--     �ش� ������ ���� 
--     �μ� ��ȣ�� �޿� �� �μ� 10, 20, 30�� �޿� �Ѿ��� ���� ����Ͻÿ�. 
--     ��Ī�� �� job, dno, �μ� 10, �μ� 20, �μ� 30, �Ѿ����� �����Ͻÿ�. 
--     ( hint. Decode, group by )


select job, deptno,

    decode(deptno, 10, sum(sal)) as "�μ�10",
    decode(deptno, 20, sum(sal)) as "�μ�20",
    decode(deptno, 30, sum(sal)) as "�μ�30",
    sum(sal) as "�Ѿ�"


from emp
group by job, deptno
order by deptno
;



 