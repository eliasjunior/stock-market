# Stock market

Rest API based on the SOLID principals

## Getting Started

### Prerequisites

* Java 11

* Maven Version 3.6.3

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/eliasjunior/stock-market.git
   ```
2. Install Maven dependencies packages, run the command bellow.
   ```sh
   mvn clean package
   ```

### Usages
3. run the backend:
```bash
mvn spring-boot:run
```

### UI

4. go to the ui folder.

```sh
cd stock-market-ui
```

5. Install npm dependencies.   
```sh
npm install 
```
6. running the app.
```sh
npm install 
```

## File Structure

The goal of the file structure here is to be easy to navigate

<a href="">
   <img src="img/file-structure.png.png" alt="Logo"  width="506px" height="895px">
</a>

I've separated by "useCases" data, domain, web and UI

We could make the folder as independent modules, this way when the app evolves we would keep the separation of concern,

In the real world this would be an architecture discussion .

## Technical Overview

### CI

There is a basic CI with Git Actions that build, and test the project once changes pushed to master.

## External libs

I opted to not use very handy tools like [lombok](https://projectlombok.org/features/all) or [Mapstruct](https://mapstruct.org/),
I wanted to avoid libs for this project only, in the real world I'd discuss with the team the pros and cons of each external library.

### UI
I used new Javascrit features [ES6/ES7](https://developer.mozilla.org/en-US/docs/Web/JavaScript) React with react-create-app to speed up the development and yet keep the code clean and easy to read.

Used bootstrap for css also to speed up the development.

## Observation

There is only integration tests see (test/http-client) you can use postman, I've used a IntelliJ built-in plugin.

The design of the code is to make easy to test, there are just a few units tests for demonstration.

However, in the real world I like to base my development in [Martin Fowler pyramid](https://martinfowler.com/articles/practical-test-pyramid.html).

There are some comments in the code on how and why I've chosen some implementations

Happy Reviewing :)



