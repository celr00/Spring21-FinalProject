/*
Pre-Final Project - Final Version
Carlos Enrique Lozada Rodríguez
Mauricio Araujo Rodríguez
*/

import java.io.*;
import java.util.*;
import java.text.*;

class Game{

  //Function that fills with dots a bidimentional matrix
  static String[][] fillArray(String arr[][]){
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[i].length;j++)
        arr[i][j] = " .  ";
    }
    return arr;
  }
  
  //Function that prints a String type bidimentional array
  static void printArrStr(String arr[][]){
    for(int i=0; i<arr.length;i++){
      for(int j=0; j<arr[i].length;j++){
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
  
  //Function that generates random numbers from 0 to a certain int value without including it
  static int randomNum(int max){
    int value;
    value = (int)(Math.random()*max);
    return value;
  }
  
  //Function that fills unidimentional vectors with coordinates inside a certaing range of rows and coulmns
  static int[] fillCoordinate(int arr[], int rows, int columns){
    arr[0] = randomNum(rows);
    arr[1] = randomNum(columns);
    return arr;
  }

  //Funciton that takes an array of bidimentional coordinates, the map and the object we want to move and moves it up
  static void moveUp(String map[][], int arr[][], int obj){
    if(arr[obj][0] != 0)
      arr[obj][0]--;
    map = updateMap(map, arr);
  }
  
  //Funciton that takes an array of bidimentional coordinates, the map and the object we want to move and moves it down
  static void moveDown(String map[][], int arr[][], int obj){
    if(arr[obj][0] != map.length-1)
      arr[obj][0]++;
    map = updateMap(map, arr);
  }
  
  //Funciton that takes an array of bidimentional coordinates, the map and the object we want to move and moves it to the right
  static void moveRight(String map[][], int arr[][], int obj){
    if(arr[obj][1] != map[0].length-1)
      arr[obj][1]++;
    map = updateMap(map, arr);
  }
  
  //Funciton that takes an array of bidimentional coordinates, the map and the object we want to move and moves it to the left
  static void moveLeft(String map[][], int arr[][], int obj){
    if(arr[obj][1] != 0)
      arr[obj][1]--;
    map = updateMap(map, arr);
  }
  
  //Function that updates de map
  static String[][] updateMap(String map[][], int arr2[][]){
    map = fillArray(map);
    map[arr2[0][0]][arr2[0][1]] = " #  ";
    map[arr2[1][0]][arr2[1][1]] = " #  ";
    map[arr2[2][0]][arr2[2][1]] = " #  ";
    map[arr2[3][0]][arr2[3][1]] = " #  ";
    map[arr2[4][0]][arr2[4][1]] = " #  ";
    map[arr2[5][0]][arr2[5][1]] = " #  ";
    map[arr2[6][0]][arr2[6][1]] = "END ";
    map[arr2[7][0]][arr2[7][1]] = " *  ";
    return map;
  }
  
  //Función que lleva un arreglo tipo int con una coordinada random
  static int[][] fillCoordinates(int arr[][], int x, int y){
    for(int i=0;i<arr.length;i++){
      arr[i][0] = x;
      arr[i][1] = y;
    }
    return arr;
  }
  
  //Función para imprimir un banner de resultado
  static void printResponse(char status){
    if(status == 'g'){
      System.out.println("\n##  ##    ##    ##  ##    ##  ##  ##    ##    ##    ##");
      System.out.println("##  ##  ##  ##  ##  ##    ##  ##  ##  ##  ##  ####  ##");
      System.out.println("##  ##  ##  ##  ##  ##    ##  ##  ##  ##  ##  ####  ##");
      System.out.println("  ##    ##  ##  ##  ##    ##  ##  ##  ##  ##  ####  ##");
      System.out.println("  ##    ##  ##  ##  ##    ##  ##  ##  ##  ##  ##  ####");
      System.out.println("  ##    ##  ##  ##  ##    ##  ##  ##  ##  ##  ##  ####");
      System.out.println("  ##      ##      ##        ##  ##      ##    ##    ##\n");
    }
    else if(status == 'p'){
      System.out.println("\n##  ##    ##    ##  ##    ##      ##      ##    ######");
      System.out.println("##  ##  ##  ##  ##  ##    ##    ##  ##  ##  ##    ##  ");
      System.out.println("##  ##  ##  ##  ##  ##    ##    ##  ##  ##        ##  ");
      System.out.println("  ##    ##  ##  ##  ##    ##    ##  ##    ##      ##  ");
      System.out.println("  ##    ##  ##  ##  ##    ##    ##  ##      ##    ##  ");
      System.out.println("  ##    ##  ##  ##  ##    ##    ##  ##  ##  ##    ##  ");
      System.out.println("  ##      ##      ##      ####    ##      ##      ##  \n");
    }
  }

  //Main Function
  public static void main(String[] args) {
    
    Scanner read = new Scanner(System.in);
    
    char win_or_loose = 'x';
    do{
    
    String gameMap[][] = new String[8][7];
    gameMap = fillArray(gameMap);
    
    //Random Coordinate that fills all of the arrays
    int a = randomNum(gameMap.length);
    int b = randomNum(gameMap[0].length);
    
    //Base Arrays
    int locations[][] = new int[8][2];
    int locationsB[][] = new int[32][2];
    
    //Filling Base Arrays with coordinates
    locations = fillCoordinates(locations,a,b);
    locationsB = fillCoordinates(locationsB,a,b);
    
    int test[] = {0,0};
    int cont = 0;
    char check;
    for(int i=0;i<8;i++){
      do{
         check = 'p';
         //Generates a random coordinate
         test = fillCoordinate(test, 8, 7);
         //Compares a coordinate with the the other objet's location so they do not overlap
         for(int j=0; j<locations.length;j++){
            if(test[0] == locations[j][0] && test[1] == locations[j][1])
               check = 'n';
         }
         //Checks that we do not have an object diagonl to this one
         for(int j=0; j<locationsB.length;j++){
            if(test[0] == locationsB[j][0] && test[1] == locationsB[j][1])
               check = 'n';
         }
      }while(check != 'p');
      
      locations[i][0] = test[0];
      locations[i][1] = test[1];
      
      if(test[0]==0 && test[1]==0){
         locationsB[cont][0] = 1;
         locationsB[cont][1] = 1; cont++;
      }else if(test[0]==7 && test[1]==6){
         locationsB[cont][0] = 6;
         locationsB[cont][1] = 5; cont++;
      }else if(test[0]==0 && test[1]==6){
         locationsB[cont][0] = 1;
         locationsB[cont][1] = 5; cont++;
      }else if(test[0]==7 && test[1]==0){
         locationsB[cont][0] = 6;
         locationsB[cont][1] = 1; cont++;
      }else if(test[1]==0){//3,0
         locationsB[cont][0] = test[0]-1; 
         locationsB[cont][1] = test[1]+1; cont++; //2,1
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]+1; cont++; //4,1
      }else if(test[1]==7){ //1,6
         locationsB[cont][0] = test[0]-1;
         locationsB[cont][1] = test[1]-1; cont++;//0,5
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]-1; cont++;//2,5
      }else if(test[0]==0){ //0,1
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]-1; cont++;//1,0
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]+1; cont++;//1,2
      }else if(test[0]==7){ //7,1
         locationsB[cont][0] = test[0]-1;
         locationsB[cont][1] = test[1]-1; cont++;//6,0
         locationsB[cont][0] = test[0]-1;
         locationsB[cont][1] = test[1]+1; cont++;//6,2
      }else{ //3,3
         locationsB[cont][0] = test[0]-1;
         locationsB[cont][1] = test[1]-1; cont++;//2,2
         locationsB[cont][0] = test[0]-1;
         locationsB[cont][1] = test[1]+1; cont++;//2,4
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]-1; cont++;//4,2
         locationsB[cont][0] = test[0]+1;
         locationsB[cont][1] = test[1]+1; cont++;//4,4
      }
    }
    
    gameMap = updateMap(gameMap,locations);
    printArrStr(gameMap);
    
    System.out.println("Move the * until the END");
    
    char ending = 'n';
    char other;
    while(ending != 's'){
      System.out.println("Use:");
      System.out.println("W o w to move up");
      System.out.println("S o s to move down");
      System.out.println("D o d to move right");
      System.out.println("A o a to move left");
      char movement = read.next().charAt(0);
      if(movement == 'w' || movement == 'W')
         moveUp(gameMap, locations, 7);
      else if(movement == 'a' || movement == 'A')
         moveLeft(gameMap, locations, 7);
      else if(movement == 's' || movement == 'S')
         moveDown(gameMap, locations, 7);
      else if(movement == 'd' || movement == 'D')
         moveRight(gameMap, locations, 7);

      printArrStr(gameMap);
      //System.out.println("object in: ("+locations[7][0]+","+locations[7][1]+")");
      
      if(locations[7][0] == locations[6][0] && locations[7][1] == locations[6][1]){
         ending = 's';
         printResponse('g');
         }
      else if(locations[7][0] == locations[0][0] && locations[7][1] == locations[0][1]){
         ending = 's';
         printResponse('p');
         }
      else if(locations[7][0] == locations[1][0] && locations[7][1] == locations[1][1]){
         ending = 's';
         printResponse('p');
         }
      else if(locations[7][0] == locations[2][0] && locations[7][1] == locations[2][1]){
         ending = 's';
         printResponse('p');
         }
      else if(locations[7][0] == locations[3][0] && locations[7][1] == locations[3][1]){
         ending = 's';
         printResponse('p');
         }
      else if(locations[7][0] == locations[4][0] && locations[7][1] == locations[4][1]){
         ending = 's';
         printResponse('p');
         }
      else if(locations[7][0] == locations[5][0] && locations[7][1] == locations[5][1]){
         ending = 's';
         printResponse('p');
         }
    }
    
      do{
        System.out.println("Do you wish to play again?");
        System.out.println("Y - Yes");
        System.out.println("N - No");
        other = read.next().toUpperCase().charAt(0);
      }while(other != 'Y' && other != 'N');
      
      if(other == 'N')
         win_or_loose = 'w';
    
    }while(win_or_loose != 'w');
  }
}
