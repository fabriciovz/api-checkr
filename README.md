# Api-Checkr

This is an api developed in Spring Boot with Layer oriented architecture and Domain Driven Development (DDD).

Java version: openjdk version "14.0.1"
Maven: "3.6.3_1"

### Mars Rovers Model

![alt text](https://github.com/fabriciovz/api-checkr/blob/master/src/main/resources/static/imgs/rover.jpg?raw=true)

### Input and Output Examples:

Test Input:
```sh
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

Expected Output:
```sh
1 3 N
5 1 E
```

### Installation

If you want to initialize the project, use this command (you'll create an image and container, then it run the docker container):
```sh
$ make app-init
```

If you only want to run the container, use this one:
```sh
$ make app-start
```

If you only want to stop the container, use this one:
```sh
$ make app-stop
```

### Postman

If you want to check the endpoints with postman, you can download the environment and the collection file:

https://github.com/fabriciovz/api-checkr/blob/master/src/main/resources/static/postman/api-checkr.json

### Something went wrong?

If you want to reset the container:
```sh
$ make app-reset
```

If you want to uninstall the api:
```sh
$ make app-uninstall
```

For more information, please have a look at the Makefile
