SELECT * FROM project.member;
commit;

-- 암호화 함수
select 
	password(upw) as password, 
    sha(upw) as sha,
    sha1(upw) as sha1, 
    sha2(upw, 256) as sha2, 
    md5(upw) as md5,
    HEX(AES_ENCRYPT(upw, 'password')) as AES_ENCRYPT1 ,
    AES_ENCRYPT(upw, SHA2('password', 256)) as AES_ENCRYPT2
     
from project.member limit 0,1;

-- 암호화
update project.member set upw=HEX(AES_ENCRYPT('1111', 'password')) where idx = 29;
-- 복호화
select CONVERT(AES_DECRYPT(UNHEX(upw), 'password') using utf8) from project.member where idx=29;
select AES_DECRYPT(UNHEX(upw), 'password') from project.member where idx=29;

-- 암호화
update project.member set upw=HEX(AES_ENCRYPT('1111', SHA2('password', 256))) where idx = 29;
-- 복호화
select CONVERT(AES_DECRYPT(UNHEX(upw),  SHA2('password', 256)) using utf8) from project.member where idx=29;
select AES_DECRYPT(UNHEX(upw),  SHA2('password', 256)) from project.member where idx=29;
