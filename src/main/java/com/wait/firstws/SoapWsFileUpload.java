package com.wait.firstws;
import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService 
public interface SoapWsFileUpload {

	void uploadFile(@WebParam(name="file") DataHandler attachinfo);
	DataHandler downloadFile();
}
