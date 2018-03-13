# DROP TABLE IF EXISTS `Person`;
# CREATE TABLE `Person` (
#   Id INT NOT NULL PRIMARY KEY,
#   Email CHAR(20)
# );
#
# INSERT INTO Person (Id, Email) VALUES
#   (1, 'john@example.com'),
#   (2, 'bob@example.com'),
#   (3, 'john@example.com');

DELETE FROM Person WHERE Id NOT IN (SELECT p.Id FROM (SELECT min(Id) as Id FROM Person GROUP BY Email) p)