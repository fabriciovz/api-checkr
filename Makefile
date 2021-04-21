api-container-up:
	docker run --name API_CHECKR -p 8080:7001 -d fabribraguev/api-checkr

api-image-up:
	mvn clean package
	docker build -t fabribraguev/api-checkr -f Dockerfile .

api-init:
	make api-image-up
	make api-container-up

api-start:
	docker start API_CHECKR

api-stop:
	docker stop API_CHECKR

api-rm-container:
	docker rm API_CHECKR

api-stop-rm:
	make api-stop
	make api-rm-container

api-rm-image:
	docker rmi fabribraguev/api-checkr

api-reset:
	make api-stop-rm
	make api-rm-image
	make api-init

api-uninstall:
	make api-stop-rm
	make api-rm-image

api-bash:
	docker exec -it API_CHECKR bash