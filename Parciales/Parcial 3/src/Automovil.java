

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jechague
 */
public class Automovil implements Comparable {

    private String id;
    private String marca;
    private String combustible;
    private String puertas;
    private String tipo;
    private String traccion;
    private String posmotor;
    private Float largo;
    private Float ancho;
    private Float alto;
    private String tipo_motor;
    private String cilindros;
    private Integer tam_motor;
    private String sist_comb;
    private Float diam;
    private Float carrera;
    private Integer compresion;
    private Integer hp;
    private Integer rpm_max;
    private Integer consumo_ciudad;
    private Integer consumo_autopista;
    private Integer precio;
    
    Automovil(String fileLine) throws Exception {
        String[] stringParts = fileLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        
        if (stringParts.length == 22) {
            try {
                this.id = stringParts[0];
                this.marca = stringParts[1];
                this.combustible = stringParts[2];
                this.puertas = stringParts[3];
                this.tipo = stringParts[4];
                this.traccion = stringParts[5];
                this.posmotor = stringParts[6];
                this.largo = Float.parseFloat(stringParts[7].trim());
                this.ancho =  Float.parseFloat(stringParts[8].trim());
                this.alto = Float.parseFloat(stringParts[9].trim());
                this.tipo_motor = stringParts[10];
                this.cilindros = stringParts[11];
                this.tam_motor = Integer.parseInt(stringParts[12].trim());
                this.sist_comb = stringParts[13];
                this.diam = Float.parseFloat(stringParts[14].trim());
                this.carrera = Float.parseFloat(stringParts[15].trim());
                this.compresion = Integer.parseInt(stringParts[16].trim());
                this.hp = Integer.parseInt(stringParts[17].trim());
                this.rpm_max = Integer.parseInt(stringParts[18].trim());
                this.consumo_ciudad = Integer.parseInt(stringParts[19].trim());
                this.consumo_autopista = Integer.parseInt(stringParts[20].trim());
                this.precio = Integer.parseInt(stringParts[21].trim());

            }  catch (NumberFormatException e) {}
        }
    }
    
    public boolean isValid() {
        return (this.hp != null && this.marca != null && this.precio != null);
    }

    public String getMarca() {
        return marca;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getPrecio() {
        return precio;
    }
    
    @Override
    public int compareTo(Object o) {
        if (o.getClass().equals(Automovil.class)) {
            if (this.marca.compareTo(((Automovil)o).marca) == 0) {
                if (this.hp == null) {
                    System.out.println("Holas");
                }
                if (this.hp.compareTo(((Automovil)o).hp) == 0) {
                    return this.precio.compareTo(((Automovil)o).precio);
                }else{
                    return this.hp.compareTo(((Automovil)o).hp);
                }
            } else {
                return this.marca.compareTo(((Automovil)o).marca);
            }
        } else {
            return -1;
        }
    }
}
