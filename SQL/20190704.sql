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





