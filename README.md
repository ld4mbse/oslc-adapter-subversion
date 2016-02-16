# oslc-adapter-subversion

##Java-based implementation of Subversion module for OSLC adapters 

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/Subversion-logo-cropped.png"/>
</p>



###Instructions to install and run the oslc-adapter-subversion 

Last updated by Axel Reichwein (axel.reichwein@koneksys.com) February 15, 2016

#### 1. Clone oslc-adapter-subversion repository 

1. Open the Git Repositories View (Window -> Show View -> type “Git Repositories” in the search field) 
2. Click on the Clone Repository icon
3. In the URI field, paste the following URL: https://github.com/ld4mbse/oslc-adapter-subversion.git 
4. The Host and Repository fields will autofill. 
5. Click Next, only select the master branch 
6. Click Next until Finish.

#### 2. Import edu.gatech.mbsec.adapter.subversion project into Eclipse workspace and build project 
 1. In the Git repositories view, right-click eedu.gatech.mbsec.adapter.subversion and select “Import Projects”. Click Next until Finish 
 2. The edu.gatech.mbsec.adapter.subversion project is in the Eclipse workspace 
 3. In Eclipse, open the Project Explorer view. (Window → Show View → Project Explorer) 
 4. Expand the edu.gatech.mbsec.adapter.subversion project 
 5. Right click pom.xml -> Run As -> Maven clean 
 6. Right click pom.xml -> Run As -> Maven install
