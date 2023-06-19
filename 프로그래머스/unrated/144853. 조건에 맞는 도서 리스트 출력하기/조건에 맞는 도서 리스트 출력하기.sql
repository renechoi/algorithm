-- 코드를 입력하세요
SELECT book_id as BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK
where YEAR(PUBLISHED_DATE) = 2021 and category = '인문'