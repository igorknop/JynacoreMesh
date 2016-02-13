/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.pgmc.jynacoremesh;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igor
 */
public class JynacoreMesh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Integer rows = 0;
       Integer cols = 0;
       
       try{
       rows = 25;//Integer.valueOf(25);
       cols = 25;//Integer.valueOf(25);
       }catch (Exception e){
          System.err.println(e);
       }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
            sb.append("    		<classInstance>\n");
               sb.append("			<name>section[").append(i).append(",").append(j).append("]</name>\n");
            sb.append("			<class>Cell</class>\n");
            sb.append("			<items>\n");
            sb.append("				<property>\n");
            sb.append("					<name>InitialValue</name>\n");
            sb.append("					<value>0.0</value>\n");
            sb.append("				</property>\n");
            sb.append("				<singleRelation>\n");
            sb.append("					<name>east</name>\n");
            sb.append("					<target>section["+i+","+((j==cols)?j:j+1)+"]</target>\n");
            sb.append("				</singleRelation>\n");
            sb.append("				<singleRelation>\n");
            sb.append("					<name>west</name>\n");
            sb.append("					<target>section["+i+","+((j==0)?j:j-1)+"]</target>\n");
            sb.append("				</singleRelation>\n");
            sb.append("				<singleRelation>\n");
            sb.append("					<name>north</name>\n");
            sb.append("					<target>section["+((i==0)?i:i-1)+","+j+"]</target>\n");
            sb.append("				</singleRelation>\n");
            sb.append("				<singleRelation>\n");
            sb.append("					<name>south</name>\n");
            sb.append("					<target>section["+((i==rows)?i:i+1)+","+j+"]</target>\n");
            sb.append("				</singleRelation>);\n");
            sb.append("			</items>\n");
            sb.append("		</classInstance>\n");

            }
        }
      try {
         FileWriter fw = new FileWriter("saida.txt");
         fw.write(sb.toString());
         fw.close();
      } catch (IOException ex) {
         System.err.println(ex);
         Logger.getLogger(JynacoreMesh.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
}
