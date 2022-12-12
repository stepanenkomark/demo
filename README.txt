Demo project; has 3 endpoints:

* Get /userinfo/{user_id} - returns top N user's results on all levels;
* Get /levelinfo/{level_id} - returns top N level's results for all users;
* Put /setinfo - sets user's result on a level; accepts the following format of body:
    {"user_id":1,"level_id":1,"result":23}

To build project, execute command: gradlew build

To run project, execute command: gradlew bootRun

