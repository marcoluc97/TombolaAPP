package it.gov.itcgmattei.inf.IV.B;
import java.io.*;

public class TombolaApp
    {
        public static void main(String[] args) throws IOException
        {
        	System.out.println("*******************************\n*****     TOMBOLA APP     *****\n*******************************");
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	//chiedi quanti sono i giocatori
        	System.out.println("\nCiao, quanti siete?\t");
        	int n=0;
        	try{ n = Integer.parseInt(br.readLine()); }
        	catch (IOException e) {e.printStackTrace();}
        	//crea un vettore di lun n di tipo Giocatore inserendo un nome per ciascuno
        	Giocatore[] g = new Giocatore [n];
        	String nome = null;
        	for(int i=0;i<n;i++){
        		int a=1+i;
        		System.out.println("Giocatore "+a+" inserisci il nome");
        		nome = br.readLine();
        		g[i] = new Giocatore (nome);
        	}
        	//stampa video la schedina di ogni giocatore
        	for(int i=0;i<n;i++){
           		System.out.println("\nLA SCHEDINA DI "+g[i].nome+" è:");
        		g[i].verifica();
        	}
        	System.out.print("\n");
        	Banco banco = new Banco();//creazione del banco
        	System.out.print("\n");
        	System.out.println("*******************************\n*****     ESTRAZIONE      *****\n*******************************\n");
        	//vettore nel caso più persone faccianola tombola insieme
            int[] v=new int[n];
			int k=0; 
            boolean y;
			boolean x = y = false;
            //gestione del gioco
            	while (y==false){
            		
            	    int numero = banco.estraiNumero();//estrazione di un numero
            	    System.out.println("IL NUMERO ESTRATTO E'... " + numero);
            	    for(int i=0;i<n;i++){//ripete per ogni giocatore
            	    g[i].controllaNumero(numero);//controlla il numero nella schedina
            	    x=g[i].tombola();//se c'è controlla se ha fatto tombola
            	    	if(x==true){//se si si segna il giocatore
            	    		v[k]=i;
            	    		k++;
            	    		y=true;
            	    		x=false;
            	    	}
            	    }
                }
            System.out.println("\n*******************************\n*****       VINCITE       *****\n*******************************\n");
            //stampa finale delle vincite
            if(k>1)System.out.println("HANNO FATTO TOMBOLA:");
            for(int i=0;i<k;i++){
            	if(k==1){
            		System.out.println(g[v[i]].nome +" HA FATTO TOMBOLA!");
            		System.out.println("LA SCHEDINA VINCENTE E': " );
            	}
            	else System.out.println(g[v[i]].nome);
            	
            	g[v[i]].verifica();
            }
            br.close();
            
        }
    }