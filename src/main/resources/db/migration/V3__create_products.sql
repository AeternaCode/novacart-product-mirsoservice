create table products (
                          id int not null AUTO_INCREMENT primary key,
                          product_name varchar(255) not null,
                          product_image_url varchar(255) not null default 'nothing.jpg',
                          product_brand varchar(255) not null default 'N/A',
                          rating decimal(2,1) not null default 0,
                          product_description text ,
                          price decimal(10,2) not null default 0,
                          stock_quantity int not null default 0,
                          created_at datetime default current_timestamp,
                          updated_at datetime default current_timestamp on update current_timestamp,
                          deleted_at datetime default NULL,
                          is_active boolean not null default true,
                          created_by int not null default 1111,
                          updated_by int not null default 1111,
                          category_id int not null,
                          foreign key (category_id) references categories(id)
);