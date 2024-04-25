-- shop과 cart join
select cartnum,username,sangpum,price,color,date_format(guipday, '%Y-%m-%d %H-%i') guipday
from shop,cart
where shop.shopnum=cart.shopnum;

-- shop과 cart join 방법2
select cartnum,username,sangpum,price,color,date_format(guipday, '%Y-%m-%d %H-%i') guipday
from shop
inner join cart
on shop.shopnum=cart.shopnum;

-- 욱입력시 욱이 포함된 이름을 가진 데이터 출력
select * from sawon where name like '%유%';

-- 없을 경우
select * from sawon where name like '%락%';

select * from sawon where name like concat('%','유','%');

select * from sawon;

delete from sawon where name='황정아';
delete from sawon where name='마이클';

SET SQL_SAFE_UPDATES = 0;