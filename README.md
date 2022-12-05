PDFGenerator
===============

PDFGenerator library, it's helps to creating PDF document from the given data.

### Permission

If you are providing your custom filePath then your application must have 
**STORAGE READ-WRITE PERMISSION** in order to store Pdf in provided path.

### How to integrate into your app ?

Integrating the project is simple, All you need to do is follow the below steps.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end
of repositories:

>            allProjects {
>              repositories {
>                maven { url "https://jitpack.io" }
>              }
>            }

Step 2. Add the dependency: ( NOTE: Replace the tag with latest version )

>            dependencies {
>                'implementation 'com.github.RifluxyssSDK:PDFGenerator:2.0.13'
>            } 

### Quick Start

In order to start using PdfGenerator, Just copy below code to your project and just pass the
required values and that's all you done!...
        
>        Document document = new Document().init(context);
>        document.open(10);
>        document.add(new Paragraph().add(new Text(1,10,"Hello Document")));
>        document.close();
>        try { document.finish(file); } catch (IOException e) { e.printStackTrace(); }

### Technologies we used

* Java 8
* View
* Canvas
* Bitmap Config
* Exception Handling 
* PdfDocument ( native )

### Description 

Android Native libraries using generate the Dynamic PDF document.

# We are Some of the challenges face in the future are

# Programmatically generate the view of the grid layout, text view and image view & draw the view

# of the line we are generate some of the challenges are facing.

# table of contents to make it easy for users to navigate to different sections easily

