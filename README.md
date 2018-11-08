# MediaFeed

INSTALLATION

You will need to add two string tags in the strings resource folder with the following names: 

name="key" - where "Key" will be your youtube key 

name="access_token" - where "access_token" will be your access token for instagram. 

After adding those two string tags into your strings resource file, you can run the app.

FUNCIONALITY

The app downloads data from youtube api and instagram api and lists each in thier respective recyclerview.  You may click on the Youtube links and it will play the video.
I ran out of time to implement the instagram portion where you click on the link and it takes you to Instagram and shows the post.  
However, I saved the link for each post.  All that needs left is to open an implicit intent to instagram with the link to the post.  
