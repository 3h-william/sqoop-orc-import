### Sqoop with orc file

### Version : sqoop1.4.5 (CDH540)

### Description
在Sqoop import的方法中，增加生成ORC File格式的命令.


### Build
源码取自于 [Sqoop Documentation](http://archive-primary.cloudera.com/cdh5/cdh/5/sqoop-1.4.5-cdh5.4.0/)   
[src下载](http://archive-primary.cloudera.com/cdh5/cdh/5/sqoop-1.4.5-cdh5.4.0-src.tar.gz)  
[bin下载](http://archive-primary.cloudera.com/cdh5/cdh/5/sqoop-1.4.5-cdh5.4.0.tar.gz)  

使用ant build

### Usage
在import命令中，增加:  
```
--as-orcdatafile
```

### Examples
```
sqoop import -D hadoop.job.history.user.location=none --connect 'jdbc:sqlserver://...' --table {talbeName} --columns ... --target-dir hdfs:// -m 20 --outdir /... --as-orcdatafile --driver com.microsoft.sqlserver.jdbc.SQLServerDriver
```