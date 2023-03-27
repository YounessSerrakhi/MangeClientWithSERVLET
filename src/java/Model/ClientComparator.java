/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Comparator;

public class ClientComparator implements Comparator {
        public int compare (Object o1, Object o2){
            if (((Client)o1).getId()<((Client)o2).getId()) return -1;
            else if (((Client)o1).getId()>((Client)o2).getId()) return 1;
            else return 0;
        }
}
