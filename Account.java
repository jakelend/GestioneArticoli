public class Account 
{
   // Proprietà
   String nome;
   String psw;
   int livello; // 0 utente - 1 admin

   // User normale solo visualizzazione e modifica 
   // Admin può fare tutto 

   public Account(String nome, String psw, int livello)
   {
      this.nome = nome;
      this.psw = psw;
      this.livello = livello;
   }
}
