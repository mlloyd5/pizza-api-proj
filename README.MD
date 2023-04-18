### Getting started

From project directory

To kick off the "test api" (input data). This will run on localhost:8081
`mvn -f test-api spring-boot:run`

In the docker folder, run the following to build a postgres image and start the container
`docker build -t postgres-pizza-toppings .`
`docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres-pizza-toppings`

To insert data from the test api into postgres, run the `pull_user_toppings.sh` from the `retrieve-users-script` directory. (We require `curl, jq, psql, envsubst`)

To kick off the topping api (output data). This will run on localhost:8080
`mvn -f pizza-api spring-boot:run`


### test-api endpoint
"generateToppings?count=10"
* will generate a random json list of users and toppings

### topping api endpoints

"/findAll"
* returns every user and topping association 

"findByUserName/{userName}"
* return a user and the toppings associated with the named user

"findByToppingName/{toppingName}"
* get topping_id, and topping_name for a given topping name

"countToppings/{toppingName}"
* given a topping, count distinct users

"topToppings"
* will list the top toppings and their count