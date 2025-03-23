
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

