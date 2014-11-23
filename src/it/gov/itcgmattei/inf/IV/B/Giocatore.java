package it.gov.itcgmattei.inf.IV.B;
import java.util.Random;

//aggiungere metodi per ambo terna ecc..
class Giocatore
    {
	   //aggiungere variabile per la lunghezza della cartella
       int[] schedina = new int[5];
       int[] scheda = new int[5];
       String nome;

       public Giocatore(String nome) 
       {
    	   this.nome = nome;
    	   //ora creiamo la schedina mettendo tutto a -1
    	   for(int i=0; i<5; i++)
    		   schedina[i] = -1;
    	   Random rdm = new Random();
    	   for (int i=0; i<5; i++)  {
    	   // assegna a scheda[i] un numero diverso da tutti quelli già usciti
    		   boolean app;//appoggio
    		   do // fai questo finchè 
    		   {
    			   int x = rdm.nextInt(90)+1;//0-89 +1
    			   // controlla che x non sia gia' parte della scheda
    			   app = true;
    			   for (int j=0; j<i && app; j++)
    				   if (app && (schedina[j] != x));
    				   else app=false;
    			   //metti false se trova un numero uguale
    			   if (app)//se non c'è lo mette
    			   {
    				   schedina[i] = x;
    				   scheda[i] = x;//salvo la schedina per la fine
    			   }
    		   }while (!app);// app == false quando ha finito passa all'altro posto
    	   }
       }

       public boolean controllaNumero(int n) 
       {
    	   boolean x = false;
    	   for (int i=0; i<5 && !x; i++){
    		   if(schedina[i] == n) x=true;
    		   else x=false;
    		   if (x) 
    			   schedina[i] = -1;
    	   }
    	   if (x)
    		   System.out.println(nome+" ha il numero: "+n);
    	   return x;//se lo trova restituisce true
       }

       public boolean tombola() 
       {  
    	   boolean x = true; 
    	   for (int i=0; i<5 && x; i++) 
    		   if((x)&& (schedina[i] == -1))
    			   x=true;
    		   else x=false;
    	   return x;//se sono usciti tutti restituisce true
       }
       //stampa la schedina vincente
       public void verifica(){
    	   for(int i=0;i<5;i++)
    	   System.out.print(scheda[i]+" ");
       }
    }