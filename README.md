# Dungeon_Crawler-Java-Change Log

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/) and this project adheres to [Semantic Versioning](http://semver.org/).
## Version 1.7.1
  Date May 27, 2018
- All characters now have 3 actions
- Added a very simple enemy AI
- Whichever enemy that player attacks, the enemy will attack back
- In the use of a heavy attack, that user/enemy will skip the next attack
- Changes made are located in:
  - Dungeon.java:
    - Added new function: attackPlayer()
    - combat() and heal() have been updated with new combat log updates and heavy attack skips
    - updateLightAtk(), updateHeavyAtk(), and generateCharAtk() have been updated with heavy attack skips

## Version 1.7.0
  Date May 25, 2018
- Added a functional combat system in Dungeon.java
- Cleaned up UI

## Version 1.6.0
  Date May 24, 2018
- Added a dungeon selection menu
- Updated all /entity/ source files

## Version 1.5.0
  Date May 23, 2018
- Added player class Barb.java
- Updated code in Party.java to make it functional.

## Version 1.4.0
  Date May 20, 2018
- Renamed Monster.java to Entity.java since it is the parent for both monsters and characters
- Added new party system, Party.java in central hub
- Updated all code in GameController.Java, CentralHub.Java

## Version 1.3.1
  Date May 18, 2018
- Cleaned up code from previous version

## Version 1.3.0
  Date: May 18, 2018
- Added new animations to title screen and monsters
- Added new backgrounds to dungeon features
- Updated button appearance
- Added monster class for generating monster objects in /Entities/ folder
- Added a combat log that will display combat information
- Dungeon.java changes
  - generateEnemy() function has changed to reflect the new monster class
  - setCombatText() tests interactions with a monster object

## Version 1.2.0
  Date: May 17, 2018
- Added Central Hub, which will display after starting the game

## Version 1.1.2
  Date: May 15, 2018
- Added option to generate a certain sized dungeon based on button input as well as randomized dungeon size

## Version 1.1.1
  Date: May 08, 2018
- Added a minimap of dungeon progress

## Version 1.1.0
  Date: May 04, 2018
- Implemented randomized background for each dungeon room
- Added character and enemy generation

## Version 1.0.0
  Date: May 01, 2018
- Created a Dungeon.Java, GameController.Java.
- Currently displays a functional main menu and dungeon layout