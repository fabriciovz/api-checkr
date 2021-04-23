app-container-up:
	docker run --name API_CHECKR -p 7001:7001 -d fabribraguev/api-checkr

app-image-up:
	mvn clean package
	docker build -t fabribraguev/api-checkr -f Dockerfile .

app-init:
	make app-image-up
	make app-container-up

app-start:
	docker start API_CHECKR

app-stop:
	docker stop API_CHECKR

app-rm-container:
	docker rm API_CHECKR

app-stop-rm:
	make app-stop
	make app-rm-container

app-rm-image:
	docker rmi fabribraguev/api-checkr

app-reset:
	make app-stop-rm
	make app-rm-image
	make app-init

app-uninstall:
	make app-stop-rm
	make app-rm-image

app-bash:
	docker exec -it API_CHECKR bash