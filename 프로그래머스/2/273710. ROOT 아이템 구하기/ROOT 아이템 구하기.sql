-- 코드를 작성해주세요
select A.ITEM_ID, A.ITEM_NAME from ITEM_INFO A, ITEM_TREE B
where A.ITEM_ID = B.ITEM_ID
and B.PARENT_ITEM_ID is null
ORDER BY A.ITEM_ID