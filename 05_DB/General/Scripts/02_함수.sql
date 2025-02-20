/*함수:  컬럼값 | 지정된값을 읽어 연산한 결과를 반환하는 것
 * 1.단일행 함수(N->N)
 * -N 개의 행의 컬럼값을 전달하여 N개의 결과를 반환
 * 2.그룹 함수(N->1)
 * -N 개의 행의 컬럼값을 전달하여 1개의 결과를 반환
 * 
 * 함수는
 * select절 ,where절, order by절
 * group by절 ,having절에서 사용 가능
 * */
/*단일행 함수*/
/*length(컬럼명|문자열) : 문자열길이 반환*/
SELECT 'hello world', LENGTH ('hello world')
FROM dual

SELECT EMP_NAME ,EMAIL ,LENGTH (EMAIL) "이메일 길이"
FROM EMPLOYEE 
WHERE LENGTH(EMAIL) <= 12
ORDER BY 3 ASC

/*instr(문자열|컬럼명,'찾을 문자열' [,시잗위치[,순번]]
 * -시작 위치 부터 지정된 순번까지
 * 문자열| 컬럼값에서 찾을 문자열의 인덱스 위치를 반환
 */
 
SELECT 'AABBCCABC' , instr('AABBCCABC','B')
FROM dual;

SELECT 'AABBCCABC' , instr('AABBCCABC','B',5)
FROM dual;

SELECT 'AABBCCABC' , instr('AABBCCABC','C',5,3)
FROM dual;

/*substr(문자열,시작위치[,길이])
 * -문자열을 시작위치부터 지정된 길이만큼 잘라서 반환
 * -길이 미작성시 시작위치 ~끝 까지 잘라서 반환
 * */

SELECT SUBSTR(EMAIL,1, INSTR(EMAIL,'@') - 1)
FROM EMPLOYEE 

/* Trim(옵션 문자열 from 대상 문자열)
 * 대상 문자열에 앞뒤양쪽에 존재하는 지정된 문자열 제거
 * 옵션 LEADING(앞),TRAILING(뒤),BOTH(양쪽, 기본값)*/

SELECT '###기###준',
TRIM(LEADING 	'#' FROM '###기###준'), 
TRIM(trailing '#' FROM '###기###준'), 
TRIM(both 		'#' FROM '###기###준') 
FROM DUAL ;

SELECT NATIONAL_NAME ,
REPLACE (NATIONAL_NAME,'한국','대한민국')
FROM "NATIONAL";


SELECT EMAIL ||' -> '|| REPLACE (EMAIL,'or.kr','gmail.com')
FROM EMPLOYEE 

SELECT '###기###준',REPLACE ('###기###준','#','')AS 변경
FROM dual

-----------------------------------------------------------------
/*숫자관련 함수
 * 
 * - MoD(숫자,나눌 값) : 결과로 나머지 반환
 * -abs(숫자): 절대값
 * -ceil(실수) :올림-> 정수형태로 반환
 * -floor(실수) :내림-> 정수형태로 반환
 * -round(실수[,소수점위치] : 반올림
 * 1) 소숫점 위치x :소수점 첫쨰 자리에서 반올림 -> 정수
 * 2) 소수점 위치o :지정된 위치가 표현 되도록 반올림
 * 
 * -trunc(실수[,소수점위치]):버림
 * */

SELECT mod(7,4) FROM dual;

SELECT ABS(-333) FROM dual;

SELECT CEIL(1.1),FLOOR(1.9)FROM dual;

SELECT 
ROUND(123.456),
ROUND(123.456,1),
ROUND(123.456,2),
ROUND(123.456,0),
ROUND(123.456,-1)
FROM dual;


SELECT 
TRUNC(123.456) ,
TRUNC(123.456,1), 
TRUNC(123.456,2) 
FROM dual;

SELECT 
 trunc(-123.5),FLOOR(-123.5)
 FROM dual
 
 /* 날짜 관련 함수*/
 /* month_Between(날짜,날짜)
  * -두 날짜 사이의 개월수 반환*/
SELECT CEIL(MONTHS_BETWEEN(TO_DATE('2025-07-17','YYYY-MM-DD'), CURRENT_DATE)) 
FROM dual

SELECT CEIL ((SYSDATE - TO_DATE('2001.03.20','YYYY-MM-DD'))/365) +1,
FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE('2001.03.20','YYYY-MM-DD'))/12) 
FROM dual

/* add_month(날짜, 숫자)
 * -날짜에 숫자 만큼의 개월 수 추가
 * 달마다 일 수가 다르기 때문에
 * 계산이 쉽지 않음 -> 쉽게 계산할 수 있느 함수 제공*/

SELECT SYSDATE +28,ADD_MONTHS(SYSDATE,1)
FROM dual

/*last_day(날짜)
 * -해당 월의 마지막 날짜를 반환
 * -월 마르 월 초 구하는 용도로 많이 사용*/

SELECT 
	LAST_DAY(SYSDATE), LAST_DAY(SYSDATE) +1 "다음달1일",
	ADD_MONTHS(LAST_DAY(SYSDATE)+1,-1) AS "이번달 1일" 
FROM dual

--------------------------------------------------------------
/*extract(year|month|day from 날짜)
 * -뜻 뽑아내다 추출하다
 * -지정된 년|월|일을 추출하여 '정수' 형태로 반환*/

SELECT EMP_ID ,EMP_NAME ,HIRE_DATE 
FROM EMPLOYEE 
WHERE EXTRACT (YEAR FROM HIRE_DATE) 
BETWEEN 2010 AND 2019
/*TO_DATE('2010.01.01','YYYY-MM-DD') 
AND 
TO_DATE('2019.12.31','YYYY-MM-DD') */
ORDER BY HIRE_DATE DESC 

----------------------------------------------------------------------------
/*형변환 함수
 * 문자열<->숫자
 * 문자열<->날짜
 * 숫자<->날짜
 */

/*to_date 
 * 포맷 종류
 * YY:연도
 * YYYY:연도
 * 
 * RR:
 * RRRR:
 * 
 * MM:월
 * DD:일
 * am/pm: 오전/오후(둘중 아무거나 작성가능)
 * 
 * HH: 12시간표기법
 * HH24: 24시간 표기
 * MI:분
 * SS:초
 * 
 * DAY :요일(전체)
 * DY : 요일(약어)
 */
SELECT 
	'2025-02-21 17:50:00(금)' AS 문자열,
	TO_DATE('2025-02-21 17:50:00 (금)','YYYY-MM-DD HH24:MI:SS (DY)') AS 날짜
	FROM DUAL;

SELECT 
'16:20:43 목요일 02-20/2025' AS 문자열
,TO_DATE('16:20:43 목요일 02-20/2025','HH24:MI:SS DAY MM-DD/YYYY')AS 날짜 
FROM dual

SELECT
	'2025년 02월 20일' AS 문자열,
	TO_DATE('2025년 02월 20일',
	'YYYY"년" MM"월" DD"일"') AS 날짜 
FROM dual


------------------------------------------------------------------------------

/* to_CHAR(숫자|날짜)*/
/*1)9 t숫자1칸을 의미, 오른쪽 정렬
 *2)0 : 숫자 1칸을 의미 오른쪽 정렬 빈칸을 0으로 채움
 *3)L : 현재 시스템 또는 DB설정 국가의 화폐 기호
 *4),: 숫자 자릿수 구분*/

SELECT  1234,TO_CHAR(1234,'000000000') FROM dual; 

SELECT 100000000, TRIM(TO_CHAR(100000000,'L999,999,999') )
FROM dual; 

SELECT EMP_NAME ,TRIM( TO_CHAR(SALARY*13,'L999,999,999')) 연봉 
FROM EMPLOYEE 
ORDER BY SALARY*13 DESC 

/*(참고)
 * -문자열 정렬 기준은
 * 글자쑤 글자 순서등에 영향이 있기 때문에
 * 정렬시 생가을 잘 해봐야함
 * 숫자 날짜는 정렬 기준으로 사용하기 좋다
 * (크고, 작다의 기준이 단순하고 명확해서)
 * 
 */
-------------------------------------------------------------------
SELECT 
TO_CHAR(CURRENT_DATE,'YYYY/MM/DD day')
FROM dual

SELECT 
TO_CHAR(SYSDATE,'YYYY.MM.DD (DY) AM HH:MI:SS') AS 날짜
FROM DUAL 

SELECT 
TO_CHAR(SYSDATE,'YYYY"년"MM"월"DD"일" (DY) PM HH"시"MI"분"SS"초"') AS 날짜
FROM DUAL 

/*R,Y 차이점
 * YY: 연도 상관헚이 현재 세기로 표기
 * RR: 50을 기준으로 */
SELECT 
	TO_DATE('25/02/20' ,'YY/MM/DD') AS YY, 
	TO_DATE('25/02/20' ,'RR/MM/DD') AS RR
FROM DUAL 
----------------------------------------------
/* to_number :문자열-> 숫자
 * select '123456789',to_number('123456789') from dual
 */
 
 SELECT '123456789',to_number('123456789') from dual;
 
 SELECT '$1500',TO_NUMBER('$1,500','$9,999') AS 숫자
 from dual;