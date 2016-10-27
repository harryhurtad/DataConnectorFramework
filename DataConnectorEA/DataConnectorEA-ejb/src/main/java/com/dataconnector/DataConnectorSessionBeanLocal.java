/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector;

import javax.ejb.Local;

/**
 *
 * @author proveedor_hhurtado
 */
@Local
public interface DataConnectorSessionBeanLocal {
   
      public void excecuteMultiThreadStatemntDataConn();

    public void excecuteSingleThreadStatemntDataConnector();
}
