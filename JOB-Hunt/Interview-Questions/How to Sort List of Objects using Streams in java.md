# How to Sort List of Objects using Streams in java ?

#pending
### Simplest sorting
- Lets say List of Strings 
```

list.stream().sorted().collect(Collectors.toList());
```


### Sort a list of Object
- Here we have empList , which is a list of employee objects
```

		List<Employee> sortedGuys=empList.stream()
				.filter(e -> e.getSal()>15)
				.sorted(Comparator.comparing(employee -> employee.getSal()))
				.collect(Collectors.toList());

```


