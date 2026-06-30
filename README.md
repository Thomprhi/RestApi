Anais Thompson  

Client-Server architecture 

W1996867  

Q1. When returning a Java object from a method, it is automatically serialised into 
JSON. Explain the role of a MessageBodyWriter or a JSON provider (like Jackson) in this con- 
version process. 

MessageBodyWriter is a JAX-RS component. 
The role of the MessageBodyWriter is to convert Java objects into the format of a HTTP response body.
It's responsibilities include, checking it can write the returned objects type, looking at the requested media type,
serialising the Java object into an appropriate representation, and writing the resulting data to the HTTP output stream. 

 

Q2. REST architecture dictates that APIs should be strictly ’stateless’. Define what 
statelessness means in this context and explain why it makes cloud APIs easier to scale 
horizontally across multiple servers. 

Statelessness is one of the core principles of APIs.
It means APIs do not retain information between requests, and so every request is treated as an individual blank state even for previous users. 
Required information like authentication and resource identifiers will need to be re-entered. Statelessness make cloud APIs easier to scale horizontally across
mulitple servers as servers dont need to maintain session data, or context between sessions and each request is processed independently.
This means servers can be added or removed without the system being affected because there is no session data to be shared or migrated.


 

Q3. Discuss how implementing HTTP Cache-Control headers on the GET workspaces 
endpoint could improve performance for the client and reduce unnecessary processing 
load on the server. 

HTTP cache-control allows clients and intermediaries to store responses and reuse them to reduce unnecessary load on the server. 
This results in faster response times as it reduces the need for back and forth between the client and the server, 
and reduced latency as less information need to travel on the network  

 

Q4. If a client needs to verify whether a specific workspace exists but wants to save 
bandwidth by not downloading the entire JSON body, which HTTP method should they use 
instead of GET? Explain your reasoning 

To save bandwidth the client should use the HTTP method 'HEAD' to check whether a specific resource exists. 
HEAD works in the same way as 'GET' but reduces bandwidth as it only returns HTTP headers and status codes like '200 – OK (workspace found)' and '404 - not found' 
without needing to download the entire JSON body. This HTTP method results in a faster response than GET and reduces unnecessary data transfers. 
