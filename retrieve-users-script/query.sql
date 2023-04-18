INSERT INTO 
	toppings (topping_name) 
VALUES 
	${TOPPINGS}
ON CONFLICT DO NOTHING;

INSERT INTO 
	users (username) 
VALUES
	${USERS}
ON CONFLICT DO NOTHING;

WITH ins (username, topping_name) AS ( VALUES 
	${USER_TOPPINGS}
)
INSERT INTO user_toppings (user_id, topping_id)

SELECT users.user_id, toppings.topping_id
FROM ins, users, toppings
WHERE
	ins.username = users.username 
    AND ins.topping_name = toppings.topping_name
ON CONFLICT DO NOTHING;