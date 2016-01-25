package edu.gatech.mbsec.adapter.subversion;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import util.FileMetadata;

public class SubversionManager {

	static Map<String, SubversionManager> subversionManagerMap = new HashMap<String, SubversionManager>();
	
	private Map<String, SubversionFile> qNameOslcSubversionFileMap = new HashMap<String, SubversionFile>();
	private String baseHTTPURI;
	
	public SubversionManager(String baseHTTPURI){
		this.baseHTTPURI = baseHTTPURI;	
		if(baseHTTPURI.contains("magicdraw")){
			subversionManagerMap.put("magicdraw", this);
		}
		else if(baseHTTPURI.contains("simulink")){
			subversionManagerMap.put("simulink", this);
		}
		else if(baseHTTPURI.contains("amesim")){
			subversionManagerMap.put("amesim", this);
		}
		
	}
	
	public Collection<SubversionFile> getSubversionFiles() {		
		return qNameOslcSubversionFileMap.values();
	}

	public SubversionFile getFileByURI(String string) {		
		return qNameOslcSubversionFileMap.get(string);
	}
	
	public void convertFileMetaDataIntoRDFSubversionFileResources(ArrayList<FileMetadata> fileMetaDatas) {
		qNameOslcSubversionFileMap.clear();
		for (FileMetadata fileMetaData : fileMetaDatas) {			
			try {
				String filePath = fileMetaData.getPath();
				String filePathWithoutSlashes = filePath.replace("\\", "::");
				SubversionFile subversionFile = new SubversionFile(java.net.URI.create(baseHTTPURI + "/services/"
						+ "subversionfiles/"
						+ filePathWithoutSlashes));
				String fileName = null;
				
				String[] filePathArray = filePath.split("\\\\");
				if(filePathArray.length > 1){
					fileName = filePathArray[filePathArray.length -1];
				}
				else{
					fileName = filePath;
				}
				subversionFile.setName(fileName);	
				subversionFile.setPath(fileMetaData.getPath());	
				subversionFile.setAuthor(fileMetaData.getAuthor());	
				subversionFile.setCommittedDate(fileMetaData.getCommittedDate());
				subversionFile.setRepositoryRootURL(fileMetaData.getRepositoryRootURL());
				subversionFile.setRevision(fileMetaData.getRevision());
				subversionFile.setSvnURL(fileMetaData.getSvnURL());
				qNameOslcSubversionFileMap.put(filePathWithoutSlashes,
						subversionFile);
				
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	public static SubversionManager getSubversionManager(String baseURIString) {
		SubversionManager subversionManager = null;
		if(baseURIString.contains("magicdraw")){
			subversionManager = subversionManagerMap.get("magicdraw");
		}
		else if(baseURIString.contains("simulink")){
			subversionManager = subversionManagerMap.get("simulink");
		}
		else if(baseURIString.contains("amesim")){
			subversionManager = subversionManagerMap.get("amesim");
		}
		return subversionManager;		
	}
}
