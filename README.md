# PhotoLocos

## Introduction

PhotoLocos allows photographers to maintain records of their favorite photography locations.  They can upload photos and location data at any time.

Users can interact with PhotoLocos using either a set of RESTful service endpoints, or a simple UI, or both.

## Storyboard

[Storyboard in Invision](https://projects.invisionapp.com/prototype/Plant-Diary-ck0bict0n005bqh01aaeu8tuu)

## Requirements

1. As a photographer, I want to be able to catalog my favorite photos and locations, so that I share and remember where I found good photo spots.

### Example 

**Given**:  A feed of photo data are available

**When**: The user/service selects a photo "photoname"

**When**: The user/service adds location to "photoname"

**Then**: The user’s/service’s photo will be saved with photo location

### Example 

**Given**: Photo data are available

**When**: The user/service searches for “383837dhdhdlslsl888”

**Then**: PhotoLocos will not return any results, and the user will not be able to see any photos/locations.

### Example 

**Given**: Photo data are available, and the photo is Ohio River with tag "river".

**When**: The user/service searches for the photo with tag “River”

**Then**: PhotoLocos will return all photo locations with the respective tag "river".

**Then**: PhotoLocos will return all photos with the respective tag "river".

### Example 

**Given**: Photo data are available

**When**: The user/service posts a new photo with valid location attributes "latitude=39.74, longitude=-84.51, city=cincinnati, state=OH, country=US"

**Then**: PhotoLocos will create a new photo for this record, and will return this new photo object.

### Example 

**Given**: Photo location data is available

**When**: The user selects a state, city, and/or area

**Then**: PhotoLocos will display relevant photos

**Then**: PhotoLocos will display popular tags in that area

2.	As a homeowner, I want to be able to upload photos that I love at any time.

### Example 

**Given**: The user has selected a 'upload photo'

**When**: The user uploads a valid 640*480 photo and inputs required photo attributes and tag

**Then**: The 640*480 photo will be saved as a photo object which can be searched and retrieved later using location or tag.

### Example 

**Given**: The user selects upload photo

**When**: The user uploads a 10MB-100GB photo

**Then**: The photo will be rejected as too large.

### Example 

**Given**: The user selects upload photo

**When**: The user attaches a photo

**When**: The user does not enter attributes

**Then**: The photo will be rejected and message to the user "Input Required Fields"

### Example 

**Given**: The user selects upload photo

**When**: The user uploads a 1600*1200 photo

**Then**: The photo will be resized automatically to 640*480

**Then**: The 640*480 photo will be shown to the user.

3.	As a homeowner, I want to browse photos based on certain filters
### Example 

**Given**: The user has entered state

**When**: The user searches.

**Then**: The user will see a list of locations in that area and other filters

**Then**: The user will see photos matching the location


## Class Diagram

![PhotoLocoClassDiagram](https://user-images.githubusercontent.com/55965142/107127760-54a5f200-6886-11eb-904f-0164fc5c67e3.png)  

### Class Diagram Description  

- **PhotoDirectoryController**: Controller class to handle endpoint requests.  

- **EnterpriseApplication**: Starts and Runs our SpringBoot Project.

- **ServerInitializer**: Initializer class to handle azure/database deployment in future.

- **Photo**: DTO class for our photo object, that holds most attributes representing a photograph, such as tag, type, rating and our Location class object.  

- **Location**: DTO class for our Location object, that holds most attributes representing a location for a Photo, such as longitude, latitude and string location names such as city and state.  

- **IPhotoService**: Interface class that defines the core methods handling business logic, that is required to provide micro services to various endpoints.  

- **PhotoService**: Service class that implements IPhotoService, thus will be our final implementation of service class. Handles mot of the business logic and provides appropriate results for controller class to be functional or carry out its processes.  

- **PhotoServiceStub**: Service class that implements IPhotoService, but will be our hard coded implementation to test out initial functionality and requirements as they are being needed and created.  

- **IPhotoDAO**: DAO Interface class, that defines the methods required to access an Photo object from datasource.  

- **PhotoDAO**: DAO class, that implements the IPhotoDAO, and provides functionality to access and return an legitimiate Photo Object.  

- **ILocationDAO**: DAO Interface class, that defines the methods required to access an Location object from datasource.  

- **LocationDAO**: DAO class, that implements the ILocationDAO, and provides functionality to access and return an legitimiate Location Object.  

## JSON Schema

This is what we plan to export to another app.

Please see the [examples](https://github.com/torserver/PhotoLocos/tree/master/examples) folder for the JSON schemas of this project.

## Team Memebers and Roles

UI Specialist: Kyle Marler & Joshua Gyau
  
Business Logic/Persitence: Max Graman & Sandhu Paramjyot
  
DevOps/Product Owner/Scrum Master/GitHub Admin: Vaz Torcato
  

## Milestones

[Milestones](https://github.com/torserver/PhotoLocos/milestones)

## Standup

[We meet 6:00 PM Eastern on Thursday on Teams]



