PDFGenerator
===============

PDFGenerator library, it's helps to creating PDF document from the given data.

### Permission*

If you are providing your custom file path then your application must have 
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
* Layout
* Bitmap Config
* Exception Handling 
* PdfDocument ( Android Native )

### Description 

* This is a simple and straight forward library for creating pdf document through your application.
* Document design is customizable. To change the design go through the comments declared in codes and customize as per your need.

### Authors
* [Rifluxyss Team]()

### Fork & Star if it helped you.

