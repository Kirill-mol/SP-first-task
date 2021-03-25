{% capture repoVersion %}2.0.3{% endcapture %}
# ISIN-email-lib.

## Библиотека отправки email сообщений

### Актуальные версии

- **В maven репозитории:** {{ repoVersion }}
- **Локально:** 2.0.4

### Стек

#### Java

- Spring Boot (MVC, Data)
- Isin core lib
- Lombok

### Подключение библиотеки

#### Maven

Требуется добавить репозиторий

```xml
<repository>
    <id>repsy</id>
    <name>My Private Maven Repository on Repsy</name>
    <url>https://repo.repsy.io/mvn/ksergey/isin</url>
</repository>
```
А затем подключать саму библиотеку
```xml
<dependency>
    <groupId>ru.isin</groupId>
    <artifactId>spring-boot-starter-isin-email-lib</artifactId>
    <version>${spring-boot-starter-isin-email-lib.version}</version>
</dependency>
```
