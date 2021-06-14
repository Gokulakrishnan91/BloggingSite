# BloggingSite

Requirement:
============
Assume an organization CollabSearch is building a Technology Forum platform that will enable all their 10M+ users share their technology blogs/ideas to get the
feedback from the community. We are expecting below items that help building this platform:
1. Data model design
2. High level technical architecture/layered diagram - You can pick Technology/Frameworks of your choice that you can justify during our discussion.
Provided design should support below use cases:
* User should be able to signup and login to the platform
* User should be able to post the blog
* User should be able to search the available blogs
* Other users should be able to post the comment to the blog being viewed
* Other users should be able to "Like" the blogs.

Implementation details:
=======================
Below documents are available in /doc directory:

BlogPost.drawio - High Level Design 

Forum System Design.pptx - Presentation

Below usecases are covered in the code implementation :

User : The user can log in and create/update the user information, the user service can trigger and complete the business logic for user creation.

Post : After successful login, user can add a new post in the activity feed.

View Posts : The application has an activity feed that displays all the posts and the post controller is responsible for this activity, the user can scroll to load more posts.


