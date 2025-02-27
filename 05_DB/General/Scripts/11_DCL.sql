/* DCL(Data Control Language) : 데이터 제어 언어
 * 
 * - 계정별로 DB 또는 DB 객체에 대한 
 *   접근(제어) 권한을 부여(GRANT), 회수(REVOKE)하는 언어
 * */


/* 계정(사용자)

* 관리자 계정 : 데이터베이스의 생성과 관리를 담당하는 계정.
                모든 권한과 책임을 가지는 계정.
                ex) sys(최고관리자), system(sys에서 권한 몇개 제외된 관리자)


* 사용자 계정 : 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의
                작업을 수행할 수 있는 계정으로
                업무에 필요한 최소한의 권한만을 가지는 것을 원칙으로 한다.
                ex) KH계정(각자 이니셜 계정), workbook 등
*/


/* 권한의 종류

1) 시스템 권한 : DB접속, 객체 생성 권한

CRETAE SESSION   : 데이터베이스 접속 권한
CREATE TABLE     : 테이블 생성 권한
CREATE VIEW      : 뷰 생성 권한
CREATE SEQUENCE  : 시퀀스 생성 권한
CREATE PROCEDURE : 함수(프로시져) 생성 권한
CREATE USER      : 사용자(계정) 생성 권한
DROP USER        : 사용자(계정) 삭제 권한
DROP ANY TABLE   : 임의 테이블 삭제 권한


2) 객체 권한 : 특정 객체를 조작할 수 있는 권한

  권한 종류                 설정 객체
    SELECT              TABLE, VIEW, SEQUENCE
    INSERT              TABLE, VIEW
    UPDATE              TABLE, VIEW
    DELETE              TABLE, VIEW
    ALTER               TABLE, SEQUENCE
    REFERENCES          TABLE
    INDEX               TABLE
    EXECUTE             PROCEDURE
*/



-------------------------------------------------------------


ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
DROP USER TEST06_KDY cascade

CREATE USER TEST06_KDY 
IDENTIFIED BY "TEST1234";

GRANT CREATE  SESSION TO TEST06_KDY;

GRANT RESOURCE TO TEST06_KDY

SELECT * FROM ROLE_SYS_PRIVS;
WHERE ROLE 

ALTER USER TEST06_KDY
DEFAULT TABLESPACE users
quota 10M ON users;

CREATE  TABLE test_table(
	test
);


SELECT  * FROM TEST06_KDY.employee;

GRANT SELECT ON employee
TO TEST06_KDY

REVOKE SELECT ON employee
FROM TEST06_KDY


