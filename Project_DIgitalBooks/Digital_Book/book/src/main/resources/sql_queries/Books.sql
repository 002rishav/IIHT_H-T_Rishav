CREATE TABLE if not exists library.books (
    id int primary key auto_increment,
    book_id varchar(255) unique not null ,
    author_id varchar(255),
    author varchar(255),
    logo varchar(255),
    title varchar(255),
    category varchar(255),
    price int,
    publisher varchar(255),
    published_date timestamp default current_timestamp,
    content varchar(255),
    active boolean
);