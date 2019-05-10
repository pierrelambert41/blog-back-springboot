TRUNCATE TABLE article;
INSERT INTO article
(title, created_date, modified_date, description) VALUES
("FRCYMB","2018-09-24","2018-09-24", "ceci est mon 1er paragraphe"),
("FRCYMB","2018-09-24","2018-09-24", "ceci est mon 2er paragraphe");

TRUNCATE TABLE user;
INSERT INTO user
(firstname, lastname) VALUES
("Aurelie", "Lambert"),
("Pierre", "Lambert");

