# JUnit 5 with Sbt

This is a sample project to run Junit 5 test with the Sbt build tool.

Things works well for a classic source structure, when launching :
 
```
sbt test
```
 
But tests under __it__ directory couldn't be launched with the following command :

```
sbt it:test
```

The project is correctly configured in IntelliJ and the integration test runs successfully.