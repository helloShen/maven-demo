# maven-demo
To understand how maven works.
### 下载
从[【maven下载】](http://maven.apache.org/download.cgi#)下载最新的3.5.4包。解压到，
```
/usr/local/
```
得到
```
/usr/local/apache-maven-3.5.4
```
其中`bin`目录下的就是maven的应用程序。

### 环境变量
Linux环境下，打开`~/.bash_profile`和`~/zshrc`（因为我装了zsh），配置环境变量，
```
export MAVEN_HOME=/usr/local/apache-maven-3.5.4
export PATH=${MAVEN_HOME}/bin:${PATH}
export MAVEN_OPTS="-Xms256m -Xmx512m"
```

### 验证
```
$ mvn --version
```

输出如下，安装完成。
```
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T14:33:14-04:00)
Maven home: /usr/local/apache-maven-3.5.4
Java version: 1.8.0_73, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.4", arch: "x86_64", family: "mac"
```

### 和ant比较
maven的POM更系统化。就像DOM。

maven更死板，Super POM和Effective POM的设定很帅。

```
mvn help:effective-pom
```

maven死板是死板，但强在对话能力。多个用maven构建和部署的项目之间的协作变得很流畅。

### 生命周期
当一个阶段通过 Maven 命令调用时，例如 mvn compile，只有该阶段之前以及包括该阶段在内的所有阶段会被执行。

### Profile配置
Profile 在构建时修改 POM，并且为变量设置不同的目标环境（例如，在开发、测试和产品环境中的数据库服务器路径）。


### 我需要扩展我的项目，比如中间需要将某些组件编译后打包成一个jar文件作为库使用。

### Maven还有中央仓库一说
Maven很共产主义
<https://search.maven.org/#browse>

`<repositories>`标签可以用来自定义远程仓库。

### 什么是插件？
Maven 实际上是一个依赖插件执行的框架，每个任务实际上是由插件完成。
> mvn [plugin-name]:[goal-name]

比如，下面命令使用`maven-compiler-plugin` 的 `compile-goal` 编译
```
mvn compiler:compile
```

### 原型（archetype）插件
原型（archetype）插件可以帮我创建基本的文件夹，和一些简单的Java源文件和测试文件。

```
mvn archetype:generate
```
让我选模板，直接回车选择默认的`maven-archetype-quickstart`，
```
...
...
2216: remote -> us.fatehi:schemacrawler-archetype-plugin-dbconnector (-)
2217: remote -> us.fatehi:schemacrawler-archetype-plugin-lint (-)
2218: remote -> ws.osiris:osiris-archetype (Maven Archetype for Osiris)
2219: remote -> xyz.luan.generator:xyz-gae-generator (-)
2220: remote -> xyz.luan.generator:xyz-generator (-)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1230:
```
再选版本，选最新的，
```
Choose org.apache.maven.archetypes:maven-archetype-quickstart version:
1: 1.0-alpha-1
2: 1.0-alpha-2
3: 1.0-alpha-3
4: 1.0-alpha-4
5: 1.0
6: 1.1
7: 1.3
```
填配置信息，
```
[INFO] Parameter: groupId, Value: com.ciaoshen
[INFO] Parameter: artifactId, Value: maven-demo
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: com.ciaoshen.maven.demo
```
成功之后，生成项目根目录`maven-demo`，
```
maven-base
├── LICENSE
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── ciaoshen
    │               └── maven
    │                   └── demo
    │                       └── App.java
    └── test
        └── java
            └── com
                └── ciaoshen
                    └── maven
                        └── demo
                            └── AppTest.java
```

自动生成的`pom.xml`文件如下，
```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.ciaoshen</groupId>
  <artifactId>maven-demo</artifactId>
  <version>1.0-SNAPSHOT</version>

  <name>maven-demo</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.7.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.20.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

### 添加一个简单的计算器
计算器只有一个源码文件`Calculator.java`和一个单元测试文件`CalculatorTest.java`：
```
.
├── LICENSE
├── README.md
├── pom.xml
├── src
    ├── main
    │   └── java
    │       └── com
    │           └── ciaoshen
    │               └── maven
    │                   └── demo
    │                       └── Calculator.java
    └── test
        └── java
            └── com
                └── ciaoshen
                    └── maven
                        └── demo
                            └── CalculatorTest.java
```

* `Calculator.java`是一个最简单的只能做加减乘除的计算器。`main()`函数里运行一个简单的测试。
* `CalculatorTest.java`是对应的单元测试源码。

比如,`Calculator.java`里有`add()`函数，
```java
public static int add(int a, int b) {
    return a + b;
}
```
`CalculatorTest.java`里就有`testAdd()`函数，
```java
@Test
public void testAdd()
{
    int a = random();
    int b = random();
    assertEquals(calc.add(a, b), a + b);
}
```
但maven只要用户写好单元测试，不需要用户自己写`Runner`。

#### 直接运行测试
只要输入命令行，maven自己编译目标类，测试代码，执行测试，
```
mvn test
```

测试结束后，目录结构如下，
```
.
├── LICENSE
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── ciaoshen
│   │               └── maven
│   │                   └── demo
│   │                       └── Calculator.java
│   └── test
│       └── java
│           └── com
│               └── ciaoshen
│                   └── maven
│                       └── demo
│                           └── CalculatorTest.java
└── target
    ├── classes
    │   └── com
    │       └── ciaoshen
    │           └── maven
    │               └── demo
    │                   └── Calculator.class
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── surefire-reports
    │   ├── TEST-com.ciaoshen.maven.demo.CalculatorTest.xml
    │   └── com.ciaoshen.maven.demo.CalculatorTest.txt
    └── test-classes
        └── com
            └── ciaoshen
                └── maven
                    └── demo
                        └── CalculatorTest.class
```

其中`maven-status/maven-compiler-plugin`目录下多了几个`.lst`文件，列出了编译后所有`.class`类文件的绝对路径，比如`createdFiles.lst`里，
```
com/ciaoshen/maven/demo/Calculator.class
```
`surefile-reports/`文件夹下是测试的日志文件。


### maven可以部署网站，我甚至可以把git部署github博客包括进去
先创建leetcode项目
再写具体题目的算法
再写博客
再更新github

### maven是构建系统的EJB2
