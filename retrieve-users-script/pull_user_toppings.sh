#!/bin/bash
## Requirements: curl, jq, psql, envsubst

export PGPASSWORD="mysecretpassword"
API_URL="http://localhost:8081/generateToppings?count=100"
# other things to maybe add:
# - configurable count with args
# - looping for pagination in the api
# - apply settings from a config file
# - headers for auth to the api (need to edit curl request)
# - depending on expected size, might need to save to file and use jq --stream feature flag

JSON=`curl -s --request GET --url $API_URL`

# check value returned from curl is:
# - a nonempty string
# - a valid json
# - a non-empty json
if [[ ! -z $JSON &&\
	`echo $JSON | jq empty > /dev/null 2>&1; echo $?` -eq 0 &&\
	`echo $JSON | jq length` -ne 0 ]];
then
	export TOPPINGS=`echo $JSON | jq --raw-output '[.[].toppings[] | select(length > 0)] | unique | "('\''\(.[])'\'')"' | sed '$!s/$/,/'`
	export USERS=`echo $JSON | jq --raw-output '[.[].user | select(length > 0)] | unique | "('\''\(.[])'\'')"' | sed '$!s/$/,/'`
	export USER_TOPPINGS=`echo $JSON | jq --raw-output '[.[] | select(.toppings[] != "" )] | group_by(.user) | map({user: .[0].user, toppings: ([.[].toppings[]] | unique)[]})[] | "('\''\(.user)'\'', '\''\(.toppings)'\'')"' | sed '$!s/$/,/'`


	QUERY=`cat query.sql | envsubst`

	echo $QUERY

	unset TOPPINGS
	unset USERS
	unset USER_TOPPINGS

	echo $QUERY | psql -h localhost -p 5432 -U postgres postgres

else
	# Here could put a pagerduty/slack webhook or email alert

	echo "curl was empty or an errorr"

fi;