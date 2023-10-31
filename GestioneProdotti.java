import java.util.ArrayList;

// Classe utilizzata per la gestione dei prodotti all'interno del magazzino 
public class GestioneProdotti 
{
   // Proprietà, ArrayList per memorizzare tutti i prodotti dell'utente 
   ArrayList<Prodotto> vetProdotti;

   // Costruttore di default 
   public GestioneProdotti()
   {
      vetProdotti = new ArrayList<Prodotto>();
   }

   // Metodi per effettuare le varie operazioni sul vettore di prodotti 
   void addProdotto(Prodotto prodotto)
   {
      // Ricrco il prodotto nel vettore 
      // se lo trovo il flag diventa false, se non lo trovo rimane true 
      boolean flag = true;

      // Controllo se la lista sia vuota 
      if(vetProdotti.isEmpty())
      {
         vetProdotti.add(prodotto);
         flag = false;
      }
      else
      {
         // Ricerca del prodotto tramite il nome ed il costo
         for (int i = 0; i < vetProdotti.size(); i++) 
         {
            // Controllo se il prodotto attuale sia quello da elimanre 
            if ((vetProdotti.get(i).nome.equals(prodotto.nome)) && (vetProdotti.get(i).costo == prodotto.costo)) 
            {
               // Aggiorno le proprità del prodotto 
               vetProdotti.get(i).quantita += prodotto.quantita;
               flag = false;
            }
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
         if (vetProdotti.get(i).nome.equals(nomeProdotto)) 
         {
            // Elimino il prodotto 
            vetProdotti.remove(i);
         }
      }
   }

   // Aggiorno un prodotto 
   void setProdotto(String vecchioNome, double vecchioCosto, String nuovoNome, double nuovoCosto, int quantita)
   {
      // Ricerco il prodotto 
      for (int i = 0; i < vetProdotti.size(); i++) 
      {
         // Controllo se il prodotto attuale sia quello da elimanre 
         if ((vetProdotti.get(i).nome.equals(vecchioNome)) && (vetProdotti.get(i).costo == vecchioCosto)) 
         {
            // Aggiorno le proprità del prodotto 
            vetProdotti.get(i).nome = nuovoNome;
            vetProdotti.get(i).costo = nuovoCosto;
            vetProdotti.get(i).quantita = quantita;
         }
      }
   }

   // Stampa dei prodotti 
   void stampaProdotti()
   {
      if (!vetProdotti.isEmpty()) 
      {
         for (int i = 0; i < vetProdotti.size(); i++) 
         {
            System.out.println("Nome: " + vetProdotti.get(i).nome 
            + " Costo: " + vetProdotti.get(i).costo + " Quantita': "  + vetProdotti.get(i).quantita);
         }
      }
      else
      {
         System.out.println("Nessun prodotto presente");
      }
   }
}
