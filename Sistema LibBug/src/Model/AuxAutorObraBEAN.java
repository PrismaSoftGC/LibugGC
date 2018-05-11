package Model;

public class AuxAutorObraBEAN {
    
    private int codigoAutor;
    private int codigoObra;
    
    public AuxAutorObraBEAN(int codigoAutor, int codigoObra){
        this.codigoAutor= codigoAutor;
        this.codigoObra= codigoObra;
    }

    public AuxAutorObraBEAN(){
        
    }
    
    public int getCodigoAutor(){
        return codigoAutor;
    }
    
    public void setCodigoAutor(int codigoAutor){
        this.codigoAutor = codigoAutor;
    }

    public int getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(int codigoObra) {
        this.codigoObra = codigoObra;
    }
    
    
}
