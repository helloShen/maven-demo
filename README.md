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


### maven可以部署网站，我甚至可以把git部署github博客包括进去
先创建leetcode项目
再写具体题目的算法
再写博客
再更新github
