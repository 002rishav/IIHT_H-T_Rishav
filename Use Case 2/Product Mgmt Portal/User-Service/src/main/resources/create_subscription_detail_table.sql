CREATE TABLE if not exists user_service.subscription_details (
	id int primary key auto_increment,
    book_id varchar(255) not null,
    user_name varchar(255) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    CONSTRAINT UNIQUE(book_id,user_name)
    );