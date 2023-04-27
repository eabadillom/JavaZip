package com.eabm.logic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eabm.model.JZFile;
import com.eabm.tools.IOTools;

public class CompressLogic {
	
	private static Logger log = LogManager.getLogger();
	
	private List<JZFile> jzFileList = null;
	
	public CompressLogic() {
		this.jzFileList = new ArrayList<JZFile>();
	}

	public List<JZFile> getJzFileList() {
		return jzFileList;
	}

	public void setJzFileList(List<JZFile> jzFileList) {
		this.jzFileList = jzFileList;
	}
	
	public byte[] compress() {
		byte[] zipFile = null;
		
		ByteArrayOutputStream output = null;
		ZipOutputStream zipOutput = null;
		ZipEntry entry = null;
		
		InputStream input = null;
		
		try {
			output = new ByteArrayOutputStream();
			zipOutput = new ZipOutputStream(output);
			
			for(JZFile file : this.jzFileList) {
				entry = new ZipEntry(file.getFileName());
				zipOutput.putNextEntry(entry);
				
				input = new ByteArrayInputStream(file.getContent());
				
				byte[] bytes = new byte[1024];
				int length;
				while((length = input.read(bytes)) >= 0) {
	                zipOutput.write(bytes, 0, length);
	            }
				IOTools.close(input);
			}
			
			zipFile = output.toByteArray();
			
		} catch(Exception ex) {
			log.error("Error while creating zip file...", ex);
		} finally {
			IOTools.close(output);
			IOTools.close(zipOutput);
		}
		
		return zipFile;
	}
}
