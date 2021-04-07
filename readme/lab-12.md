# Lab: 12 - Spring and REST

## Setup
* Continue working in the same songr webapp you generated for the previous lab. Ensure that you have all of these dependencies in your build.gradle. (Note that when you add the dependencies on postgres and JPA, your app will stop working until you have the configuration in application.properties to access your Postgres database.)
 - dependencies {
	compile 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation('org.springframework.boot:spring-boot-starter-thymeleaf')
	implementation('org.springframework.boot:spring-boot-starter-web')
	runtimeOnly('org.postgresql:postgresql')
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}

## Feature Tasks
* Update your Album model so that it can be saved in a database.
  - An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.
* A user should be able to see information about all the albums on the site.
* A user should be able to add albums to the site.
* The command to run this app: ./gradlew run
