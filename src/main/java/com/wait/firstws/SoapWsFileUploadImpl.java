package com.wait.firstws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService(endpointInterface="com.wait.firstws.SoapWsFileUpload", serviceName="SoapWsFileUpload")
public class SoapWsFileUploadImpl implements SoapWsFileUpload {

	@Override
	public void uploadFile(DataHandler attachinfo) {
	
		try(InputStream input = attachinfo.getInputStream();
				OutputStream output = new FileOutputStream(new File(
						"/Users/mc/Pictures/java.jpg"));){
				byte[] b = new byte[100000];
				int bytesRead=0;
				while((bytesRead=input.read(b))!=-1) {
					output.write(b, 0, bytesRead);
				}
	} catch (IOException e) {
	}
		
	}

	@Override
	public @XmlMimeType("application/octet-stream")
	DataHandler downloadFile() {
		DataSource source = new FileDataSource(new File("/Users/mc/Pictures/java.jpg"));
		return new DataHandler(source);
	}

}
