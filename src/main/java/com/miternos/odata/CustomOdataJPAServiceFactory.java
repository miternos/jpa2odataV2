package com.miternos.odata;



import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by miternos on 7/26/17.
 */
public class CustomOdataJPAServiceFactory extends ODataJPAServiceFactory {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomOdataJPAServiceFactory.class);

    private static final String PUNIT_NAME = "com.miternos.odata";

    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
        try {

            ODataJPAContext oDataJPAContext = getODataJPAContext();
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PUNIT_NAME );
            oDataJPAContext.setEntityManagerFactory(emFactory);
            oDataJPAContext.setPersistenceUnitName(PUNIT_NAME);

            /*
            SessionFactory sf = ((EntityManagerFactoryImpl) emFactory).getSessionFactory();

            Session session = sf.openSession();
            Criteria criteria = session.createCriteria(Agency.class);

            List<Agency> list = criteria.list();
            for (Agency e : list) {
                System.out.println("Agency.id is " + e.getId().getAgencyId());

            }

            session.close();
            */


            return oDataJPAContext;
        } catch (Exception e) {

            logger.error(e.getMessage(),e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T extends ODataCallback> T getCallback(final Class<T> callbackInterface) {
        T callback;

        if (callbackInterface.isAssignableFrom(CustomOdataErrorCallback.class)) {
            callback = (T) new CustomOdataErrorCallback();
        } else {
            callback = (T) super.getCallback(callbackInterface);
        }

        return callback;
    }
}
