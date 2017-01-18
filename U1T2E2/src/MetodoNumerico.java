


public class MetodoNumerico {
    Fila f;
    double coef[], intervalo[], h;
    
    public MetodoNumerico(int index, VentanaDatos v){
            switch(index){
        case 1:{
            f = new Fila(1,"e^x");
            break;
        }
        case 2:{
            f = new Fila(1,"e^(-x)");
            break;
        }
        case 3:{
            f = new Fila(1, "e^(-x)");
            break;
        }
        case 4:{
            f = new Fila(1,"1/(1-x)");
            break;
        }
        case 5:{ 
            f = new Fila(4, "Pi"); 
            v.txtX.setText("0");
            v.txtX.setEditable(false);
            break; 
        }
        case 6:{ 
            f = new Fila(1, "Pi/4"); 
            v.txtX.setText("0");
            v.txtX.setEditable(false);
            break;
        }
        case 7:{
            f = new Fila(0,"ln(x+1)");
            break;
        }
        case 8:{
            f = new Fila(0,"Sin(x)");
            break;
        }
        case 9:{
            f = new Fila(1,"Cos(x)");
            break;
        }
        case 10:{
            f = new Fila(0,"Tan^-1(x)");
            break;
        }
        case 11:{
            f = new Fila(0,"Sinh(x)");
            break;
        }
        case 12:{
            f = new Fila(1,"Cosh(x)");
            break;
        }
        case 13:{
            f = new Fila(2, "Pi");
            v.txtX.setText("0");
            v.txtX.setEditable(false);
            break;
        }
        case 14:{
            f = new Fila(0,"ax^4+bx^3+cx^2+dx+e");
            v.lblCifras.setText("Coef=");
            v.lblEjemplo.setText("Ejemplo a,b,c,d,e");
            v.lblEjemplo2.setText("Intervalo Int1,Int2");
            break;
        }
        }
    }
    
    public boolean calcularVv(int index, double x){
        switch(index){
        case 1:{
            f.Vv = Math.exp(x);
            f.x = x;
            return true;
        }
        case 2:{
            f.Vv = Math.exp(-x);
            f.x = x;
            return true;
        }
        case 3:{
            f.Vv = Math.exp(-x);
            f.x = x;
            return true;
        }
        case 4:{
            if(!(Math.abs(x) < 1) || x == 1){return false;}
            f.Vv = Math.pow(1-x,-1);
            f.x= x;
            return true;
        }
        case 5:{ 
            f.Vv = Math.PI; 
            return true;
        }
        case 6:{
            f.Vv = Math.PI/4;
            return true;
        }
        case 7:{
            if(x<=-1 || x > 1){return false;}
            f.aproximacion = x;
            f.Vv = Math.log(x+1);
            f.x = x;
            return true;
        }
        case 8:{
            f.aproximacion = x;
            f.Vv = Math.sin(x);
            f.x = x;
            return true;
        }
        case 9:{
            f.Vv = Math.cos(x);
            f.x = x;
            return true;
        }
        case 10:{
            f.Vv = Math.atan(x);
            f.aproximacion = x;
            f.x = x;
            return true;
        }
        case 11:{
            f.Vv = Math.sinh(x);
            f.aproximacion = x;
            f.x = x;
            return true;
        }
        case 12:{
            f.Vv = Math.cosh(x);
            f.x = x;
            return true;
        }
        case 13:{
            f.Vv = Math.PI;
            f.n = 0.;
            f.d = 1.;
            return true;
            }
        }
        return false;
    }
    
    public void calcularVv14(String coeficientes, String intervalos){
            String arr1[] = coeficientes.split(",");
            String arr2[] = intervalos.split(",");
            coef = new double[5];
            intervalo = new double[2];
            intervalo[0] = Double.parseDouble(arr2[0]);
            intervalo[1] = Double.parseDouble(arr2[1]);
            h = intervalo[1]-intervalo[0];
            for(int i = 0; i <= 4; i++){
                coef[i] = Double.parseDouble(arr1[i]);
            }
            f.aproximacion =  coef[0]*(Math.pow(intervalo[0], 4))
                  +coef[1]*(Math.pow(intervalo[0], 3))
                  +coef[2]*(Math.pow(intervalo[0], 2))
                  +coef[3]*intervalo[0]
                  +coef[4];
            f.Vv = coef[0]*(Math.pow(intervalo[1], 4))
                  +coef[1]*(Math.pow(intervalo[1], 3))
                  +coef[2]*(Math.pow(intervalo[1], 2))
                  +coef[3]*intervalo[1]
                  +coef[4];
    }
    
    public void calcularEs(int n){
        f.es = 0.5*Math.pow(10, 2-n);
    }
    
    
    
    public void Fila(int index){
        f.iteracion++;
        switch(index){
        case 1:{
            serie1();
            break;
        }
        case 2:{
            serie2();
            break;
        }
        case 3:{
            serie3();
            break;
        }
        case 4:{
            serie4();
            break;
        }
        case 5:{
            serie5();
            break;
        }
        case 6:{
            serie6();
            break;
        }
        case 7:{
            serie7();
            break;
        }
        case 8:{
            serie8();
            break;
        }
        case 9:{
            serie9();
            break;
        }
        case 10:{
            serie10();
            break;
        }
        case 11:{
            serie11();
            break;
        }
        case 12:{
            serie12();
            break;
        }
        case 13:{
            serie13();
            break;
        }
        case 14:{
            serie14();
            break;
        }
        }
    }
    
    private void serie1(){
     double aproxAnt = f.aproximacion;
     f.aproximacion += Math.pow(f.x, f.iteracion-1)/factorial(f.iteracion-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)*Math.pow((f.aproximacion),-1))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    public void serie2(){
     double aproxAnt = f.aproximacion;
     double aux = Math.pow(aproxAnt, -1);
     aux += Math.pow(f.x, f.iteracion-1)/factorial(f.iteracion-1);
     f.aproximacion = Math.pow(aux, -1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;} 
    }
    
    private void serie3(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*Math.pow(f.x, f.iteracion-1)/factorial(f.iteracion-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;} 
     
    }
    
    private void serie4(){
     double aproxAnt = f.aproximacion;
     f.aproximacion += Math.pow(f.x, f.iteracion-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;} 
    }
    
    private void serie5(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*4*Math.pow((f.iteracion*2)-1, -1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if((f.ea < f.es) && (signo < 0)){f.aceptacion = true;}
    }
    
    private void serie6(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*Math.pow((f.iteracion*2)-1, -1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if((f.ea < f.es) && (signo < 0)){f.aceptacion = true;}
    }
    
    private void serie7(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*Math.pow(f.x,f.iteracion)/f.iteracion;
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie8(){
     double aproxAnt = f.aproximacion;
     int signo = (int)Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*(Math.pow(f.x, (2*f.iteracion)-1)/factorial((2*f.iteracion)-1));
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie9(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*Math.pow(f.x, 2*(f.iteracion-1))/factorial(2*(f.iteracion-1));
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie10(){
     double aproxAnt = f.aproximacion;
     double signo = Math.pow(-1, f.iteracion-1); 
     f.aproximacion += signo*Math.pow(f.x, (2*f.iteracion)-1)/((2*f.iteracion)-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie11(){
     double aproxAnt = f.aproximacion;
     f.aproximacion += Math.pow(f.x, (2*f.iteracion)-1)/factorial((2*f.iteracion)-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie12(){
     double  aproxAnt = f.aproximacion;
     f.aproximacion += Math.pow(f.x, (f.iteracion-1)*2)/factorial((int)(f.iteracion-1)*2);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }
    
    private void serie13(){
     double aproxAnt = f.aproximacion;
     if((f.iteracion%2) == 0) {f.n += 2.;}
     if(((f.iteracion-1)%2) == 0) {f.d += 2.;}
     f.aproximacion *= (f.n/f.d);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.ea < f.es){f.aceptacion = true;}
    }

    private void serie14(){
     double aproxAnt = f.aproximacion;
     double funcion=0;
     switch(f.iteracion){
         case 2:{
             funcion =  4.*coef[0]*(Math.pow(intervalo[0], 3))
                  +3.*coef[1]*(Math.pow(intervalo[0], 2))
                  +2.*coef[2]*intervalo[0]
                  +coef[3];
             break;
         }
         case 3:{
             funcion =  12.*coef[0]*(Math.pow(intervalo[0], 2))
                  +6.*coef[1]*intervalo[0]
                  +2.*coef[2];
             break;
         }
         case 4:{
             funcion =  24.*coef[0]*intervalo[0]
                  +6.*coef[1];
             break;
         }
         case 5:{
             funcion =  24.*coef[0];
             break;
         }
     }
        f.aproximacion += funcion*Math.pow(h, f.iteracion-1)*Math.pow(factorial(f.iteracion-1),-1);
     f.ea = Math.abs((f.aproximacion-aproxAnt)/(f.aproximacion))*100.;
     if(f.iteracion == 5){f.aceptacion = true;}
    }
    
    public static double factorial(double n) {
        double fact = 1;
        for (double i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
}
