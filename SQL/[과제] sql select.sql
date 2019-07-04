-- [����] sql select

desc book;
desc customer;
desc orders;

--1 ���缭���ǰ��̿䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
--(1) ������ȣ��1�� �������̸�
select bookname
from book
--where bookid=1
where bookname like '%�౸%'
;


--(2) ������20,000���̻��� �������̸�
select bookname, price
from book
where price >= 20000
;


--(3) ���������ѱ��ž�(�������ǰ���ȣ��1�����γ����ۼ�)
select sum(saleprice) as "�ѱ��ž�", count(*) as "����Ƚ��"
from orders
where custid=1
;


--(4) �������̱����ѵ����Ǽ�(�������ǰ���ȣ��1�����γ����ۼ�)
select sum(saleprice) as "�ѱ��ž�", count(*) as "����Ƚ��"
from orders
where custid=1
;

--2 ���缭���ǿ�ڿͰ濵�ڰ��䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
--(1) ���缭���������Ѱ���
select count(*) as "�� �����ǰ���"
from book
;


--(2) ���缭��������������ϴ����ǻ����Ѱ���
select count(distinct publisher)
from book
;


--(3) ������ �̸�, �ּ�
select  name, address, nvl(phone, '�� ���')
from customer
;





--(4) 2014��7��4��~7��7�ϻ��̿��ֹ����� ������ �ֹ���ȣ

select orderid, orderdate
from orders
where orderdate between '14/07/04' and '14/07/07'
;






--(5) 2014��7��4��~7��7�ϻ��̿��ֹ����������������ѵ������ֹ���ȣ

select orderid, orderdate
from orders
where orderdate not between '14/07/04' and '14/07/07'
;




--(6) ���̡��衯���ΰ��� �̸����ּ�
select name, address
from customer
where name like '��%'
;







--(7) ���̡��衯���̰��̸��� ���ơ��γ����°����̸����ּ�
select name, address
from customer
where name like '��%��'
;





