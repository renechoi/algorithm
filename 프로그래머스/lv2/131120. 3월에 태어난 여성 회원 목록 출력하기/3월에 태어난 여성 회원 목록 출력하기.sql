-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d')
from member_profile 
where gender = 'W'
and MONTH(date_of_birth) = 3
and TLNO is not null
order by member_id