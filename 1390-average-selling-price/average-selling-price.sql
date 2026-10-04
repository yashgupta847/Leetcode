# Write your MySQL query statement below
select prices.product_id , IFNULL(ROUND(SUM(units*price)/SUM(units),2),0) AS average_price
from Prices prices left join UnitsSold unit on prices.product_id = unit.product_id and
unit.purchase_date BETWEEN prices.start_date AND prices.end_date
group by product_id