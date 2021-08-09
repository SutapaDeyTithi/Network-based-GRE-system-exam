/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.pkg101;

import java.io.Serializable;


public class data implements Serializable{
  public  String q,op1,op2,op3,op4;
   public String answer;

    data(String ans,String text,String s2,String s3,String s4,String s5) {
       this.answer=ans;
        this.q=text;
this.op1=s2;
    this.op2=s3;
        this.op3=s4;
        this.op4=s5;//To change body of generated methods, choose Tools | Templates.
    }

    data() {
        q=new String();
        op1=new String();
        op2=new String();
        op3=new String();
        op4=new String();
        answer=new String();
    
         //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public String toString(){
       return answer+q+op1+op2+op3+op4; 
    }
    
}
