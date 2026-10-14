# 2048 Java

A terminal-based 2048 game written in Java. Slide and combine matching tiles on a 4×4 board.

## Play

Install Java 17 or newer, then download `2048-java.jar` from the [latest release](https://github.com/Darthfranco/2048-java/releases/latest).

Open a terminal in the download folder and run:

```sh
java -jar 2048-java.jar
```

Type a lowercase direction and press Enter:

| Key | Direction |
| --- | --- |
| `u` | Up |
| `d` | Down |
| `l` | Left |
| `r` | Right |

Press Ctrl+C to quit. Use a terminal that supports ANSI escape codes for screen clearing.

## Run from source

With JDK 17 or newer installed, run this from the repository folder:

```sh
java TwentyFourtyEight.java
```

## Build the JAR

From the repository folder, using JDK 17 or newer:

```sh
javac --release 17 -d build TwentyFourtyEight.java
jar --create --file 2048-java.jar --main-class TwentyFourtyEight -C build .
java -jar 2048-java.jar
```

The game has no third-party dependencies. The original game source is in `TwentyFourtyEight.java`; compiled downloads are available under [Releases](https://github.com/Darthfranco/2048-java/releases).
