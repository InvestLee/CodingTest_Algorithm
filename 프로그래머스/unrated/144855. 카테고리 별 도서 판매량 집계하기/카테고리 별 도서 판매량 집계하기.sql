-- 코드를 입력하세요
SELECT a.CATEGORY, sum(b.SALES) as TOTAL_SALES 
from BOOK a left outer join BOOK_SALES b on (a.BOOK_ID = b.BOOK_ID)
where year(b.SALES_DATE) = 2022 and month(b.SALES_DATE) = 1
GROUP BY a.CATEGORY
order by a.CATEGORY