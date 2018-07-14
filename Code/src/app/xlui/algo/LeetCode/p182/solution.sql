select p.Email from Person as p
group by p.Email
having count(*) > 1;