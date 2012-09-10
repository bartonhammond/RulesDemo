package com.acclivyx.webservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;

@Provider
public class RulesServiceExceptionMapper implements ExceptionMapper<RuleArgsInvalid>{
	 @Context
	    private HttpHeaders headers;
	
	 @Override
	public Response toResponse(RuleArgsInvalid e) {
		return Response.status(Status.BAD_REQUEST)
				. entity(e.getMessage())
				. type(headers.getMediaType())
				. build(); 

	}

}
