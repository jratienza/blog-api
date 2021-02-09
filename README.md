# BLOG API
To run,
```aidl
mvn clean spring-boot:run
```

##API REQUESTS  
###Create Blog

```aidl
POST /create
{
    "title" : "BlogTitle",
    "content" : "Blog Content",
    "author" : "Blog Author",
    "publishedDate" : "2020-01-01"
}
```
####Successful Request
```
201 CREATED
{
    "id": "1234-1234-1234-1234"
}
```
####Unsuccessful Request
```aidl
500 INTERNAL SERVER ERROR
{
    "message": "Invalid Blog Details."
}
```  

###Get All Blogs
``` 
GET /getAll
```
####Successful Request
```
200 OK
[
    {
        "id" : "1234-1234-1234-1234",
        "title" : "BlogTitle",
        "content" : "Blog Content",
        "author" : "Blog Author",
        "publishedDate" : "2020-01-01"
    },
    {
        "id" : "1234-1234-1234-1235",
        "title" : "BlogTitle1",
        "content" : "Blog Content",
        "author" : "Blog Author1",
        "publishedDate" : "2020-01-01"
    }
]
```
``` 
200 OK
[]
```

###Get Blog with ID
``` 
GET /get/1234-1234-1234-1234
```
####Successful Request
```
200 OK
{
     "id" : "1234-1234-1234-1234",
    "title" : "BlogTitle",
    "content" : "Blog Content",
    "author" : "Blog Author",
    "publishedDate" : "2020-01-01"
}
```
####Unsuccessful Request
``` 
500 INTERNAL SERVER ERROR
{
    "message": "Blog ID not found."
}
```
###Update Blog Details
```
PATCH /update/1234-1234-1234-1234
{
    "title": "New Blog Title"
}
```
####Successful Request
```
200 OK
Updated blog 1234-1234-1234-1234
```
####Unsuccessful Requests
``` 
500 INTERNAL SERVER ERROR
{
    "message": "Blog ID not found."
}
```
``` 
500 INTERNAL SERVER ERROR
{
    "message": "Invalid Blog Details."
}
```

###Delete Blog
``` 
DELETE /delete/1234-1234-1234-1234
```
####Successful Request
```
200 OK
Deleted blog 1234-1234-1234-1234
```
####Unsuccessful Requests
``` 
500 INTERNAL SERVER ERROR
{
    "message": "Blog ID not found."
}
```