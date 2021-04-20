# Influx
A simple 2D game based. This game was originally written in processing in High School. I decided to revamp it and use Intellij to practice my Java skills.
This was my first foray into larger (hundreds of lines and multiple seperate classes and packages) programs. Many of the design decisions are not how I would do them now.
My original project is under the name Wave. 
## Methodology
The game engine is heavily meshed with graphics. The tickrate is set to 144 hz and movement is tied directly to the tickrate. All the game objects are added to a handler
which controls the flow of the game. 
## Installation
I used Intellij to build this. You may need to download and attach the JavaFx modules separately to your workspace.
You will need to add the following commands to your VM Options in your Run Configurations.
* --module-path "YOU'RE PATH HERE\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
## Libraries Used
* [JavaFx](https://gluonhq.com/products/javafx/) - GUI framework used
## License
Project licensed under GNU General Public License v3.0