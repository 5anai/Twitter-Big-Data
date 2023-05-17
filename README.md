# Twitter-Big-Data

This project focuses on using Apache Hadoop to process data extracted from a subset of Tweets. 

Emmploying MapReduce, JSON-formatted information is extracted and the occurrence of the expanded_url field is calculated. The core component of this project resides within the ScanWordsMapper class. Within this class, the map method is responsible for extracting a JsonArray of URLs from a JsonObject of entities. Subsequently, it retrieves the expanded_url field from the JsonArray and converts it to a String for further processing. 

## Snapshot
<img width="616" alt="Screenshot 2023-05-17 at 01 20 35" src="https://github.com/5anai/Twitter-Big-Data/assets/70899650/832a6b8c-6c81-49a7-a556-9c25806c4da6">
