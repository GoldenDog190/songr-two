# Lab: 13 - Related Resources and Integration Testing

## Setup
* Continue working in the same repository as your previous two labs.

## Feature Tasks
* Create a Song model.
* A Song has a title, a length (in seconds), a trackNumber, and the album on which that song appears.
* Ensure that the relationship between Albums and Songs is appropriately set up.
* A user should be able to see information about all the songs on the site.
* A user should be able to view a page with data about one particular album.
* A user should be able to add songs to an album.
* A user should be able to see the songs that belong to an album when looking at that album.

## Testing
* Write integration tests for your hello world routes.
* Make sure your server fails gracefully. The server shouldn’t crash and the database shouldn’t be corrupted in any way if a user attempts to read or manipulate information that doesn’t exist.
* The command to run this app: ./gradlew run