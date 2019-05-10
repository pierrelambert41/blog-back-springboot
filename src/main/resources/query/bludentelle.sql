TRUNCATE TABLE article;
INSERT INTO article
(title, created_at, modified_at, description, user_id, category_id) VALUES
("FRCYMB","2018-09-24","2018-09-24", "ceci est mon 1er paragraphe", 1, 1),
("FRCYMB","2018-09-24","2018-09-24", "ceci est mon 2er paragraphe", 2, 2);

TRUNCATE TABLE user;
INSERT INTO user
(firstname, lastname, email) VALUES
("Aurelie", "Lambert", "lambertaurelie17@gmail.com"),
("Pierre", "Lambert", "pierrelambert41@gmail.com");

TRUNCATE TABLE category;
INSERT INTO category
(name) VALUES
("Mariage"),
("Voyage");

TRUNCATE TABLE comment;
INSERT INTO comment
(author, content, email, created_at, article_id) VALUES
("Toto", "ceci est mon commentaire 1", "toto@gmail.com", "2019-05-12", 1),
("Toto2", "ceci est mon commentaire 2", "toto2@gmail.com", "2019-05-12", 2);

