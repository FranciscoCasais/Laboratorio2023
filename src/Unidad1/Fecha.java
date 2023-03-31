package Unidad1;
public class Fecha {
    private int anio, dia, mes;

    public Fecha() {
        anio = 2023;
        dia = 1;
        mes = 1;
    }

    public void valida() {
        if (anio > 2023) {
            anio = 1900;
        }
        if (mes < 1 || mes > 12) {
            mes = 1;
        }
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia > 31) {
                    dia = 1;
                }
                break;
            case 2:
                if (anio % 4 == 0) {
                    if (dia > 29) {
                        dia = 1;
                    }
                } else if (dia > 28) {
                    dia = 1;
                }
                break;
            default:
                if (dia > 30) {
                    dia = 1;
                }
                break;
        }
    }

    public Fecha(int anio, int dia, int mes) {
        this.anio = anio;
        this.dia = dia;
        this.mes = mes;
        valida();
    }

    public boolean igualQue(Fecha fecha) {
        if (fecha.anio == this.anio && fecha.dia == this.dia && fecha.mes == this.mes) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mayorQue(Fecha fecha) {
        if (fecha.anio > this.anio) {
            return false;
        } else if (fecha.anio < this.anio) {
            return true;
        } else if (fecha.mes > this.mes) {
            return false;
        } else if (fecha.mes < this.mes) {
            return true;
        } else if (fecha.dia > this.dia) {
            return false;
        }
        return true;
    }

    public boolean menorQue(Fecha fecha) {
        if (fecha.anio > this.anio) {
            return true;
        } else if (fecha.anio < this.anio) {
            return false;
        } else if (fecha.mes > this.mes) {
            return true;
        } else if (fecha.mes < this.mes) {
            return false;
        } else if (fecha.dia > this.dia) {
            return true;
        }
        return false;
    }

    public int diasMes(int mes) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return 28;
            default:
                return 30;
        }
    }

    public int getAnio() {
        return anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public void anterior() {
        if (dia == 1 && mes == 1) {
            anio--;
            dia = 31;
            mes = 12;
        } else if (dia == 1 && mes == 3 && anio % 4 == 0) {
            dia = 29;
            mes--;
        } else if (dia == 1 && mes == 3) {
            dia = 28;
            mes--;
        } else if (dia == 1 && (mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) {
            dia = 30;
            mes--;
        } else if (dia == 1) {
            dia = 31;
            mes--;
        } else {
            dia--;
        }
    }

    public void corta() {
        System.out.println(dia + "-" + mes + "-" + anio);
    }

    public void larga() {
        String nombreMes = null;
        switch (mes) {
            case 1:
                nombreMes = "Enero";
                break;
            case 2:
                nombreMes = "Febrero";
                break;
            case 3:
                nombreMes = "Marzo";
                break;
            case 4:
                nombreMes = "Abril";
                break;
            case 5:
                nombreMes = "Mayo";
                break;
            case 6:
                nombreMes = "Junio";
                break;
            case 7:
                nombreMes = "Julio";
                break;
            case 8:
                nombreMes = "Agosto";
                break;
            case 9:
                nombreMes = "Septiembre";
                break;
            case 10:
                nombreMes = "Octubre";
                break;
            case 11:
                nombreMes = "Noviembre";
            case 12:
                nombreMes = "Diciembre";
                break;
        }
        System.out.println(dia + " de " + nombreMes + " de " + anio);
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void siguiente() {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (dia == 31 && mes == 1) {
                    dia = 1;
                    mes++;
                } else {
                    dia++;
                }
                break;
            case 12:
                if (dia == 31) {
                    anio++;
                    dia = 1;
                    mes = 1;
                } else {
                    dia++;
                }
                break;
            case 2:
                if (anio % 4 == 0) {
                    if (dia == 29) {
                        dia = 1;
                        mes++;
                    } else {
                        dia++;
                    }
                } else if (dia == 28) {
                    dia = 1;
                    mes++;
                } else {
                    dia++;
                }
                break;
        }
    }
}