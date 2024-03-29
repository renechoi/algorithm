-- 코드를 입력하세요
SELECT BOOK.BOOK_ID, AUTHOR.AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK, AUTHOR
where 
     BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID and 
     category = '경제'
order by PUBLISHED_DATE asc
