# tuqi-all-boot
毕业设计项目

### Spring-boot 集成thymeleaf的过程（坑）
  1. 引入包依赖
 
  ```
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
	  </dependency>
  ``` 
    
    原来同样的包依赖spring-boot-starter-thymeleaf可以直接忽略掉
  2.添加配置项（application.properties）
 ```
    //这些注释部分是默认的配置，可以进行自定义修改
    #spring.thymeleaf.prefix=classpath:/templates/  
    #spring.thymeleaf.suffix=.html  
    #spring.thymeleaf.mode=HTML5  
    #spring.thymeleaf.encoding=UTF-8  
    #;charset=<encoding> is added  
    #spring.thymeleaf.content-type=text/html  
    #set to false for hot refresh  
    //清楚页面的缓存，即修改之后可以直接在浏览器中刷新查看
    spring.thymeleaf.cache=false  
  ```
  3.可以说是thymeleaf是已经在spring-boot集成了，只用添加jar包就能够完美使用
  
  4.在resource中添加一个“templates”文件夹，存放页面文件，默认是读取html文件，thymeleaf是默认解析HTML5模板的
  
  5.正常写一个@Controller，然后就能正常访问页面了
  
  一般遇到的坑，很多文章已经写过了，写一个自己遇到的：
    我在pom文件夹中添加了对resource的资源文件扫描，但是没有添加模板的扫描
    <include>**/*.html</include>这一行本来是没有的，很尴尬
   ```
    <build>
		<resources>
			<resource>
				<directory>src/main/resources</directory>
				<includes>
					<include>**/*.properties</include>
					<include>**/*.config</include>
					<include>**/*.txt</include>
					<include>**/*.xml</include>
					<include>**/*.html</include>
				</includes>
			</resource>
		</resources>
	</build>
  ```
   
