select info.rest_id as REST_ID, info.REST_NAME, info.FOOD_TYPE, info.FAVORITES, info.ADDRESS, round(AVG(review.REVIEW_SCORE), 2) as SCORE
from REST_INFO info, REST_REVIEW review
where info.address like '서울%' and info.REST_ID = review.REST_ID
group by info.REST_ID
order by score desc, info.FAVORITES desc



