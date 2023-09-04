## Client Base Application

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/eb5c4e17ac584559aaee838f0b0f8ea5)](https://app.codacy.com/gh/AndreiBudevich/clientbase/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

-----------------------------
# Требования
Спроектировать простую БД, обеспечивающую хранение информации о клиентах и их контактой информации.
Каждый клиент характеризуется именем.
Каждому клиенту в соответствие может быть поставлена информация о его контактах: 0 и более телефонных номеров, 0 и более адресов электронной почты.
Разработать в Spring Framework API, обеспечивающее работу с данной БД.
API должно обеспечивать следующие функции:
1) Добавление нового клиента
2) Добавление нового контакта клиента (телефон или email)
3) Получение списка клиентов
4) Получение информации по заданному клиенту (по id)
5) Получение списка контактов заданного клиента
6) Получение списка контактов заданного типа заданного клиента

-------------------------------------------------------------
- Stack: [JDK 17](http://jdk.java.net/17/), Spring Boot 3.0.1, Lombok, Postgres, Swagger
-----------------------------------------------------

[REST API documentation](http://localhost:8095/swagger-ui/index.html)  
