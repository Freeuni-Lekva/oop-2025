## Servlets

1. JSP - შექმენით ფორმა, რომლითაც შევძლებთ სტუდენტების დამატებას.
2. შექმენით შესაბამისი სერვლეტები, რომლებიც დაამუშავებენ კლიენტის მოთხოვნებს. დაიცავით thread-safety.

--------------------
Tomcat plugin
```xml

<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <port>8080</port>
        <path>/</path>
    </configuration>
</plugin>
```