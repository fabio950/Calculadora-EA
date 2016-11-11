/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class CalculadoraService implements CalculadoraServiceLocal {

    @Override
    public double calculaAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2.0);
    }

    @Override
    public double calcularAreaCuadrado(double lado) {
        return lado*lado;
    }
    
    @Override
    public double calculaAreaTriangulo(double base, double altura) {
        return (base*altura)/2;
    }
    
    @Override
    public double calculaAreaTrapecio(double altura, double base1, double base2){
        return ((base1 + base2)*altura)/2;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}