# PhotoLocos

## Introduction

PhotoLocos allows photographers to maintain records of their favorite photography locations.  They can upload photos and location data at any time.

Users can interact with PhotoLocos using either a set of RESTful service endpoints, or a simple UI, or both.

## Storyboard

[Storyboard in Invision](https://projects.invisionapp.com/prototype/Plant-Diary-ck0bict0n005bqh01aaeu8tuu)

## Requirements

1. As a photographer, I want to be able to catalog my favorite locations, so that I share and remember where I found good photo spots.

### Example 

**Given**:  A feed of photo data are available

**When**: The user/service selects a photo "photoname"

**When**: The user/service adds location to "photoname"

**Then**: The user’s/service’s photo will be saved with photo location

### Example 

**Given**: Specimen data are available

**When**: The user/service searches for “kajsd;luaopuidfjo;aj;sd”

**Then**: My Plant Diary will not return any results, and the user will not be able to save the specimen.

### Example 

**Given**: Specimen data are available, and specimen 83 is Eastern Redbud.

**When**: The user/service searches for the specimen with ID “83”

**Then**: My Plant Diary will return exactly one specimen record for "Eastern Redbud".

### Example 

**Given**: Specimen data are available

**When**: The user/service posts a new Specimen object with valid attributes "latitude=39.74, longitude=-84.51"

**Then**: MyPlantDiary will create a new specimen for this record, and will return this new specimen object.

2.	As a homeowner, I want to be able to upload photos of my plant at any time.

### Example 

**Given**: The user is logged in and has selected a previously-saved Eastern Redbud specimen

**When**: The user uploads a valid 640*480 photo of an Eastern Redbud Flower

**Then**: The 640*480  photo of an Eastern Redbud flower will be saved to the specimen profile, and can be viewed later.

### Example 

**Given**: The user is logged in and has selected a previously-saved Eastern Redbud specimen

**When**: The user uploads a 100GB photo

**Then**: The photo will be rejected as too large.

### Example 

**Given**: The user is logged in and has selected a previously-saved Eastern Redbud specimen

**When**: The user uploads a 1600*1200 photo

**Then**: The photo will be resized automatically to 640*480

**Then**: The 640*480 photo will be shown to the user.

3)	As a homeowner, I want to generate a report of the sustainability of my yard.
### Example 

**Given**: The user has a valid account and specimens associated to that account.

**When**: The user runs a report.

**Then**: The user will see a report of plants, dates, native, edible, and sustainability rating.

### Example 

**Given**: The user has a valid account and no specimens associated to that account.

**When**: The user runs a report.

**Then**: The user will see an error, indicating no data available for report.

## Class Diagram

![MyPlantDiaryClassDiagram](https://user-images.githubusercontent.com/2224876/93275565-40ecd880-f78b-11ea-8030-cd87987b1817.png)

### Class Diagram Description 

## JSON Schema

This is what we plan to export to another app.


> {
>  "type" : "object",
>  "properties" : {
>    "name" : {
>      "type" : "string"
>    },
>    "age" : {
>      "type" : "integer"
>    }
>  }
> }

## Team Memebers and Roles

UI Specialist: Kyle Marler & Joshua Gyau
Business Logic/Persitence: Max Graman & Sandhu Paramjyot
DevOps/Product Owner/Scrum Master/GitHub Admin: Vaz Torcato

## Milestones

[Milestone 1](https://github.com/discospiff/SpringBootMicroservicesWithIntelliJIDEA/milestone/1)

## Standup

[We meet 6:00 PM Eastern on Thursday on Teams]()



