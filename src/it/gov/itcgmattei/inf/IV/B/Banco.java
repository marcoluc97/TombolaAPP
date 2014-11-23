package it.gov.itcgmattei.inf.IV.B;
import java.util.Random;

public class Banco 
    {
        Random rdm;
        boolean[] numeriEstratti;

        public Banco(){
        	rdm = new Random();
        	numeriEstratti =  new boolean[90];
        }
        public int estraiNumero(){
        	
        	boolean estratto = false;
        	int num = 0;
        	do{
        		num = rdm.nextInt(90);
        		if (!numeriEstratti[num])
        		{
        			numeriEstratti[num] = true;
        			estratto = true;
        		}
        	}while (!estratto);
        return num+1;
        }
    }