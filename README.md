# 简要说明

本项目是为了练习智能测试单元框架Evosuite设计的，项目中已经做好了全部的配置，可以对照下面的内容在项目中学习


## 引入框架
在要使用的module的pom文件中引入如下几部分


### properties

    <properties>
        <evosuiteVersion>1.0.6</evosuiteVersion>
    </properties>



### dependencies

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.evosuite</groupId>
            <artifactId>evosuite-standalone-runtime</artifactId>
            <version>${evosuiteVersion}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.surefire</groupId>
            <artifactId>surefire-junit4</artifactId>
            <version>2.19</version>
        </dependency>
         <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-report-plugin</artifactId>
            <version>3.0.0-M3</version>
        </dependency>
    </dependencies>


### build下的plugins中

            
    <build>
        <plugins>
            <plugin>
                <groupId>org.evosuite.plugins</groupId>
                <artifactId>evosuite-maven-plugin</artifactId>
                <version>1.0.6</version>
                <executions><execution>
                    <goals> <goal> prepare </goal> </goals>
                    <phase> process-test-classes </phase>
                </execution></executions>
            </plugin>

            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>cobertura-maven-plugin</artifactId>
                <version>2.7</version>
                <configuration>
                    <instrumentation>
                        <ignores>
                            <ignore>com.example.boringcode.*</ignore>
                        </ignores>
                        <excludes>
                            <exclude>com/example/dullcode/**/*.class</exclude>
                            <exclude>com/example/**/*Test.class</exclude>
                        </excludes>
                    </instrumentation>
                    <check/>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>clean</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <!-- mvn test生成xml txt测试报告（命令行不带surefire-report:report时） -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
				<version>2.19</version>
                <configuration>
					<skipTests>false</skipTests>
                    <testFailureIgnore>true</testFailureIgnore> <!-- //////////// -->
					
                    <includes>
                        <include>**/*Test.java</include>    <!-- //////////// -->
                    </includes>
                    <excludes>
                        <!-- -->
                    </excludes>
                </configuration>
            </plugin>

            <!-- 用mvn ant生成格式更友好的report -->
            <plugin>
                <groupId>org.jvnet.maven-antrun-extended-plugin</groupId>
                <artifactId>maven-antrun-extended-plugin</artifactId>   <!-- //////////// -->
                <version>1.43</version>
                <executions>
                    <execution>
                        <id>test-reports</id>
                        <phase>test</phase> <!-- //////////// -->
                        <configuration>
                            <tasks>
                                <junitreport todir="${basedir}/target/surefire-reports">
                                    <fileset dir="${basedir}/target/surefire-reports">
                                        <include name="**/*.xml" />
                                    </fileset>
                                    <report format="frames" todir="${basedir}/target/surefire-reports" /> <!-- //////////// -->
                                </junitreport>
                            </tasks>
                        </configuration>
                        <goals>
                            <goal>run</goal>
                        </goals>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.apache.ant</groupId>
                        <artifactId>ant-junit</artifactId>
                        <version>1.8.0</version>
                    </dependency>
                    <dependency>
                        <groupId>org.apache.ant</groupId>
                        <artifactId>ant-trax</artifactId>
                        <version>1.8.0</version>
                    </dependency>
                </dependencies>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
            </plugin>
        </plugins>
    </build>


### project

    <project>
        <reporting>
            <plugins>
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>cobertura-maven-plugin</artifactId>
                    <version>2.7</version>
                </plugin>
            </plugins>
        </reporting>
    </project>


## 快速使用


### AI生产并优化单元测试脚本
打开IDEA下部的termial，进入当前配置好的module，输入如下命令等待

>    mvn evosuite:generate evosuite:export test

等结束后，你可以在对应的module下的test路径下看到java里面的测试case

### 进行单元测试

打开IDEA下部的termial，进入当前配置好的module，输入如下命令等待

>    mvn test

等待结束后，进入对应module下的target里面的surefire-reports，会看到index.html测试报告


然后继续输入:

>     mvn cobertura:cobertura
    
等待完成后，你可以在对应module下的target里面的sit里面看到cobertura的文件夹，里面的index就是本次AIDT单元测试脚本的代码覆盖度







