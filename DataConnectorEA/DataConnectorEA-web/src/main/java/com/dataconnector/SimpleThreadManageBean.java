/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector;

import com.dataconnector.manager.DataConnector;
import com.prueba.orquestation.bd.TestinSingleton;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author proveedor_hhurtado
 */
@ManagedBean
@SessionScoped
public class SimpleThreadManageBean {
    @EJB(beanName = "DataConnectorSessionBean")
    private com.dataconnector.DataConnectorSessionBeanLocal dataConnectorSessionBean;

    /**
     * Creates a new instance of SimpleThreadManageBean
     */
    public SimpleThreadManageBean() {
        
        
    }
    
    
    public void excecuteSingleThreadStatement(){
        dataConnectorSessionBean.excecuteSingleThreadStatemntDataConnector();
    }
    
    public void excecuteMultiThreadStatement(){
        dataConnectorSessionBean.excecuteMultiThreadStatemntDataConn();
    }
    
    public void realizarConexion(){
        System.err.println("Entro!!");
     dataConnectorSessionBean.excecuteMultiThreadStatemntDataConn();
//       DataConnector.getInitialContextDataConnector(); 
      //  TestinSingleton.prueba();
    }
    
    
    
}
