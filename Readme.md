```
.\gradlew.bat wrapper
.\gradlew.bat bootrun
```

Open [page](http://localhost:8080/graphiql)

invoke
```
query getPersonQuery{
  getPerson {
    firstName,
    lastName
  }
}
```

query getPersonQuery is optional we can do
```
{
  getPerson {
    firstName,
    lastName
  }
}
```

or 
```
query {
  getPerson {
    firstName,
    lastName
  }
}
```

```
query {
  getHabit {
    name
  }
}
```