/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.entity;

import com.dataconnector.annotation.DataConnectorAttributes;
import com.dataconnector.annotation.DataConnectorPOJO;
import java.math.BigInteger;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 28/03/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
@DataConnectorPOJO
public class TlfDTO {

    // @DataConnectorAttributes(name = "idTLF")
     @QuerySqlField(name="idTLF")
    private BigInteger idTlf;
    // @DataConnectorAttributes(name = "ID")
     @QuerySqlField(name="ID")
     private BigInteger idAdquiriente;
     

    public BigInteger getIdTlf() {
        return idTlf;
    }

    public void setIdTlf(BigInteger idTlf) {
        this.idTlf = idTlf;
    }

    public BigInteger getIdAdquiriente() {
        return idAdquiriente;
    }

    public void setIdAdquiriente(BigInteger idAdquiriente) {
        this.idAdquiriente = idAdquiriente;
    }

  
    
    
}
