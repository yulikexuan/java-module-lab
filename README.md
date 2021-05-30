# Java Module Commands

## All Modules in ONE 

> NOTE: THERE IS NO COMMA BETWEEN MODULE NAMES

``` 
javac -d {output-dir} --module-source-path {src-root-dir} -m {module-name-1},{module-name-2},... 
``` 

``` 
javac -d target/classes --module-source-path src/mian/java -m com.yulikexuan.web 
```

``` 
javac -d target/classes --module-source-path src/main/java -m com.yulikexuan.domain
``` 

> java -p -m === java --module-path --module



## Single Module 

> javac -d {output-dir} {all source files, including module-info.java}

``` 
    javac -d target/classes src/main/java/module-info.java  \ 
            src/main/java/com/yulikexuan/domain/greeter/Main.java
```

``` 
    java -p target/classes -m com.yulikexuan.domain/com.yulikexuan.domain.greeter.Main
```


# OVERVIEW

## Where does this module-info.java live?

- The root of the source tree that comprises the module we're describing
- Completely outside of the package hierarchy
- Other source files inside the module containing classed or interfaces must 
  always be part of a package
- You cannot have classes in the default package, that is, without a package 
  declaratio at the top inside of a module

> NOTE: By default,  a module strongly encapsulates every package that is inside of it


## Module naming convention

- Separate namespace: One or more Java identifiers separated by '.'
    - Module names live in a completely separate namespace from any other 
      identifiers and names in Java
    - This means there will never be a class between clash names and module 
      names or package names and module names because these all inhabit their 
      own namespace 
    - A module name can be a simple, valid Java identifier
    - A module name can cnsist of multiple java identifiers separated by a dot, 
      much  like a package name 
    - Package names and module names live in completely separate namespace so 
      they can overlap if you want to 


## Good practices for nameing modules

- Avoid terminal digits in module names
- Root package as module name
    - Choose the module name to be the root package or the longest common prefix 
      of all the packages that are inside of the module, for example, ``` com.pluralsight ```


## Compile ``` module-info.java ``` to ``` module-info.class ```

- This means that any information that we define for our module carries over 
  from the source code, so the compile time environment, to the runtime 
  environment, means that the JVM wil also have knowledge of our module and the 
  name of the module and possibly more info that we will define later inside of 
  the module declaration   


## Package the compilation output into a JAR file 

- You can give the JAR file any namne you want, because in the end what matters 
  is the name for the module that we defined inside of the module declaration 
- A JAR file that contains a top-level module-info.class is called a modular 
  JAR file
- A modular JAR file behaves differently than a regular JAR file


# Selectively Expose Code from a Module

## Dependencies between Modules

- The ``` com.yulikexuan.domain ``` module

    ``` 
        module com.yulikexuan.domain {
            exports com.yulikexuan.domain.model;
        }
    ```

- ``` exports ``` should be always followed by a package name

- The ``` com.yulikexuan.web ``` module depends on ``` com.yulikexuan.domain ``` module

    ``` 
        module com.yulikexuan.web {
            requires com.yulikexuan.domain;
        }
    ```

- ``` requires ``` should always be followed by a module name

> Cyclic Dependencies is definitely NOT ALLOWED


# Open modules & packages

## Open package for runtime reflective access

- Reflective Access

    ``` 
    module com.yulikexuan.domain {
        exports com.yulikexuan.domain.model;
        exports com.yulikexuan.domain.service.api;
        opens com.yulikexuan.domain.service.api.impl;
    }
    
    ``` 
    Class.forName("com.yulikexuan.domain.service.api.impl.GreetingServiceImpl").newInstance();
    ```

- Reflective change access level of a field of domain module

    ``` 
    module com.yulikexuan.domain {
        exports com.yulikexuan.domain.model;
        exports com.yulikexuan.domain.service.api;
        opens com.yulikexuan.domain.model;
        opens com.yulikexuan.domain.service.api.impl;
    }
    ```
    
    ``` 
    Class.forName("com.yulikexuan.domain.model.Greeter")
            .getDeclaredField("secret")
            .setAccessible(true);
    ```


## Open Modules for reflection

- Opoen modules can be a useful default when working with frameworks that expect
  unfettered reflective access to encapsulated classes, when using spring 
  framework or hibernate

> It's better to have compile time encapsulation only than no encapsulation at 
> all

    ``` 
    open module com.yulikexuan.domain {
        exports com.yulikexuan.domain.model;
        exports com.yulikexuan.domain.service.api;
    }
    ```

