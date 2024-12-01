-- 코드를 입력하세요
SELECT MCDP_CD AS 진료과코드, COUNT(MCDP_CD) AS "5월예약건수" from APPOINTMENT 
where TO_CHAR(apnt_ymd, 'YYYYMM') = '202205'
GROUP BY MCDP_CD
ORDER BY 2, 1