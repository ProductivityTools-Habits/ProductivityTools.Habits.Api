```
.\gradlew.bat wrapper
.\gradlew.bat bootrun
```

Open [page](http://localhost:8080/graphiql?path=/graphql)

invoke
```
query getPersonQuery{
  getPerson {
    firstName,
    lastName
  }
}