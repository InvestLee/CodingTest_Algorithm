-- 코드를 입력하세요
SELECT a.MEMBER_NAME, b.REVIEW_TEXT, DATE_FORMAT(b.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE from MEMBER_PROFILE a
left outer join REST_REVIEW b on (a.MEMBER_ID = b.MEMBER_ID)
where a.MEMBER_ID = 
(SELECT MEMBER_ID FROM REST_REVIEW 
GROUP BY MEMBER_ID
ORDER BY COUNT(MEMBER_ID) DESC
LIMIT 1
)
order by b.REVIEW_DATE