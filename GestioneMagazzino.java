import java.util.Scanner;

public class GestioneMagazzino
{
   public static void main(String[] args)
   {
      // Oggetto per effettuare l'input 
      Scanner input = new Scanner(System.in);

      // Chiedo all'utente di inserire il nome e la password dell'utente 
      System.out.print("Nome dell'utente da creare: ");
      String nome = input.next();

      // Chiedo la psw 
      System.out.print("Inserire la psw dell'account: ");
      String psw = input.next();

      // Chiedo il livello dell'utente 
      System.out.print("Livello utente 0 user - 1 admin: ");
      int livello = input.nextInt();

      // Creazione dell'account 
      Account utente = new Account(nome, psw, livello);

      // Prove accesso 
      int proveAccesso = 0;
      boolean flag = true;

      // Psw temp 
      String pswTemp;

      // Accesso all'account 
      do 
      {
         System.out.print("Inserire la psw: ");
         pswTemp = input.next();

         // Controllo della pasw 
         if (utente.psw.equals(pswTemp)) 
         {
            // Aggiorno il flag 
            flag = false;
            System.out.println("Accesso effettuato");
         }

         // Incremento la prova di accesso 
         proveAccesso++;
         
      } while ((proveAccesso < 2) && flag);

      // Controllo se la psw è stata azzeccata 
      if (proveAccesso != 2) 
      {
         // Scelta dell'utente 
         int scelta = 0;

         // Creazione della lista dei prodotti 
         GestioneProdotti vetProdotti = new GestioneProdotti();

         // Controllo il livello dell'utente per decidere quale menù aprire 
         if (utente.livello == 1) // Se admin 
         {
            // Menù per la gestione degli articoli 
            do 
            {
               System.out.println();
               System.out.println("Menu'");
               System.out.println("1 Aggiungi un prodotto");
               System.out.println("2 Elimina un prodotto");
               System.out.println("3 Modifica un prodotto");
               System.out.println("4 Visualizza prodotti");
               System.out.println("5 Esci");
               System.out.print("Scelta: ");
               scelta = input.nextInt();

               // Controllo della operazione 
               if (scelta == 1) 
               {
                  // Chiedo all'utente di inserire il nome del prodotto ed il suo costo 
                  System.out.print("Inserire il nome del prodotto: ");
                  String nomeProdotto = input.next();
                  System.out.print("Inserire il costo del prodotto: ");
                  double costoProdotto = input.nextDouble();
                  System.out.print("Inserire la quantita' del prodotto: ");
                  int quantita = input.nextInt();

                  // Creo il prodotto 
                  Prodotto nuovoProdotto = new Prodotto(nomeProdotto, costoProdotto, quantita);

                  // Aggiungo il prodotto al magazzino 
                  vetProdotti.addProdotto(nuovoProdotto);
                  System.out.println("Prodotto Aggiunto");
               }
               else if(scelta == 2)
               {
                  // Chiedo all'utente di inserire il nome del prodotto che si vuole eliminare 
                  System.out.print("Nome del prodotto che si vuole eleimnare: ");
                  String nomeProdottoDaEliminare = input.next();

                  // Chiamo la funzione per elimare il prodotto 
                  vetProdotti.deleteProdotto(nomeProdottoDaEliminare);
                  System.out.println("Prodotto eliminato");
               }
               else if(scelta == 3)
               {
                  // Chiedo all'utente di inserire il nome e il costo del prodotto che si vuole modificare
                  System.out.print("Inserire il nome del prodotto da modificare: ");
                  String nomeProdotto = input.next();
                  System.out.print("Inserire il costo del prodotto da modificare: ");
                  double costoProdotto = input.nextDouble();

                  // Chiedo all'utente i nuovi parametri da inserire  
                  System.out.print("Inserire il nuovo nome del prodotto: ");
                  String nomeProdottoAg = input.next();
                  System.out.print("Inserire il nuovo costo del prodotto: ");
                  double costoProdottoAg = input.nextDouble();
                  System.out.print("Inserire la nuova quantita' del prodotto: ");
                  int quantita = input.nextInt();

                  // Chiamo il metodo per aggiornare il prodotto 
                  vetProdotti.setProdotto(nomeProdotto, costoProdotto, nomeProdottoAg, costoProdottoAg, quantita);
                  System.out.println("Prodotto Aggiornato");
               }
               else if (scelta == 4) 
               {
                  // Stampo i prodotti 
                  vetProdotti.stampaProdotti();
               }
            } while (scelta != 5);
         }
         else // Se user 
         {
            // Menù per la gestione degli articoli 
            do 
            {
               System.out.println();
               System.out.println("Menu'");
               System.out.println("1 Modifica un prodotto");
               System.out.println("2 Visualizza prodotti");
               System.out.println("3 Esci");
               System.out.print("Scelta: ");
               scelta = input.nextInt();
               
               if(scelta == 1)
               {
                  // Chiedo all'utente di inserire il nome e il costo del prodotto che si vuole modificare
                  System.out.print("Inserire il nome del prodotto da modificare: ");
                  String nomeProdotto = input.next();
                  System.out.print("Inserire il costo del prodotto da modificare: ");
                  double costoProdotto = input.nextDouble();

                  // Chiedo all'utente i nuovi parametri da inserire  
                  System.out.print("Inserire il nuovo nome del prodotto: ");
                  String nomeProdottoAg = input.next();
                  System.out.print("Inserire il nuovo costo del prodotto: ");
                  double costoProdottoAg = input.nextDouble();
                  System.out.print("Inserire la nuova quantita' del prodotto: ");
                  int quantita = input.nextInt();

                  // Chiamo il metodo per aggiornare il prodotto 
                  vetProdotti.setProdotto(nomeProdotto, costoProdotto, nomeProdottoAg, costoProdottoAg, quantita);
                  System.out.println("Prodotto Aggiornato");
               }
               else if (scelta == 2) 
               {
                  // Stampo i prodotti 
                  vetProdotti.stampaProdotti();
               }
            } while (scelta != 3);
         }
      }
      else
      {
         System.out.println("Utente bloccato");
      }

      input.close();
   }
}