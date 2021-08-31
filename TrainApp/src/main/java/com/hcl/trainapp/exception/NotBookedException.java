package com.hcl.trainapp.exception;

public class NotBookedException extends Exception {
	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7665090830066232467L;
		
		private String message;

	 

	    public NotBookedException(String message) {
	        super(message);
	        this.message = message;
	    }

	 

	    public NotBookedException() {
	        super();
	    }

	}



