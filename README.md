# OOP - GwentStone

*Alexandru Mihai 323CA*

-------------------------------------------------------
# Introduction

Gwent and Hearthstone are popular games that are trying to mimic and extend card board games
using a graphic interface that allow players to place special cards and 
fight against an enemy.

-------------------------------------------------------

# Card Implementation

cards were divided into 3 categories depending on their effects:
* **Minion** - cards that are placed on board that could either attack or use special ability
* **Environment card** - spells that affect the minions placed on board
* **Hero** - The *commander* of the minions that can use a special ability
and who's death marks the end of the game

The card class was defined as an abstract class considering that each card has
it's own special ability and different card types require different output format.

The class card builder card allow the conversion from stardand input to usable information
in order to assigning each card it's special role and output formatter.

------------------------------------------------------

# Action Implementation

Action was designed as an abstract class that incorporates different functionalities:
* **Debug commands** - that display a certain piece of information at any given time
* **Active actions** - that apply an effect on the board (such as using a spell, placing a card, etc.)
* **Statistics commands** - display the total games played or won by a certain player

The action class also takes into consideration the possible error that could appear,
using the ErrorHandler class to check issues that might appear (such as a player that
cannot place a card due to lack of mana, an incorrect attack action etc.).

-------------------------------------------------------

# server Implementation

The server class represents the entry point of the implementation that keeps track
of the statistics and ensure the flow of games and adding the output to the given output point.

In addition, the server receives the input formatting the decks of the two players and initializing
the games and starting the effective game.

The game class contains all the given information about a certain game: game start input,
the action required in order along. At the beginning of each game a board is initialized
which assigns each player a deck, a hand of cards (empty at the beginning), mana and 4 lanes
that can be used to place Minions and cast Environment cards.

After each player action the board is cleared of defeated minions (those whose health is bellow 0)
and after each player turn all his cards are unfrozen and mark as reusable next round.

-------------------------------------------------------

# helpers Implementation

The helpers package include utility classes that include static fields and methods used to:
* transform input (ActionBuilder, DeckBuilder) or format output (FormatOutput)
* handle errors and keeping error messages
* define card and action names