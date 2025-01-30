
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
    private byte[] DemoFoto;
    
    @Override
     public String toString(){
        return  this.getNomExercici();
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

    /**
     * @return the DemoFoto
     */
    public byte[] getDemoFoto() {
        return DemoFoto;
    }

    /**
     * @param DemoFoto the DemoFoto to set
     */
    public void setDemoFoto(byte[] DemoFoto) {
        this.DemoFoto = DemoFoto;
    }

}
