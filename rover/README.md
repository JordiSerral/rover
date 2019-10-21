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

	- Direction ('N','S','E','W')
	- Units (Integer)

#####Example
```json
[{"direction":"S", "units":"8"}]
```
	
Response a Position with Latitude & Longitude

#### English
To teach English sentence in Display:

	- Sentence (String)

#####Example
```json
{"Hello Aliens, I'm ABA Rover"}
```
