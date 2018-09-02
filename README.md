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
