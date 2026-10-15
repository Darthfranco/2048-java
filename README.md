# Java Terminal Games

Terminal games built while learning Java. No AI was used to write the game code.

## Getting started

Install JDK 17 or newer, then download the Java files or clone this repository:

```sh
git clone https://github.com/Darthfranco/java-terminal-games.git
cd java-terminal-games
```

Run the commands below in the folder containing the Java files. Both games use only Java's standard library. Use a terminal that supports ANSI escape codes for screen clearing and colors. Press Ctrl+C to quit either game.

## 2048

Slide and combine matching tiles on a 4×4 board.

Compile `TwentyFourtyEight.java`, then run the game:

```sh
javac TwentyFourtyEight.java
java TwentyFourtyEight
```

Type a lowercase direction and press Enter:

| Key | Direction |
| --- | --- |
| `u` | Up |
| `d` | Down |
| `l` | Left |
| `r` | Right |

## Wordle

Guess a randomly chosen five-letter word. Keep guessing until you find it; the game counts how many attempts you take.

Compile `wordle.java`, then run the game (the class name is lowercase):

```sh
javac wordle.java
java wordle
```

Type a five-letter word and press Enter. After each guess:

- Green letters are in the correct position.
- Yellow letters appear in the word but are in a different position.
- Uncolored letters do not appear in the word.
