package lya_1_t2;

public class LyA_1_T2 {

    public static void main(String[] args) {
        String fecha = "16/09/2021 05:16 PM";
        Analizador obj = new Analizador(fecha);
        System.out.println(obj.isTrue());
    }

}

class Analizador {

    private final String[] array;

    Analizador(String txt) {
        this.array = txt.trim().split(" |/|:");
    }

    /**
     * Metdodo el cual llama al metodo evalucacion para evaluar el arreglo
     * compuesto por una cadena return true si la evalucacion es true o false si
     * el la evaluacion es falsa o el tamaño del arreglo no es el correcto
     */
    public boolean isTrue() {
        if (array.length != 6) {
            return false;
        }
        return Evaluacion(array, 0);
    }

    /**
     * @param array arreglo con objetos a evaluar
     * @param i posicion del arreglo
     * @return true si el recorrido del arreglo llega a su fin
     *
     */
    private boolean Evaluacion(String[] array, int i) {
        if (i < array.length) {
            if (array[i].isEmpty()) {
                return false;
            }
            if (type(i, array[i])) {
                return Evaluacion(array, i + 1);
            }
        }
        return i == array.length;
    }

    /**
     * @param i posicion del arreglo
     * <br> se denomina a x dia,mes,año,hora o minuto segun su posicion en el
     * arreglo
     * <br> posicon dada por i
     *
     * @param x objeto del arreglo arreglo a evaluar
     *
     * @return true si el objeto x cumple ciertas caracteristicas segun su caso
     *
     *
     */
    public boolean type(int i, String x) {
        int y = 0;
        switch (i) {
            case 0:
                //Dias
                y = Integer.parseInt(x);
                return y > 0 && y < 32;
            case 1:
                //Meses
                y = Integer.parseInt(x);
                return y > 0 && y <= 12;
            case 2:
                //Años
                y = Integer.parseInt(x);
                return y > 2000 && y < 2500;
            case 3:
                //Hora
                y = Integer.parseInt(x);
                return y > 0 && y <= 12;
            case 4:
                //Minutos
                y = Integer.parseInt(x);
                return y >= 0 && y < 60;
            case 5:
                //PM o AM
                return x.equalsIgnoreCase("PM") || x.equalsIgnoreCase("AM");
        }
        return false;
    }

}
