# Write your MySQL query statement below
select e2.name as Employee
from Employee e
join Employee e2
on e.id = e2.managerId
where e2.salary > e.salary;