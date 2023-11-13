package gestione_utenze;

/**
 * Struttura per conservare i dati dell'utente
 * 
 * La stringa vuota indica un campo non inizializzato
 * 
 * N.B.
 * La password viene criptata tramite l'algoritmo
 * di hashing SHA2 a 256 bit
 */
class Utente {
   
   // Dati dell'utente
   private String username;
   private String password;
   private String nome;
   private String cognome;
   private String email;

   // Costruttore per l'inizalizzazione dei campi
   public Utente(String username, String password, String nome, String cognome, String email) {
      this.username = username;
      this.password = password;
      this.nome = nome;
      this.cognome = cognome;
      this.email = email;
   }

   public String getUsername() {
      return this.username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCognome() {
      return this.cognome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
