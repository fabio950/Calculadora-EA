/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface CalculadoraServiceLocal {

    double calculaAreaCirculo(double radio);

    double calcularAreaCuadrado(double lado);

    double calculaAreaTriangulo(double base, double altura);
    
    double calculaAreaTrapecio(double altura, double base1, double base2);
}
