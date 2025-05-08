
1. DAG -> data pipeline and each data pipleine will have stages or task and for Dag there should not be any cycles in these Dags means they are directed acyclic.
2. when Airflow triggers a DAG, it creates a DAG run with information such as the logical_date, data_interval_start, and data_interval_end.
3. Dag -> A node is a task 
	1. A task is an operator 
	2. Operator is a object that encapsulates the logic
4. Airflow Triggers Task it creates a task instance.



#### Prerequisites to learn airflow 
- [ ] Run simple container in using docker 
	- [ ] note all the important docker commands
- [ ] Create docker container 
	- [ ] install python on that container 
	- [ ] Create a simple python program on vscode on local.
	- [ ] Run this python code on Docker container.
- [ ] Run a simple Dag 
- [ ] Connect a vscode to container and run the dag again
- [ ] Learn more arguements of Dag.
- [ ] Simple Python Operator Program 
- [ ] Simple BashOperator Dag 



#### docker 
1. `docker images`
2. `docker ps -a`
3. `docker pull ubuntu` -> this will download the image to local 
	1. `docker run -it ubuntu` -> to run a docker image in interactive way this way you will be login to the docker container and perform anything on the container, 
4. `docker run hello-world:latest`
5. `docker run -d nginx:latest`  --> -d means it will run on detach mode since usually when you will run a container it should be running indefintely.
6. `docker logs <container_id_or_name>` 
7. `docker exec -it <container_id_or_name> <command>` -> execute a command on a running container 
8. `docker exec -it ce39733dcfec ls -alh`  
9. Create your image 
	1. create your dockerfile -> with name : `Dockerfile`

```sh

FROM node:latest
COPY app.js .
ENTRYPOINT ["node"]
CMD ["app.js"]

````

2. Create  a file app.js -> and keep the content as `console.log("Hello World");`
3. create a docker image : `docker build -t demo-image:latest .`
4. run a docker image : `docker run demo-image:latest`


Here are some of the most commonly used Docker commands:

1. **Pull an image from Docker Hub**:
    ```sh
    docker pull <image_name>
    ```

2. **List all Docker images**:
    ```sh
    docker images
    ```

3. **Run a container from an image**:
    ```sh
    docker run -it <image_name>
    ```

4. **List all running containers**:
    ```sh
    docker ps
    ```

5. **List all containers (including stopped ones)**:
    ```sh
    docker ps -a
    ```

6. **Stop a running container**:
    ```sh
    docker stop <container_id_or_name>
    ```

7. **Start a stopped container**:
    ```sh
    docker start <container_id_or_name>
    ```

8. **Remove a container**:
    ```sh
    docker rm <container_id_or_name>
    ```

9. **Remove an image**:
    ```sh
    docker rmi <image_id_or_name>
    ```

10. **View logs of a container**:
    ```sh
    docker logs <container_id_or_name>
    ```

11. **Execute a command in a running container**:
    ```sh
    docker exec -it <container_id_or_name> <command>
    ```

12. **Build an image from a Dockerfile**:
    ```sh
    docker build -t <image_name> <path_to_dockerfile>
    ```

13. **Remove all stopped containers**:
    ```sh
    docker container prune
    ```

14. **Remove all unused images**:
    ```sh
    docker image prune
    ```

These commands cover a wide range of basic Docker operations, from managing images and containers to executing commands and cleaning up resources.



#### docker 

1. Port forwarding in containers 
	2.un a nginx server and attach port 8800 of local host to 80 port of the container 
	1. `docker run --name nginx -p 8800:80 -d nginx:latest`

2. Using Volumes to Store Container Data 
	1. 

