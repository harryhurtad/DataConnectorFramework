/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector;

import com.dataconnector.criteria.CriteriaQuery;
import com.dataconnector.entity.TlfDTO;
import com.dataconnector.manager.DataConnector;
import com.dataconnector.manager.DataConnectorFactory;
import com.dataconnector.manager.DataConnectorSQLServerManager;
import com.dataconnector.context.InitialContextDataConnector;
import com.dataconnector.query.SQLServerQuery;
import com.dataconnector.exceptions.DataConnectorQueryException;
import com.dataconnector.exceptions.DataConnectorResultException;
import com.dataconnector.exceptions.InitialCtxDataConnectorException;
import com.dataconnector.sql.CriteriaBuilder;
import com.dataconnector.sql.Root;
import com.dataconnector.table.UNICO_TLF;
import com.prueba.orquestation.bd.TestinSingleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author proveedor_hhurtado
 */
@Stateless(name = "DataConnectorSessionBean")
public class DataConnectorSessionBean implements DataConnectorSessionBeanLocal {

    @Inject
    InitialContextDataConnector ctx;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void excecuteMultiThreadStatemntDataConn() {

        try {
            DataConnectorFactory factory = ctx.createDataConnectorFactory("ConnectorSQLServerUNICO");
            DataConnectorSQLServerManager manager = (DataConnectorSQLServerManager) factory.getInstanceDataConnectorManager();
            CriteriaBuilder cb = manager.getCriterialBuilder();
            //Elaboracion del query
            CriteriaQuery cq = (CriteriaQuery) cb.createQuery(TlfDTO.class);
            Root unicoIDTLF = cq.from(UNICO_TLF.class);

            cq.select(unicoIDTLF.get(UNICO_TLF.idTLF).alias("idTlf"));
            cq.where(cb.equal(unicoIDTLF.get(UNICO_TLF.idAdquiriente), cb.value(String.class, "23")));
            // Root unicoAdquiriente = cq.from("UNICO_ADQUIRIENTE");
            // cq.select( unicoAdquiriente.get("ID").alias("idAdquiriente"));
            SQLServerQuery query = manager.createQuery(cq);
            query.setFieldRowIndex(unicoIDTLF.get(UNICO_TLF.idTLF));
            query.isSelectForRowNumber(false);
            //query.setFieldRowNumber(unicoAdquiriente.get("ID"));
            // query.setNumeroRegistrosHilo(1500000);
            query.setNumeroRegistrosHilo(180000);
            query.excuteMultiThread(true);

            List<TlfDTO> listTLF = query.getResultList();
            System.out.println("Total:" + listTLF.size());

            //             try {
            /*    DataConnectorFactory factory = DataConnector.createDataConnectorFactory(ProvidersSupportEnum.SQLSERVER, NewSessionBean.context);
            DataConnectorSQLServerManager manager = (DataConnectorSQLServerManager) factory.getDataConnectorManager();
            CriteriaBuilder cb = manager.getCriterialBuilder();
            Elaboracion del query
            CriteriaQuery cq = (CriteriaQuery) cb.createQuery(TlfDTO.class);
            Root unicoIDTLF = cq.from("UNICO_TLF");
            Joins
            Join unicoAdquiriente = unicoIDTLF.joinTable("UNICO_ADQUIRIENTE", JoinsTypeEnum.INNER_JOIN);
            JoinPredicate predicateTLF = cb.and(cb.equal(unicoIDTLF.get("numeroRecibo"), unicoAdquiriente.get("numeroRecibo")),
            cb.equal(unicoIDTLF.get("idOperacionDebito"), unicoAdquiriente.get("idOperacionDebito")),
            cb.equal(unicoAdquiriente.get("fechaNegocio"), cb.value(String.class, "2015-11-11")),
            cb.equal(unicoAdquiriente.get("idTerminal"), cb.value(Integer.class, new Integer("11005"))));
            unicoAdquiriente.On(predicateTLF);
            
            cq.select(unicoIDTLF.get("idTLF").alias("idTlf"), unicoAdquiriente.get("ID").alias("idAdquiriente"));
            Where
            cq.where(cb.equal(unicoIDTLF.get("idAdquiriente"), cb.value(Integer.class, new Integer("52"))));
            Root unicoAdquiriente = cq.from("UNICO_ADQUIRIENTE");
            cq.select( unicoAdquiriente.get("ID").alias("idAdquiriente"));
            SQLServerQuery query = manager.createQuery(cq);
            query.setFieldRowNumber(unicoIDTLF.get("idTLF"));
            query.setFieldRowNumber(unicoAdquiriente.get("ID"));
            query.setNumeroRegistrosHilo(1220000);
            query.excuteMultiThread(true);
            
            List<TlfDTO> listTLF = query.getResultList();
            System.out.println("Total:" + listTLF.size());
            } catch (Exception ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 /*        } catch (DataConnectorQueryException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DataConnectorResultException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (DataConnectorResultException | DataConnectorQueryException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void excecuteSingleThreadStatemntDataConnector() {
          try {
            DataConnectorFactory factory = ctx.createDataConnectorFactory("ConnectorSQLServerUNICO");
            DataConnectorSQLServerManager manager = (DataConnectorSQLServerManager) factory.getInstanceDataConnectorManager();
            CriteriaBuilder cb = manager.getCriterialBuilder();
            //Elaboracion del query
            CriteriaQuery cq = (CriteriaQuery) cb.createQuery(TlfDTO.class);
            Root unicoIDTLF = cq.from(UNICO_TLF.class);

            cq.select(unicoIDTLF.get(UNICO_TLF.idTLF).alias("idTlf"));
            cq.where(cb.equal(unicoIDTLF.get(UNICO_TLF.idAdquiriente), cb.value(String.class, "23")));
            // Root unicoAdquiriente = cq.from("UNICO_ADQUIRIENTE");
            // cq.select( unicoAdquiriente.get("ID").alias("idAdquiriente"));
            SQLServerQuery query = manager.createQuery(cq);
            query.setFieldRowIndex(unicoIDTLF.get(UNICO_TLF.idTLF));
            //query.setFieldRowNumber(unicoAdquiriente.get("ID"));
            // query.setNumeroRegistrosHilo(1500000);
           
            query.excuteMultiThread(false);

            List<TlfDTO> listTLF = query.getResultList();
            System.out.println("Total:" + listTLF.size());

            //             try {
            /*    DataConnectorFactory factory = DataConnector.createDataConnectorFactory(ProvidersSupportEnum.SQLSERVER, NewSessionBean.context);
            DataConnectorSQLServerManager manager = (DataConnectorSQLServerManager) factory.getDataConnectorManager();
            CriteriaBuilder cb = manager.getCriterialBuilder();
            Elaboracion del query
            CriteriaQuery cq = (CriteriaQuery) cb.createQuery(TlfDTO.class);
            Root unicoIDTLF = cq.from("UNICO_TLF");
            Joins
            Join unicoAdquiriente = unicoIDTLF.joinTable("UNICO_ADQUIRIENTE", JoinsTypeEnum.INNER_JOIN);
            JoinPredicate predicateTLF = cb.and(cb.equal(unicoIDTLF.get("numeroRecibo"), unicoAdquiriente.get("numeroRecibo")),
            cb.equal(unicoIDTLF.get("idOperacionDebito"), unicoAdquiriente.get("idOperacionDebito")),
            cb.equal(unicoAdquiriente.get("fechaNegocio"), cb.value(String.class, "2015-11-11")),
            cb.equal(unicoAdquiriente.get("idTerminal"), cb.value(Integer.class, new Integer("11005"))));
            unicoAdquiriente.On(predicateTLF);
            
            cq.select(unicoIDTLF.get("idTLF").alias("idTlf"), unicoAdquiriente.get("ID").alias("idAdquiriente"));
            Where
            cq.where(cb.equal(unicoIDTLF.get("idAdquiriente"), cb.value(Integer.class, new Integer("52"))));
            Root unicoAdquiriente = cq.from("UNICO_ADQUIRIENTE");
            cq.select( unicoAdquiriente.get("ID").alias("idAdquiriente"));
            SQLServerQuery query = manager.createQuery(cq);
            query.setFieldRowNumber(unicoIDTLF.get("idTLF"));
            query.setFieldRowNumber(unicoAdquiriente.get("ID"));
            query.setNumeroRegistrosHilo(1220000);
            query.excuteMultiThread(true);
            
            List<TlfDTO> listTLF = query.getResultList();
            System.out.println("Total:" + listTLF.size());
            } catch (Exception ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 /*        } catch (DataConnectorQueryException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DataConnectorResultException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (DataConnectorResultException | DataConnectorQueryException ex) {
            Logger.getLogger(DataConnectorSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /*  @Override
    public void realizarConexion() {

        String DATASOURCE_CONTEXT = "jdbcunicodb_1";

        // result = null;
        try {
            Context initialContext = new InitialContext();
            if (initialContext == null) {
                System.out.println("Problemas con la obtencion del contexto JNDI ");
                //  log("JNDI problem. Cannot get InitialContext.");
            }
            DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);

            if (datasource != null) {
                try (Connection result = datasource.getConnection()) {

                    System.out.println("Conexion realizada exictosamente!!!");
                } catch (SQLException ex) {
                    System.out.println("Problemas con la conexion:" + ex);
                }

            } else {
                // log("Failed to lookup datasource.");
            }
        } catch (NamingException ex) {
            //   log("Cannot get connection: " + ex);
            System.out.println("Upss Problemas:" + ex);
        }*/
}
