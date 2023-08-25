## WildLife tracker
### Author name:
Collins Kiprono Rotich
 
### Description of project
The Forest Service is considering a proposal from a timber company to clear cut a nearby forest of Douglas Fir.
Before this proposal may be approved, they must complete an environmental impact study. 
We are building an application that allows Rangers to track wildlife sightings in the area.

The application tracks two categories of wildlife:

#### Animals
At the very least, require:

- id
- name
- Endangered Animals

Due to their dwindling numbers, Rangers must record additional information about 
#### EndangeredAnimals:

- id
- name
- health

Constants are used to define options like "healthy", "ill", and "okay".
age (an estimated guess by the ranger)
Constants are used to define options like "newborn", "young", or "adult".
Each time an animal species of either category is seen, a Sighting must be reported:

#### Sightings
When wildlife is spotted, a Ranger submits a form to record a Sighting containing the following:

- id of Animal or EndangeredAnimal species
- location
(Conveyed in any manner you choose ie: "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values are all acceptable.)
- rangerName
>> It may take a few days for new Rangers to familiarize themselves with the app. 
- To avoid saving incomplete or invalid records, throw and catch exceptions if Rangers attempt to submit an incomplete form, or misuse the application in any other conceivable fashion.

### Project setup instructions
- Clone the project. `git clone https://github.com/collinskrotich/java-spark-week3.git`
- Use any editor to open the project and run Main.java.
- Test the Caesar cipher with any message and key.
 
### Technologies
Java

### Copyright and License information
Copyright(c) 2023 Collins Rotich