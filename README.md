# CustomsBridge---Technical-test

Two hours to develop a project for CustomsBridge

# I. Project creation

 We are going to create a new webpack project and then copy/paste our files into this project.
 
 Let's create a new folder.
 
 Go, with CMD, into this directory.
 
 Then type commands...
 
 ```sh
npm install -g @vue/cli
npm install init
vue init webpack <Name-Of-Project>
```

This last command will ask you how to create the project.

 ```sh
Project name... Choose your name
Project description... As you want !
Author... Put the compagny name eventualy
Vue Build... Choose "Runtime + Compiler: recommended for most users
Install vue-router?... Choose No
Use ESLint to lint your code?... Choose No
Set up init tests?... Choose No
Setup e2e tests with NightWatch?... Choose No
Should we run 'npm install'... Choose "Yes use NPM"
The project is created !
```

Go then into the new folder, created by vue (still in CMD). This new folder has for name what you choose before.
Then install some vue packages, necessary to run or build project.

 ```sh
npm install bootstrap jquery popper.js vue-country-flag
```

After that we just have to replace files who been created by vue by our git files.
Into the project replace index.html by the git' index.html.
Into src replace main.js and App.vue by the git's main.js and App.vue (they are in src folder).
Into src/components replace HelloWolrd.vue by our git's components (ListObject.vue and ListShower.vue).
Finally replace assets folder by our git's assets folder.

> The index.html file and the assets folder are not realy diffrent between git and vue project but to be sure we copy/paste them.

You can now type the command...

 ```sh
npm start
```

To get the project at http://localhost:8080/

## II. Building

Go now to the root priject folder and type this command to build to project into the dist folder.

```sh
npm run build
```

**More informations : https://cli.vuejs.org/guide/creating-a-project.html**

## III. Deployment

Copy then the dist generated file to the production or preproduction server (linux here).
Then enter into directory and type commands...

```sh
sudo apt-get install nodejs npm
npm install -g serve
serve -s .
```

**More informations : https://cli.vuejs.org/guide/deployment.html#previewing-locally**

Let's use the app !
