/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.takeupmemory;

import java.util.Date;

/**
 *
 * @author jordi
 */
public class TakeMemory {
    
    public static void main(String[] args) {
        
        
        System.out.println("easy  program with secons and memory : ");
        int seconds = 120;
        int memory = 100;
        if (args.length > 1 ) {
            seconds = new Integer(args[0]).intValue();
            System.out.print(seconds);
            System.out.print("  ");
            memory =  new Integer(args[1]).intValue();
            System.out.print(memory);
        }

        Long oldDate = new Date().getTime();
        Long future = oldDate + (seconds * 1000);
        // 1024kb are 1Mb. 1024byte ar 1Kb
        byte [][] mem = new byte[1024*1024][memory];
        
        while (new Date().getTime() < future) {
           //this is to avoid that GC collect the mem object
            byte [][] now =  mem;
            now = null;
        }
        
    }
    
    
}