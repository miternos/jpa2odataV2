package com.miternos.odata;

import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPAErrorCallback;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPAException;

/**
 * Created by miternos on 7/28/17.
 */
public class CustomOdataErrorCallback extends ODataJPAErrorCallback {

    @Override
    public ODataResponse handleError(ODataErrorContext context) throws ODataApplicationException {
        System.out.println(context.getException().getClass().getName() + ":" + context.getMessage());
        context.getException().printStackTrace();
        return EntityProvider.writeErrorDocument(context);
    }

}
