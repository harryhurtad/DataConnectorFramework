/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector;

import com.dataconnector.constans.ProvidersSupportEnum;
import com.dataconnector.manager.DataConnector;
import com.dataconnector.context.InitialContextDataConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author proveedor_hhurtado
 */
//@Singleton
//@LocalBean
//@Startup

public class NewSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public static InitialContextDataConnector context;
    
    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private void prueba(){
      /*  try {
             context=DataConnector.getInitialContextDataConnector(getDataSource(),ProvidersSupportEnum.SQLSERVER);
        } catch (Exception ex) {
            Logger.getLogger(NewSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    @PreDestroy
    private void shtudown(){}
    
    
    private DataSource   getDataSource() throws Exception {

        String DATASOURCE_CONTEXT = "jdbcunicodb_1";
        DataSource datasource =null;
        // result = null;
        try {
            Context initialContext = new InitialContext();
            if (initialContext == null) {
                // System.out.println("Problemas con la obtencion del contexto JNDI " );
                 throw new Exception("Problemas con la obtencion del contexto JNDI");
                //  log("JNDI problem. Cannot get InitialContext.");
            }
             datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
         
            if (datasource == null) {
                throw new Exception("Problemas al obtener el contexto");
               
            } 
        } catch (NamingException ex) {
            //   log("Cannot get connection: " + ex);
            System.out.println("Upss Problemas:" + ex);
        } 
        return datasource;
    }
}
