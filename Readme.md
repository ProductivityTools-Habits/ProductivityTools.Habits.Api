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


## Deploy on ubuntu

```
sudo apt install postgresql
sudo systemctl status postgresql

```

Connect
```
    sudo -u postgres psql
```

pgAdmin

```
curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg

sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'

sudo apt install pgadmin4

sudo /usr/pgadmin4/bin/setup-web.sh

sudo -u postgres psql

ALTER USER postgres WITH PASSWORD 'xx';
```

## create jar file

```
./gradlew clean build
```
build will be in ```build/libs/```

## Host Java application

sudo apt update
sudo apt install openjdk-17-jre -y

sudo useradd -m -s /bin/bash springuser
sudo mkdir /opt/PT.Habits
sudo chown -R springuser:springuser /opt/PT.Habits

sudo mv habits.api-0.0.1-SNAPSHOT.jar /opt/PT.Habits/
sudo chown springuser:springuser /opt/PT.Habits/habits.api-0.0.1-SNAPSHOT.jar


## Update java to 24 (68)
https://www.oracle.com/java/technologies/downloads/
sudo dpkg -i jdk-25_linux-x64_bin.deb

java -jar habits.api-0.0.1-SNAPSHOT.jar --spring.datasource.password=xx



----
ubuntu

```
chmod +x gradlew
./gradlew clean build
```






sudo cp habits.env.example /etc/default/habits

enable jenkins tu run command without sudo
```
sudo visudo
```

add line
```
jenkins ALL=(root) NOPASSWD: /usr/bin/systemctl stop habits
```
