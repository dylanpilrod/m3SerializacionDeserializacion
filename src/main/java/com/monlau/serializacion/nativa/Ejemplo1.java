/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monlau.serializacion.nativa;

import com.monlau.serializacion.modelo.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dylanpilrod
 */
public class Ejemplo1 {
    public static void main(String[] args){
        
        Product prod = new Product(1,"Samsung",300.75);
        System.out.println(prod.toString());
        System.out.println("Vamos serializar prod anterior");
        serializar(prod);
        
    }
    static void serializar(Product p){
        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream(".\\Product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            System.out.println("El producto se ha serializado en Produt.ser");
        }catch (FileNotFoundException ex){
            System.out.println("Nose encuentra ruta" + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Problema serializando" + ex.getMessage());
        }finally{
            try{
                fileOut.close();
            }catch (IOException ex){
                System.out.println("Problema cerrando fichero" + ex.getMessage());
            }
        }
    }
    
    static Product deserializar() {
    FileInputStream fileIn = null;
    Product p = null;
    try {
        fileIn = new FileInputStream(".\\Product.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        p = (Product) in.readObject();
        System.out.println("El producto se ha deserializado correctamente.");
        in.close();
    } catch (FileNotFoundException ex) {
        System.out.println("No se encuentra el archivo" + ex.getMessage());
    } catch (IOException ex) {
        System.out.println("Problema deserializando" + ex.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println("La clase del objeto serializado no se encuentra en el classpath" + ex.getMessage());
        
    } finally {
        
        try {
            fileIn.close();
        } catch (IOException ex) {
            System.out.println("Problema cerrando fichero" + ex.getMessage());
        }
    return p;}
}
    
    
}
