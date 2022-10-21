### How to run this application
This project uses java 17, generate a jar file and specify the configuration location with allowed-config.location argument.
Example: java -jar -Dallowed-config.location=/tom/config.txt <jar_name>.jar

The option -Dallowed-config.location is mandatory.


The config file has this syntax:

---

allowed: < boolean value in lowercase >

---

Example:

---

allowed: false

---

The project uses the hexagonal architecture:

See this for more information about this architecture https://blog.octo.com/hexagonal-architecture-three-principles-and-an-implementation-example/


#### To add an user


---
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstname": "john",
"lastname": "doe"
}'

---

this returns the id of the user that has been created, you can use this ID to call the endpoint to get a user

#### To get a user



Example


---

curl --location --request GET 'http://localhost:8080/users/1'

---
This returns:

---
{
"firstname": "john",
"lastname": "doe"
}
---

#### To get the configuration

call the /config endpoint. Example:

---

curl --location --request GET 'http://localhost:8080/config'

---

This returns:
---
{
"config": true
}
---