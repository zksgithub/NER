package com.zhangkui.www.automaticwordgenerater.newTech;

import org.apache.log4j.Logger;


 // Import log4j classes.


 public class MyApp {

   // Define a static logger variable so that it references the
   // Logger instance named "MyApp".
   static Logger logger = Logger.getLogger(MyApp.class);
  

   public static void main(String[] args) {

     // Set up a simple configuration that logs on the console.
    //logger.setResourceBundle("resources/log4j.properties");

     logger.info("Entering application.");
     logger.info("Exiting application.");
   }
 }