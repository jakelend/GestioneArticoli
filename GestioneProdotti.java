import java.util.ArrayList;

// Classe utilizzata per la gestione dei prodotti all'interno del magazzino 
public class GestioneProdotti 
{
   // Proprietà, ArrayList per memorizzare tutti i prodotti dell'utente 
   ArrayList<Prodotto> vetProdotti;

   // Costruttore di default 
   public GestioneProdotti()
   {
   
   }

   // Metodi per effettuare le varie operazioni sul vettore di prodotti 
   void addProdotto(Prodotto prodotto)
   {
      // Ricrco il prodotto nel vettore 
      // se lo trovo il flag diventa false, se non lo trovo rimane true 
      boolean flag = true;

      // Ricerca del prodotto tramite il nome ed il costo
      for (int i = 0; i < vetProdotti.size(); i++) 
      {
         // Controllo se il prodotto attuale sia quello da elimanre 
         if ((vetProdotti.get(i).nome == prodotto.nome) && (vetProdotti.get(i).costo == prodotto.costo)) 
         {
            // Aggiorno le proprità del prodotto 
            vetProdotti.get(i).quantita += 1;
            flag = false;
         }
      } 
      
      // Verifica se il prodotto non è stato trovato
      if (flag) 
      {
         vetProdotti.add(prodotto);
      }
   }

   // Delete Prodotto 
   void deleteProdotto(String nomeProdotto)
   {
      // Ricerco il prodotto da eliminare 
      for (int i = 0; i < vetProdotti.size(); i++) 
      {
         // Controllo se il prodotto attuale sia quello da elimanre 
         if (vetProdotti.get(i).nome == nomeProdotto) 
         {
            // Elimino il prodotto 
            vetProdotti.remove(i);
         }
      }
   }

   // Aggiorno un prodotto 
   void setProdotto(String vecchioNome, double vecchioCosto, String nuovoNome, double nuovoCosto)
   {
      // Ricerco il prodotto 
      for (int i = 0; i < vetProdotti.size(); i++) 
      {
         // Controllo se il prodotto attuale sia quello da elimanre 
         if ((vetProdotti.get(i).nome == vecchioNome) && (vetProdotti.get(i).costo == vecchioCosto)) 
         {
            // Aggiorno le proprità del prodotto 
            vetProdotti.get(i).nome = nuovoNome;
            vetProdotti.get(i).costo = nuovoCosto;
         }
      }
   }

   // Stampa dei prodotti 
   void stampaProdotti()
   {
      System.out.println(vetProdotti);
   }
}
