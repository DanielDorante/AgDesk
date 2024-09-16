# Offline first applicaiton

Data layer

To handle reads and writes the application deals with reads and writes. 

**To be considered an offline first application the app needs to deal with reads without network access at the very least**

Two data sources

    - Local data source 
    - Network data source 

**local data source is considered truth for the higher layers of the applicaiton**
**our local data source will be an sql lite data base in this example**


**Pulled from wiki about exposing resources in the applicaiton** 

Exposing resources

The local and network data sources can differ fundamentally in how your app can read and write to them. Querying a local data source can be fast and flexible, such as when using SQL queries. Conversely, network data sources can be slow and constrained, such as when incrementally accessing RESTful resources by id. As a result, each data source often needs its own representation of the data it provides. The local data source and network data source may therefore have their own models.

The directory structure below visualizes this concept. The AuthorEntity is a representation of an author read from the app's local database, and the NetworkAuthor a representation of an author serialized over the network:

data/
├─ local/
│ ├─ entities/
│ │ ├─ AuthorEntity
│ ├─ dao/
│ ├─ NiADatabase
├─ network/
│ ├─ NiANetwork
│ ├─ models/
│ │ ├─ NetworkAuthor
├─ model/
│ ├─ Author
├─ repository/



## Write Strats

https://developer.android.com/topic/architecture/data-layer/offline-first
After looking through the write strats on the wiki I think the best general approch for writes in agdesk is the lazy write. This method saves the write to the local device the queues the write to the network connection. However this will require conflict resolution between the network source and the local source. 

    - data is critical. 


## Sync Strats 

In general because our users will likely be without internet connection for extended periods of time and be in locations where the internet connection is poor, a **push-based** synchronization is favourable. This will require either a **intermediary server** that deals with syncing data between the ag desk app or intergration with the ag desk apis or something
**something to bring up when talking to industry partner^^^**

## Conflict resolution 

Last Write wins is suitable for our application. Attach timestamp metadata to written data, when the device comes back online the data is sent to the server, the data sent with the most recent time stamp wins. 




