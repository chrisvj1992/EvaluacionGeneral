package uaslp.objetos.escuela;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise6 {

     /*
    INSTRUCCIONES EJERCICIO 6:

    PARA ESTE EJERCICIO DEBERÁS:
    -> Crear Elementos necesarios para que el programa compile
    -> Lograr un 100% de coverage de la clase AlgoritmoX

    En este ejercicio los tests que crees deberán estar en esta clase, es el UNICO
    ejercicio en el que se te permite modificar el Unit Test, PERO está prohibido
    modificar el test existente "validarInterfacesCreadas"

     */

    @Test
    public void validarInterfacesCreadas(){
        assertThat(Dependencia1.class).isInterface();
        assertThat(Dependencia2.class).isInterface();
        assertThat(Dependencia3.class).isInterface();
    }


    @Test
    public void Test1(){
        Dependencia1 dependencia1 = Mockito.mock(Dependencia1.class);
        Dependencia2 dependencia2 = Mockito.mock(Dependencia2.class);
        Dependencia3 dependencia3 = Mockito.mock(Dependencia3.class);
        AlgoritmoX algoritmo = new AlgoritmoX(
                dependencia1,
                dependencia2,
                dependencia3);
        int num1 = 3, num2 = 8;
        String message = "la cadenita de carmen";

        algoritmo.algoritmoACubrir(num1,num1,message);
        Mockito.verify(dependencia1).save(message);

        algoritmo.algoritmoACubrir(num1,num2,message);
        Mockito.verify(dependencia2).print(num1,message);

        algoritmo.algoritmoACubrir(num2,num1,message);
        Mockito.verify(dependencia3).send(num2,num1);

        Mockito.verify(dependencia3).recover();

    }
}
