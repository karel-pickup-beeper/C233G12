# C233G12
***********************************************KarelRPG*********************************************** <br/>
<pre>  _  __              _   _____  _____   _____ 
 | |/ /             | | |  __ \|  __ \ / ____|
 | ' / __ _ _ __ ___| | | |__) | |__) | |  __ 
 |  < / _` | '__/ _ \ | |  _  /|  ___/| | |_ |
 | . \ (_| | | |  __/ | | | \ \| |    | |__| |
 |_|\_\__,_|_|  \___|_| |_|  \_\_|     \_____|</pre>

This game is a collaborative project between Feifei Zhang, Vincent Tsin, Mark Pineda, Yasmin Samantar.<br/>


Karel RPG is a role playing game that allows a player to explore a preset map. The objective of the game is to defeat all the enemies within the room and collect all the items. The game is a turn based game, where the map will be updated based on turns<br/>

The game features a player controlled by using the keyboard ([W, A, S, D] to move, [T] to attack, [P] to pickup an item). The game also features a battle system, wherein, each enemy has it's on health and will die if it's life points are reduced to zero. The collection system is implemented to supplement the game objective. Lastly, The GUI interface, reacts to the user inputs. For example, when the enemy is attacked, and loses all its health, it will disappear from the map. The collectible item will also disappear, when the player picks the item up. There are multiple maps implemented on different levels with different types of enemies extending from super class "Enemy". <br/>

Project Start Date: July 10, 2019.<br/>

Feifei Zhang:<br/>
Player.java<br/>
Colletible.java<br/>
Vincent Tsin:<br/>
ActionPrompt.java<br/>
EndGame.java<br/>
Mark Pineda:<br/>
Enemy.java<br/>
Yasmin Samantar:<br/>
Maps.java<br/>
PhysicalColletible.java<br/>

Group 12 GitHub Repository URL (From DEMO 2): https://github.com/karel-pickup-beeper/C233G12/tree/cbd02f0bc834c2838c1a6ed0518de72a26e5ac0e
<br/>

Group 12 GitHub Repository URL (From DEMO 3): https://github.com/karel-pickup-beeper/C233G12.git
<br/>

Group 12 GutHubRepository URL (From Demo 4): https://github.com/karel-pickup-beeper/C233G12/tree/For-Demo-4
<br/>

Notes for Reviewing Past Versions {<br/>
v1.0 = #80 commit<br/>
v2.0 = #120 commit<br/>
v3.0 = #180 commit<br/>
}

Compile Instruction:
1. Open Terminal.
2. Change directory to folder ‘src’.
3. Enter command: java *.java.

Run Instruction:
1. Enter command: java ActionPrompt.

Install JavaFx Jar Instructions(Eclipse)<br/>

1.Open the project from File System<br/>
2. In Eclipse, right click on the desired folder<br/>
3. Click on Properties<br/>
4. Java Build Path > Libraries<br/>
5. Add External JARS > Add the jfxrt.jar<br/>
6. Apply and close<br/>

