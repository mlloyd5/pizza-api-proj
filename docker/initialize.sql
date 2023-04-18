CREATE TABLE users (
    user_id serial PRIMARY KEY,
    username VARCHAR ( 128 ) UNIQUE NOT NULL)
);

CREATE TABLE toppings (
    topping_id serial PRIMARY KEY,
    topping_name VARCHAR ( 64 ) UNIQUE NOT NULL
);

CREATE TABLE user_toppings (
    user_id INT NOT NULL,
    topping_id INT NOT NULL,
    PRIMARY KEY (user_id, topping_id),
    FOREIGN KEY (user_id)
       REFERENCES users (user_id),
    FOREIGN KEY (topping_id)
       REFERENCES toppings (topping_id)
);