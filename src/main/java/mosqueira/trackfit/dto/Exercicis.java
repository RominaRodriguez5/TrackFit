
package mosqueira.trackfit.dto;

/**
 *
 * @author Lulas
 */
public class Exercicis {

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    private String NomExercici;
    private String Descripcio;
    private int Id;
    
    @Override
     public String toString(){
        return  this.getNomExercici()+" "+this.Id;
    }
    /**
     * @return the NomExercici
     */
    public String getNomExercici() {
        return NomExercici;
    }

    /**
     * @param NomExercici the NomExercici to set
     */
    public void setNomExercici(String NomExercici) {
        this.NomExercici = NomExercici;
    }

    /**
     * @return the Descripcio
     */
    public String getDescripcio() {
        return Descripcio;
    }

    /**
     * @param Descripcio the Descripcio to set
     */
    public void setDescripcio(String Descripcio) {
        this.Descripcio = Descripcio;
    }

}
