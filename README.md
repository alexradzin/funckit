# FuncKit

Collection of classes that makes functional programming easier in Java prior to version 8.

## Introduction

Functional programming is a very effective methodology that helps to create more readable code 
built from better reusable code fragments. Java supports functional programming since version 8.
Although Java 8 was released on June, 2014 there are still poor people that have to write 
code compatible with previous versions. 

It is not a nightmare however. There are several frameworks that bring functional programming to 
Java 7 and earlier:
* [Guava](https://github.com/google/guava)
* [Apache collections framework (v3 and v4)](https://commons.apache.org/proper/commons-collections/)
* [Apache commons functor (not yet officially released project)](https://commons.apache.org/proper/commons-functor/examples.html)
* [Functional java](http://www.functionaljava.org/)


These libraries help us to create functional code but still require to implement again and again 
the same (often trivial) code fragments. 

For example, let's say I want to filter given strings collections so that only strings that starts with `"a"` remain.
Using Guava I have to define `startsWith` predicate like the following:


```java
Iterable<String> filtered = FluentIterable.from((Set<String>) page).filter(new Predicate<String>() {
	@Override
	public boolean apply(String input) {
		return input.startsWith("a");
	}
});
```

Not bad, but I'd like to avoid writing such trivial functions every time I need them. I'd prefer to have collection of
ready to use functions and predicates that hopefully cover more than 50% of my needs. I'd like to be able to re-write the
code above as following:  

```java
Iterable<String> filtered = FluentIterable.from((Set<String>) page).filter(startsWith("a"));
```

(obviously I have to add static import to get access to reusable function `startsWith()`.)

So, this is exactly what this library does. The library implements general functions and predicates that can be used as a building blocks 
within several functional frameworks. Right now the FuncKit supports 
* Guava
* Apache collections v3
* Apache collections v4

   
## Examples

```java
// Get recursively tree of existing properties files older than 1 hour starting from current directory and load their content  into single Properties object  
Properties props = new Properties();
FluentIterable
		.from(asList(tree(matchesWildcard("*.properties")).apply(new File("."))))
		.filter(and(isFile, exists)).filter(checkField(lastModified, gt(3600000L)))
		.transform(fis)
		.transform(load(props));
```
		
		
## Usage

FuncKit is not deployed to any public maven repository yet. But once this is done you will have to include 2 dependencies in order to use it.


First you need dependency to FuncKit core that contains most of the code. 

```xml
<dependency>
	<groupId>org.funckit</groupId>
	<artifactId>funckit-core</artifactId>
	<version>0.1-SNAPSHOT</version>
</dependency>
```
 
  
Second you have to include *one* of the following dependencies according to the functional framework you are using:
* `funckit-guava-base`
* `funckit-commons-collections-base`
* `funckit-commons-collections4-base`

e.g:
	
```xml
<dependency>
	<groupId>org.funckit</groupId>
	<artifactId></artifactId>
	<version>0.1-SNAPSHOT</version>
</dependency>
```
		
At the moment the library cannot be used with 2 functional frameworks in the same project. 
This limitation however will be fixed before the first release.

Curious reader that wants to know the reason for this limitation should read chapter "Design". 


## Main features
TBD

## Design  
TBD