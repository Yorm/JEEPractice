/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.annotationjpa;

import javax.persistence.*;


@Embeddable
public class Address {
    @Column(name="HOME_STREET")
    private String street;
    @Column(name="HOME_CITY")
    private String city;
    @Column(name="HOME_STATE")
    private String state;
    @Column(name="HOME_ZIP")
    private String zipCode;
    
}
