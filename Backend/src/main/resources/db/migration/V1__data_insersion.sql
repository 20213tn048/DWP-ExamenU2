CREATE TABLE books(
    book_id BIGINT AUTO_INCREMENT,
    title VARCHAR(255)  NOT NULL,
    author VARCHAR(255) NOT NULL,
    publication_date DATE NOT NULL,
    image VARCHAR(255),
    PRIMARY KEY (book_id)
);