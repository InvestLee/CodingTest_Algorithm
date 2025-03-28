-- 코드를 입력하세요
SELECT C.AUTHOR_ID, C.AUTHOR_NAME, D.CATEGORY, SUM(BOOK_SALES) AS TOTAL_SALES
FROM AUTHOR C,
(
SELECT A.BOOK_ID, A.CATEGORY, A.AUTHOR_ID, A.PRICE * B.BOOK_AMOUNT AS BOOK_SALES
FROM BOOK A,
(SELECT BOOK_ID, SUM(SALES) AS BOOK_AMOUNT FROM BOOK_SALES 
WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202201'
GROUP BY BOOK_ID) B
WHERE A.BOOK_ID = B.BOOK_ID
) D
WHERE C.AUTHOR_ID = D.AUTHOR_ID
GROUP BY C.AUTHOR_ID, C.AUTHOR_NAME, D.CATEGORY
ORDER BY C.AUTHOR_ID ASC, D.CATEGORY DESC