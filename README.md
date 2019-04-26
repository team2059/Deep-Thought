# Deep Thought

Team 2059's 2019 Robot Code.

## Building

- [Java 11](https://jdk.java.net/java-se-ri/11)
- [Git Bash](https://git-scm.com/downloads)

```sh
git clone --recursive https://github.com/team2059/2019-bot; dir=$(basename $_ .git) && $dir/gradlew -p $dir jar
```


## Controls

List of controls used to drive the robot.

#### Driver Main Joystick (USB 0)

| Action      | Button            |
|-------------|:-----------------:|
| Drive       | Joystick Axes     |
| Intake      | 1                 |
| Eject       | 2                 |
| Jack Wheels | 6 + Joystick Axes |




#### Driver Secondary Joystick (USB 2)

| Action            | Button              |
|-------------------|:-------------------:|
| Cargo Level 1     | 1                   |
| Cargo Level 2     | 2                   |
| Cargo Level 3     | 3                   |
| Hatch Level 1     | 4                   |
| Hatch Level 2     | 5                   |
| Hatch Level 3     | 6                   |
| Hatch Pickup      | 7                   |
| Cargo Pickup      | 8                   |
| Cargo Ship        | 9                   |
| Climb Preposition | 10 + Level Selector |
| Climb             | 11 + Level Selector |
| Jack Up           | 12                  |



## Electronics

List of electronics used by the robot.

#### CAN

| Motor               | ID  |
|---------------------|:---:|
| Right Drive Motor 1 | 1   |
| Right Drive Motor 2 | 2   |
| Right Drive Motor 3 | 3   |
| Left Drive Motor 1  | 4   |
| Left Drive Motor 2  | 5   |
| Left Drive Motor 3  | 6   |
| Collector           | 7   |
| Wrist               | 8   |
| Jack                | 9   |
| Arm                 | 10  |
| Jack Wheels         | 11  |
| Hatch               | 12  |
| Elevator            | 13  |
| Carriage            | 14  |

#### DIO

| Sensor                | Port |
|-----------------------|:----:|
| Carriage Bottom Limit | 4    |
| Elevator Top Limit    | 5    |
| Carriage Top Limit    | 6    |
| Elevator Bottom Limit | 7    |
| Jack Encoder          | 8, 9 |
| Jack Top Limit        | 23   |


#### AI

| Sensor    | Port |
|-----------|:----:|
| Wrist Pot | 0    |
| Arm Pot   | 1    |


#### USB

| Sensor   | Port |
|----------|:----:|
| Camera 1 | 0    |
| Camera 2 | 1    |
