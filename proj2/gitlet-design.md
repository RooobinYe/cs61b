# Gitlet Design Document

**Name**: RobinYe

This Gitlet Design Document is referred
by [Capers Design Document](https://sp21.datastructur.es/materials/proj/proj2/capers-example).

## Classes and Data Structures

### Main Class

This is the entry point to our program. It takes in arguments from the command line and based on the command (the first
element of the `args` array) calls the corresponding command in `Repository` which will actually execute the logic of
the command. It also validates the arguments based on the command to ensure that enough arguments were passed in.

#### Fields

This class has no fields and hence no associated state: it simply validates arguments and defers the execution to the
`Repository` class.

### Repository Class

This is where the main logic of our program will live. This file will handle all of the actual gitlet commands by
reading/writing from/to the correct file, setting up persistence, and additional error checking.

It will also be responsible for setting up all persistence within gitlet. This includes creating the `.gitlet` folder as
well as the folder and file where we store all File objects and the corresponding infomation.

This class defers all `Commit` specific logic to the `Commit` class: for example, instead of having the `Repository`
class
handle `Commit` serialization and deserialization, we have the `Commit` class contain the logic for that.

#### Fields

1. `static final File CWD = new File(System.getProperty("user.dir"))`
2. `static final File CAPERS_FOLDER = Utils.join(CWD, ".gitlet")`

### Commit Class

#### Fields

1.

### Utils Class

## Algorithms

## Persistence

```
CWD
|----.gitlet
    |----xxx
    |----xxx
        |----xxx
```