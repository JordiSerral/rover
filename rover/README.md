# Control - Rover ABA rover mission

Rover ABA is a REST API that simulates the control of a Rover sent to Mars to teach English

## Prerequisites
	- Java 1.8
## Specifications
### Endpoints
	- /rovers/position -> Move Rover
	- /rovers/english -> Teach Sentence in Display
#### Movement
To move Rover need a List of Movements:
	-Direction ('N','S','E','W')
	-Units (Integer)
Response a Position with Latitude & Longitude
#### English
To teach English sentence in Display:
	-Sentence (String)

### Examples

	
```bash
curl -H "Accept:application/json" -H "Content-Type:application/json" -X POST --data {"Hello Aliens, I'm ABA Rover"} "http://localhost:8080/rovers/english"
Rover is displaying the message on his display:{Hello Aliens, I'm ABA Rover}


curl -H "Accept:application/json" -H "Content-Type:application/json" -X POST --data "[{"""direction""":"""S""", """units""":"""8"""}]" "http://localhost:8080/rovers/position"
Position [Latitude=0, Longitude=-8]

curl -H "Accept:application/json" -H "Content-Type:application/json" -X POST --data "[{"""direction""":"""S""", """units""":"""8"""},{"""direction""":"""E""", """units""":"""44"""}]" "http://localhost:8080/rovers/position"
Position [Latitude=44, Longitude=-8]
```