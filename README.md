# UDF-Flink-JWrinker
This contains repo contains sample UDF command which checks for 90 percent match

# Generate JAR 

1. Execute the below command to generate the JAR File which we need to upload using CLI.


```
mvn clean package
}
```

Note : You can write your custom logic on public double eval() function based on your usecase by removing the existing code


# Register the JAR File

 To register the jar file on CC organization first login into the confluent CLI and use the below command:

```
confluent flink artifact create 
your-artifact-name
--artifact-file path-to-jar-file.JAR
```
If the command gets executed successfully it will generate pluginid and versionid which should look something similar below.

+----------------+----------------+
| Name           | artifact-name    |
| Plugin ID      | ccp-xxxxxxxxxxx  |
| Version ID     | ver-xxxxxxxxxxx  |
| Content Format | JAR              |
+----------------+----------------+


Use the below command to list all the uploaded artifacts
```
confluent flink artifact list
}
```


# Using EDF on FlinkSQL

After uploading the jar using CLI next go to the flinkSQL editor to register the UDF on your particular flink workspace by using the below command


```
CREATE FUNCTION UDF_NAME 
AS 'io.confluent.flink.table.modules.remoteudf.TShirtSizingIsSmaller' 
USING JAR 'confluent-artifact://pluginid/versionid';
```

NOTE : Replace the class with your actual class that contains your eval function


Now since the UDF is successfully registered you can use the below command to list all the UDF Functions:

```
SHOW USER FUNCTIONS;
```

Here is the Sample command which uses UDF function that we have just created

```
select regionid, FUNCTION UDF_NAME(gender,"MAALE") from sample data
```

![image](https://github.com/Gokuldev-PS/UDF-Flink-JWrinker/assets/132561683/dc072c92-4e80-4c8f-bb43-10f4dcc85553)



