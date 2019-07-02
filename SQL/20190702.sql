-- 2019.07.02


-- ���̺��� �÷����� �����μӼ��� Ȯ��
-- ������ �Է� ��, ������ ���� ��
DESC dept;

-- �����͸� �˻��ϴ� ���
-- select {�÷� �̸�,...} from ���̺� �̸�
select * from dept;
select deptno from dept;
select dname from dept;
select dname, loc, deptno from dept;

-- emp ���̺� Ȯ��
desc emp;
-- ��ü �÷� ���
select * from emp;
-- ����� ��ȣ, �̸��� ����Ʈ 
select empno, ename   from emp;

-- �÷��� ��Ģ����
select sal from emp;
select sal + comm  from emp; -- null �� ������ ��� ->  null
select sal, sal + 100 from emp;
select sal, sal - 100 from emp;
select ename, sal, sal * 12 from emp;
select sal, sal/5 from emp;

-- nvl �Լ� : Ư�� �÷��� �����Ͱ� null �ΰ�� Ư�� �����ͷ� ġȯ���ִ� �Լ�
-- nvl(�÷��̸�, ġȯ��)
select ename, sal, comm, sal*12+comm from emp;
select ename, sal, comm, sal*12+comm as ySal1, nvl(comm, 0), sal*12+nvl(comm,0) as ySal from emp;


-- �÷��� ���ڿ��� �����ϴ� ��� ��� , sql���� ���ڿ� ǥ���� ' ' �� ���´�.
select ename || ' is a ' || job as str from emp;

-- distnct : �÷������� �ߺ��Ǵ� ���� �����ϰ� �ϳ��� �����͸� ������ش�.
select distinct deptno from emp;


-- select �� ������ : select �÷���.. from ���̺� �� where ���ǽ�(true/false);
-- where �� ������ ���� ã�´�.
select dname 
from dept
where deptno = 10
;

select empno, ename, job
from emp
where deptno = 10
;

-- ���� ���� ��� ���� ����ǥ�� ǥ��, ��ҹ��� ����!!!!!!!!!!!!
select EMPNO, JOB
from emp
where ename='SCOTT'
;

-- ��¥ �˻� : ��¥ �����͸� '' �����ش�.
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > '81/12/03'
;

-- �� ���� : AND, OR, NOT
SELECT *
FROM EMP
WHERE  DEPTNO=30 AND JOB='MANAGER'
;
SELECT *
FROM EMP
WHERE DEPTNO=10 OR DEPTNO =20
;
SELECT *
FROM EMP
WHERE NOT DEPTNO=30
;

-- �÷��� BETWEEN A AND B ������ : A�̻� B������ ���� ����
SELECT *
FROM EMP
WHERE SAL BETWEEN 2000 AND 3000
--WHERE SAL > 2000 AND SAL < 3000
;

--  ���� ������ ��¥ ���굵 �����ϴ�.
SELECT *
FROM EMP
WHERE HIREDATE BETWEEN '1987/01/01' AND '1987/12/31'
;

-- IN : OR ������ ������ ���
SELECT *
FROM EMP
--WHERE COMM IN(300, 500, 1400)
WHERE COMM=300 OR COMM=500 OR COMM=1400
;