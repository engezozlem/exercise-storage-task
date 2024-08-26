# EGYM Coding Task - Exercise Storage

**Please do not share this project or its solution with people outside EGYM GmbH!**

### Introduction

Member ranking is a highly anticipated feature by our clients. EGYM needs Exercise Storage backend
service to store exercises and provide user ranking.

Fields of exercise object:

* `userId` - Integer representation of the user id.
* `type` - One of `RUNNING`, `SWIMMING`, `STRENGTH_TRAINING`, `CIRCUIT_TRAINING`.
* `description` - Non-blank description of the exercises.
* `startTime` - Past datetime in the ISO-8601 calendar system format with UTC offset.
* `duration` - Duration in seconds.
* `calories` - Number of burned calories (may not be present).

The list of requirements:

1. The clients of the service shall be able to save and update exercises in JSON format. Not all  
   fields can be updated, only `description`, `startTime`, `duration`, `calories`.

   It should be checked that there is no other exercise already present for the user id, in the
   period (start + duration) where the new exercise will take place.

   Validate client input and use an appropriate HTTP status code if the input is invalid.

2. The clients of the service can request ranking for a list of users. Return a JSON containing a
   sorted object list with users and their ranking points. Order them according to the points in
   descending order. When two users have the same amount of points, the user with the latest done
   exercise is ranked first in the list.

   Points from exercises that started or finished in the past 28 days count toward the user's
   ranking. Number of points of an exercise is equal to the burned calories, or the duration of
   exercise multiplied to the coefficient from the exercise's type if the `calories` is empty. The
   coefficients:

    * `RUNNING` is `1.04`
    * `SWIMMING` is `1.12`
    * `STRENGTH_TRAINING` is `1.23`
    * `CIRCUIT_TRAINING` is `1.34`

Note: the past 28 days are the days between the beginning of the day that is 28 days in past and the
beginning of today in UTC timezone. Let's assume that today is 24 June 2021 at 2PM, then the range
will be 27 May 2021 00:00 UTC until 24 June 2021 00:00 UTC.

### Important information

- We provide you with a base application, you are free to extend it with additional libraries,
  frameworks, application server, etc.
- The boilerplate includes PostgreSQL however feel free to replace it with DB of your choice, it can
  be a simple database like H2, SQLite, HSQLDB, etc. or more advanced like PostgreSQL, MySQL,
  MariaDB, etc.
- We will run tests against the REST endpoints. Feel free to change controllers as you want but
  please do not change the server port and the url paths.

### What do we value in a solution:

1. Is your solution following the requirements and production ready?
2. Is your code easy to read?
3. Have you been thoughtful about performance?
4. Did you cover your solution with tests?

Best of luck and have fun coding!

EGYM Team