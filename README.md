# SpringBoot Web Project Template
## Developer information
##### Maintainer: LetCafe
##### Email: letcafe@outlook.com
## Developing environment
+ Web Container：tomcat9
+ JDK：1.8
+ DEV IDE：Intellij IDEA
## Framework support
>Spring framework support:https://projects.spring.io/spring-framework/  
>SpringFox Swagger support:https://springfox.github.io/springfox/  
>Hibernate support:http://hibernate.org/  
>Gradle support:https://gradle.org/

## Deploy notice
+ Visit url：http://localhost:10086/SpringWebWithBoot/api/index.html
+ Support: Intellij IDEA + Eclipse

## 生成HTML，PDF接口文档
在src/docs/swagger中，存入目标的json文件或者yaml文件，本例中以target.json为例（json文件为swagger导出的/v2/api-docs的文本值）

在terminal中执行该命令

    gradlew asciidoctor
    
可在build/asciidoc/html5/index.html中得到最新生成的文档，PDF直接用工具转换即可（该独立HTML可直接导出）。

## 开发日志
### 2018-03-31 
1. New：使用SpringBoot替代SpringMVC

### 2018-04-2 
1. New：Spring email支持包括plain文本以及带附件的邮件

### 2018-04-05 
1. New：Redis集成
2. New：ActiveMQ集成
3. New：Email集成
4. New：Jpa集成
5. New：Swagger2集成
6. New：Jmx集成
7. New：log4j2集成

### 2018-04-25 
1. New：MyBatis集成

### 2018-07-03
1. New: WebSocket集成
2. New: SockJS集成
3. New: STOMP集成

### 2018-07-25
1. New: 支持阿里支付宝交易

### 2018-09-04
1. New: 新增API接口HTML，PDF文档支持导出
1. New: 新增.gitignore

