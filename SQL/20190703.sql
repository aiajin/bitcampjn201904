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







