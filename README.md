# Williams Sonoma Code Challenge App
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input

## Tech Stack
| Technology | Version | Purpose |
| ------ | ------ | ------ |
| Java | 15 | Programming Language |
| SpringBoot | 2.4.3 | Application Framework |
| Embedded Tomcat Server | 9 | To Deploy Application |
| Gradle |  6.8.3 | Build Tool |
| Swagger OpenApi | 3.0 | API Dcoumentaion and Testing |
| Junit, Mockito | 5 | Unit Test Cases |
| Log4j | 2.1.3 | To maintain Logs |
| yaml |  | To write application Properties info |


## Rest Apis Info
here we used  post api which takes array of integers and returns MinRange of Zipcodes...
follwoing are the request and response models
##### Request:
[[94133,94133],[94200,94299],[94600,94699]]
##### Response:
[[94133,94133],[94200,94299],[94600,94699]]

##### swagger url:
http://localhost:8080/swagger-ui.html

![swagger](https://user-images.githubusercontent.com/80912820/111666681-f142a480-87e1-11eb-8b19-f31a359241db.JPG)



```sh
Swagger Api Request
```
![swagger-request](https://user-images.githubusercontent.com/80912820/111667591-de7c9f80-87e2-11eb-9c95-14e73375cc64.JPG)

```sh
Swagger Api Response
```
![swagger-response](https://user-images.githubusercontent.com/80912820/111667360-a07f7b80-87e2-11eb-84f1-0131678d19d9.JPG)


```sh
Test Cases Results
```
![test-cases](https://user-images.githubusercontent.com/80912820/111666972-3c5cb780-87e2-11eb-8ab0-40c4f1473150.JPG)


```sh
Code Coverage
```
![code-coverage](https://user-images.githubusercontent.com/80912820/111667216-7d54cc00-87e2-11eb-8085-37042c8bc25e.JPG)

