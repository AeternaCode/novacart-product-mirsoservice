CREATE TABLE categories (
                            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            category_name VARCHAR(255) NOT NULL UNIQUE,
                            created_at datetime NOT NULL default current_timestamp,
                            updated_at datetime NOT NULL default current_timestamp on update current_timestamp,
                            deleted_at datetime default NULL,
                            is_active boolean not null default true,
                            created_by int not null default 1111,
                            updated_by int not null default 1111
);